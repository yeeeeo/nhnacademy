package com.nhnacademy.springbootstudent.student.service;

import com.nhnacademy.springbootstudent.student.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(Long id);
    Student createStudent(Student student);
    void deleteStudent(Long id);
}
