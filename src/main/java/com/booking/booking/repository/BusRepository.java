package com.booking.booking.repository;

import com.booking.booking.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {


}
