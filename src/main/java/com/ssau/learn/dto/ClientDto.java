package com.ssau.learn.dto;

import com.ssau.learn.entity.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
public class ClientDto implements Serializable {

    private Integer id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private LocalDate birthday;
    private List<DocumentDto> documents = new ArrayList<>(); // правильно ли, что DocumentDto, а не Document?

    public ClientDto(String firstName, String secondName, String patronymic, LocalDate birthday) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        documents = new ArrayList<>();
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
    public List<DocumentDto> getDocuments() {return documents;}
    public void setDocument(DocumentDto documentDto){
        documents.add(documentDto);
    }

    public void addDocument(DocumentDto documentDto){
        documents.add(documentDto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) && Objects.equals(firstName, clientDto.firstName) &&
                Objects.equals(secondName, clientDto.secondName) &&
                Objects.equals(patronymic, clientDto.patronymic) &&
                Objects.equals(birthday, clientDto.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, patronymic, birthday);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
