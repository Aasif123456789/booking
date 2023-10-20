package com.booking.booking.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO {

    @NotEmpty(message = "Offer name cannot be empty")
    private String offerName;

    @NotEmpty(message = "Promo code cannot be empty")
    private String promoCode;

    @NotNull(message = "Discount type cannot be null")
    private String discountType;

    @PositiveOrZero(message = "Discount value cannot be negative")
    private Double discountValue;

    @NotNull(message = "Start date cannot be null")
    private Date startDate;

    @NotNull(message = "End date cannot be null")
    private Date endDate;


}
