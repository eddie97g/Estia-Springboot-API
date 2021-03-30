package com.ttu.estia.controller;

import com.ttu.estia.entity.CalendarEvent;
import com.ttu.estia.entity.Student;
import com.ttu.estia.pojo.CalendarEventDto;
import com.ttu.estia.service.CalendarEventService;
import com.ttu.estia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarEventController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CalendarEventService calendarEventService;

    @PostMapping("/add")
    public ResponseEntity<List<CalendarEvent>> createCalendarEvent(@RequestBody CalendarEventDto calendarEventDto) {

        CalendarEvent calendarEvent = new CalendarEvent();
        calendarEvent.setTitle(calendarEventDto.getTitle());
        Date date = new Date();
        calendarEvent.setTimeStart(date);
        calendarEvent.setTimeEnd(date);
        calendarEvent.setNote(calendarEventDto.getNote());

        Student student = studentService.getStudent(calendarEventDto.getStudentId());
        calendarEvent.setStudent(student);
        student.addCalendarEvent(calendarEvent);
        studentService.saveStudent(student);

        return ResponseEntity.ok(student.getCalendarEvents());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<CalendarEvent>> deleteCalendarEvent(@RequestBody CalendarEventDto calendarEventDto) {
        calendarEventService.deleteEvent(calendarEventDto);
        List<CalendarEvent> calendarEvents = studentService.getStudent(calendarEventDto.getStudentId()).getCalendarEvents();
        return ResponseEntity.ok(calendarEvents);
    }
}
