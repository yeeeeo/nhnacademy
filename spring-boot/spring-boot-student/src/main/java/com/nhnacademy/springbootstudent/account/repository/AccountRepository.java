package com.nhnacademy.springbootstudent.account.repository;

import com.nhnacademy.springbootstudent.account.domain.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
