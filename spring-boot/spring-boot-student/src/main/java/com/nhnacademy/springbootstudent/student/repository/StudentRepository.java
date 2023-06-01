package com.nhnacademy.springbootstudent.student.repository;

import com.nhnacademy.springbootstudent.student.domain.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
}
