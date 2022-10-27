package com.ssau.learn.service;

import com.ssau.learn.dao.BankRepository;
import com.ssau.learn.dto.BankDto;
import com.ssau.learn.mappers.BankMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankServiceTest {

    @Test
    public void testSelect() throws SQLException{

        BankRepository bankRepository = mock(BankRepository.class);
        DataSource dataSource = mock(DataSource.class);
        BankMapper bankMapper = mock(BankMapper.class);
        Connection connection = mock(Connection.class);
        when(dataSource.getConnection()).thenReturn(connection);

        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement("SELECT terbank_id, terbank_name, bik, city FROM Bank")).thenReturn(preparedStatement);

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getLong("terbank_id")).thenReturn(1L).thenThrow(SQLException.class);
        when(resultSet.getString("terbank_name")).thenReturn("Test bank").thenThrow(SQLException.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        BankService bankService = new BankServiceImpl(bankRepository, bankMapper, dataSource);
        List<BankDto> banks = bankService.select();
        Assertions.assertEquals(1, banks.size());
        Assertions.assertEquals(1L, banks.get(0).getId().longValue());
        Assertions.assertEquals("Test bank", banks.get(0).getTerbankName());
    }
}
