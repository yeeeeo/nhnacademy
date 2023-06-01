package com.nhnacademy.springbootstudent.student.repository;

import com.nhnacademy.springbootstudent.student.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    void testGetStudents() {
        Student student = new Student(1L, "student1", 80);
        studentRepository.save(student);

        Optional<Student> actual = studentRepository.findById(1L);

        Assertions.assertThat(actual).isPresent();
        Assertions.assertThat(actual.get()).isEqualTo(student);
    }
}