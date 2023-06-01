package com.nhnacademy.springbootstudent.account.service;

import com.nhnacademy.springbootstudent.account.domain.Account;
import com.nhnacademy.springbootstudent.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class DefaultAccountService implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 계좌입니다."));
    }

    @Override
    @Transactional
    public Account createAccount(Account account) {
        boolean present = accountRepository.findById(account.getId()).isPresent();
        if (present) throw new IllegalStateException("이미 존재하는 계좌입니다: " + account.getId());
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
