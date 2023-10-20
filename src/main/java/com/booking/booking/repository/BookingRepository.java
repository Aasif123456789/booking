package com.booking.booking.repository;

import com.booking.booking.entities.Booking;
import com.booking.booking.entities.Schedule;
import com.booking.booking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {


}
