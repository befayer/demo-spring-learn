package com.ssau.learn.dto;

import com.ssau.learn.entity.Account;
import com.ssau.learn.entity.ClientDocument;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class ClientDto implements Serializable {

    private Integer id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private LocalDate birthday;
    private List<ClientDocument> clientDocumentList;
    private List<Account> accountList;

    public ClientDto(Integer id, String firstName, String secondName, String patronymic, LocalDate birthday, List<ClientDocument> clientDocumentList, List<Account> accountList) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.clientDocumentList = clientDocumentList;
        this.accountList = accountList;
    }
}
