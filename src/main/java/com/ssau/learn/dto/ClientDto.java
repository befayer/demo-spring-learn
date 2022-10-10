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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
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
        accountList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<ClientDocument> getClientDocumentList() {
        return clientDocumentList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) && Objects.equals(firstName, clientDto.firstName) && Objects.equals(secondName, clientDto.secondName) && Objects.equals(patronymic, clientDto.patronymic) && Objects.equals(birthday, clientDto.birthday) && Objects.equals(clientDocumentList, clientDto.clientDocumentList) && Objects.equals(accountList, clientDto.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, patronymic, birthday, clientDocumentList, accountList);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", clientDocumentList=" + clientDocumentList +
                ", accountList=" + accountList +
                '}';
    }
}
