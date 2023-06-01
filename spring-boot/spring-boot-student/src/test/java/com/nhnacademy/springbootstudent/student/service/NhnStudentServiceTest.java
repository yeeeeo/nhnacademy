package com.nhnacademy.springbootstudent.student.service;

import com.nhnacademy.springbootstudent.student.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class NhnStudentServiceTest {
    @Autowired
    private StudentService studentService;
    @Test
    void testGetStudents() {
        List<Student> actual = studentService.getStudents();

        log.info(actual.toString());
        Assertions.assertThat(actual).hasSize(2);
    }
}