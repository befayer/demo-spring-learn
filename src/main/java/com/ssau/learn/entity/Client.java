package com.ssau.learn.entity;

import com.ssau.learn.dto.DocumentDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "client")
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
            })
    @JoinTable(name = "client_documents",
    joinColumns = { @JoinColumn(name = "client_id")},
    inverseJoinColumns = { @JoinColumn(name = "document_id")})
    private List<Document> documents = new ArrayList<>();

    public Client(String firstName, String secondName, String patronymic, LocalDate birthday){
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.documents = new ArrayList<>();
    }

    public void setDocument(Document document){
        documents.add(document);
    }
}