package com.booking.booking.repository;


import com.booking.booking.entities.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Long> {


}
