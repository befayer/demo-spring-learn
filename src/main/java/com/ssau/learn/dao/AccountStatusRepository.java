package com.ssau.learn.dao;

import com.ssau.learn.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, UID> {

}
