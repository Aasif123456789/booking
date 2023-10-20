package com.booking.booking.repository;

import com.booking.booking.entities.UserOffer;
import com.booking.booking.util.UserOfferId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserOfferRepository extends JpaRepository<UserOffer, UserOfferId> {


}
