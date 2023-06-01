package com.nhnacademy.springbootstudent.student.repository;

import com.nhnacademy.springbootstudent.student.domain.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyStudentRepository implements StudentRepository {
    @Override
    public List<Student> findAll() {
        return List.of(new Student(1L, "학생1", 100),
                new Student(2L, "학생2", 80));
    }
}
