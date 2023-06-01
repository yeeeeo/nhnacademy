package com.nhnacademy.springbootstudent.student.controller;

import com.nhnacademy.springbootstudent.student.domain.Student;
import com.nhnacademy.springbootstudent.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRestController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        return ResponseEntity.status(200).body(studentService.getStudent(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.status(201).body(studentService.createStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(204).build();
    }
}
