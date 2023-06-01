package com.nhnacademy.springbootstudent.account.repository;

import com.nhnacademy.springbootstudent.account.domain.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyAccountRepository implements AccountRepository {
    @Override
    public List<Account> findAll() {
        return List.of(new Account(1L, "1111-11-1111111", 500),
                new Account(2L, "222-22-2222222", 1000));
    }
}
