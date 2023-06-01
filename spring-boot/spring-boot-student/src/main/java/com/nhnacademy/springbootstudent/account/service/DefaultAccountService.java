package com.nhnacademy.springbootstudent.account.service;

import com.nhnacademy.springbootstudent.account.domain.Account;
import com.nhnacademy.springbootstudent.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
