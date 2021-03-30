package com.ttu.estia.pojo;

import java.util.Date;

public class CalendarEventDto {

    private Integer calendarEventId;

    private Integer studentId;

    private String title;

    private Date timeStart;

    private Date timeEnd;

    private String note;

    public CalendarEventDto() {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCalendarEventId() {
        return calendarEventId;
    }

    public void setCalendarEventId(Integer calendarEventId) {
        this.calendarEventId = calendarEventId;
    }
}
