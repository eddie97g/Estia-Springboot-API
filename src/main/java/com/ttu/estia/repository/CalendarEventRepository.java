package com.ttu.estia.repository;

import com.ttu.estia.entity.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Integer> {
}
