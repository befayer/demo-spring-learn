package com.ssau.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id")
    @SequenceGenerator(name = "client_id", sequenceName = "client_id", allocationSize = 1)
    @Column(name = "client_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientDocument> clientDocumentList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accountList;

    public Client(String firstName, String secondName, String patronymic, LocalDate birthday){
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        clientDocumentList = new ArrayList<>();
    }
}