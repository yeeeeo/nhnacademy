package com.nhnacademy.springbootstudent.student.service;

import com.nhnacademy.springbootstudent.student.domain.Student;
import com.nhnacademy.springbootstudent.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class NhnStudentService implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 학생입니다."));
    }

    @Override
    @Transactional
    public Student createStudent(Student student) {
        boolean present = studentRepository.findById(student.getId()).isPresent();
        if (present) throw new IllegalStateException("이미 존재하는 학생입니다: " + student.getId());
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
