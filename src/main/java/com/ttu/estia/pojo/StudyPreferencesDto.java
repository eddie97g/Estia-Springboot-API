package com.ttu.estia.pojo;

public class StudyPreferencesDto {

    private int studentID;

    private int studyDuration;

    private int studyBreakDuration;

    public StudyPreferencesDto() {

    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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
}
