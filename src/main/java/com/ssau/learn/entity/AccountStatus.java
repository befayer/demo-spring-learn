package com.ssau.learn.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_status")
public class AccountStatus {
    @Id
    @Column(name = "account_status_id", nullable = false)
    private Integer id;
    @Column(name = "account_status_name", nullable = false)
    private String accountStatusName;

    public AccountStatus(String accountStatusName){
        this.accountStatusName = accountStatusName;
    }

}