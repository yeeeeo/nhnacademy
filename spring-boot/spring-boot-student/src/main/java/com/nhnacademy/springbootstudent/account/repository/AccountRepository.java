package com.nhnacademy.springbootstudent.account.repository;

import com.nhnacademy.springbootstudent.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
