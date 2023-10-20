package com.booking.booking.repository;

import com.booking.booking.entities.BusOperator;
import com.booking.booking.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


}
