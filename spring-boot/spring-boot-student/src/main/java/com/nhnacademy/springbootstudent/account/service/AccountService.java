package com.nhnacademy.springbootstudent.account.service;

import com.nhnacademy.springbootstudent.account.domain.Account;
import com.nhnacademy.springbootstudent.student.domain.Student;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();
    Account getAccount(Long id);
    Account createAccount(Account account);
    void deleteAccount(Long id);
}
