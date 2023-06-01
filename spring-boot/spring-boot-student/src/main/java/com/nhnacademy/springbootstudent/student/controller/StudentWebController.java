package com.nhnacademy.springbootstudent.student.controller;

import com.nhnacademy.springbootstudent.student.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/students")
public class StudentWebController {
    @GetMapping("/{id}")
    public String getStudent(@PathVariable long id, Model model){
        model.addAttribute("student", new Student(1L, "student", 100));
        return "student";
    }
}
