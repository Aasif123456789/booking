package com.booking.booking.repository;

import com.booking.booking.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {


}
