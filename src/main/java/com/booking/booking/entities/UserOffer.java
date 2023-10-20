package com.booking.booking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_offers")
@IdClass(UserOffer.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOffer implements Serializable {

     @Id
     @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Id
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

}

