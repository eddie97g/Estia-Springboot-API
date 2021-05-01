package com.ttu.estia.repository;

import com.ttu.estia.entity.Student;
import com.ttu.estia.entity.StudyPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyPreferencesRepository extends JpaRepository<StudyPreferences, Integer> {
    StudyPreferences findByStudent(Student student);
}
