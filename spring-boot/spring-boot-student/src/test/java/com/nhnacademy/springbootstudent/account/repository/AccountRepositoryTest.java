package com.nhnacademy.springbootstudent.account.repository;

import com.nhnacademy.springbootstudent.account.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void testGetAccounts(){
        Account account = new Account(1L, "1111-1111", 500);
        accountRepository.save(account);

        Optional<Account> actual = accountRepository.findById(1L);

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(account);
    }
}