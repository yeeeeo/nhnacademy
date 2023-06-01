package com.nhnacademy.springbootstudent.student.service;

import com.nhnacademy.springbootstudent.student.domain.Student;
import com.nhnacademy.springbootstudent.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhnStudentService implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
