package com.nhnacademy.springbootstudent.account.service;

import com.nhnacademy.springbootstudent.account.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DefaultAccountServiceTest {
    @Autowired
    private AccountService accountService;
    @Test
    void getAccounts() {
        List<Account> actual = accountService.getAccounts();

        log.info(actual.toString());

        Assertions.assertThat(actual).hasSize(2);
    }
}