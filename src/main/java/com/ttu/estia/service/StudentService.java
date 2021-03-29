package com.ttu.estia.service;

import com.ttu.estia.entity.Student;
import com.ttu.estia.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(String username) {
        Student student = this.studentRepository.findByUsername(username);

        return student;
    }

    public Student getStudent(Integer id) {
        Student student = this.studentRepository.getOne(id);

        return student;
    }

    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }
}
