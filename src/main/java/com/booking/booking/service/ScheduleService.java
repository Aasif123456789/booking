package com.booking.booking.service;


import com.booking.booking.entities.Schedule;


public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);

    // ScheduleDTO createSchedule(long busId, long routeId, ScheduleDTO schedulesDTO);
}