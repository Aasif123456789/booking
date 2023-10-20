package com.booking.booking.payload;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOfferDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Offer ID cannot be null")
    private Long offerId;

}
