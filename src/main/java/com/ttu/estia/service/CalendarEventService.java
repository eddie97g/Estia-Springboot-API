package com.ttu.estia.service;

import com.ttu.estia.entity.CalendarEvent;
import com.ttu.estia.entity.Student;
import com.ttu.estia.pojo.CalendarEventDto;
import com.ttu.estia.repository.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventService {

    @Autowired
    private CalendarEventRepository calendarEventRepository;

    public void deleteEvent(CalendarEventDto calendarEventDto) {
        this.calendarEventRepository.deleteById(calendarEventDto.getCalendarEventId());
    }
}
