package com.nhnacademy.springbootstudent.account.controller;

import com.nhnacademy.springbootstudent.account.domain.Account;
import com.nhnacademy.springbootstudent.student.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/accounts")
public class AccountWebController {
    @GetMapping("/{id}")
    public String getStudent(@PathVariable long id, Model model){
        model.addAttribute("account", new Account(1L, "1000-1000", 1000));
        return "account";
    }
}
