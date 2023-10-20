package com.booking.booking.service.Impl;

import com.booking.booking.entities.Schedule;

import com.booking.booking.repository.ScheduleRepository;
import com.booking.booking.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Override
    public Schedule createSchedule(Schedule schedule) {
        schedule.setCreatedAt(new Date());
        schedule.setUpdatedAt(new Date());

        return scheduleRepository.save(schedule);

    }}