package com.nhnacademy.springbootstudent.account.controller;

import com.nhnacademy.springbootstudent.account.domain.Account;
import com.nhnacademy.springbootstudent.account.service.AccountService;
import com.nhnacademy.springbootstudent.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountRestController {
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getStudents(){
        return ResponseEntity.status(200).body(accountService.getAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getStudent(@PathVariable long id){
        return ResponseEntity.status(200).body(accountService.getAccount(id));
    }

    @PostMapping
    public ResponseEntity<Account> createStudent(@RequestBody Account account){
        return ResponseEntity.status(201).body(accountService.createAccount(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        accountService.deleteAccount(id);
        return ResponseEntity.status(204).build();
    }
}
