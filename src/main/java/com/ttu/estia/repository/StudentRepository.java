package com.ttu.estia.repository;

import com.ttu.estia.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUsername(String username);
}
