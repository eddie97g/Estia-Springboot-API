package com.ttu.estia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "study_preferences")
public class StudyPreferences {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "study_duration")
    private int studyDuration;

    @Column(name = "study_break_duration")
    private int studyBreakDuration;

    @OneToOne
    @JoinColumn(name="studentID")
    @JsonIgnore
    private Student student;

    public StudyPreferences() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(int studyDuration) {
        this.studyDuration = studyDuration;
    }

    public int getStudyBreakDuration() {
        return studyBreakDuration;
    }

    public void setStudyBreakDuration(int studyBreakDuration) {
        this.studyBreakDuration = studyBreakDuration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
