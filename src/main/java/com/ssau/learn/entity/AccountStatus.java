package com.ssau.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account_status")
@Data
@NoArgsConstructor
public class AccountStatus {
    @Id
    @Column(name = "account_status_id", nullable = false)
    private Integer id;

    @Column(name = "account_status_name", nullable = false)
    private String accountStatusName;

    @OneToMany(mappedBy = "accountStatus", cascade = CascadeType.ALL)
    private List<Account> accountList;

    public AccountStatus(String accountStatusName){
        this.accountStatusName = accountStatusName;
        accountList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getAccountStatusName(){
        return accountStatusName;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}