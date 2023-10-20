package com.booking.booking.repository;

import com.booking.booking.entities.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusOperatorRepository extends JpaRepository<BusOperator, Long> {


}
