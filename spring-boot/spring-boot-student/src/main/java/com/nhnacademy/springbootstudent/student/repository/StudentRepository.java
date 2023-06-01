package com.nhnacademy.springbootstudent.student.repository;

import com.nhnacademy.springbootstudent.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
