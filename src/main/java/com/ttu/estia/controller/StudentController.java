package com.ttu.estia.controller;

import com.ttu.estia.entity.Student;
import com.ttu.estia.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping()
    public String getUsernameAndPassword() {
        this.studentRepository.existsById(1);
        Student student = this.studentRepository.findByUsername("eddieg");
        System.out.println("Username: " + student.getUsername() + "... Password: " + student.getPassword());
        return "Username: " + student.getUsername() + "... Password: " + student.getPassword();
//        return "success";
    }
}
