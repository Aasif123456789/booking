package com.booking.booking.repository;

import com.booking.booking.entities.Booking;
import com.booking.booking.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {


}
