package com.booking.booking.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPaymentMethodDTO {

    private Long id;

    private Long  userId;

    @NotEmpty(message = "Payment type cannot be empty")
    @Size(min = 2, max = 50, message = "Payment type must be between 2 and 50 characters")
    private String paymentType;

    @NotEmpty(message = "Card number cannot be empty")
    private String cardNumber;

    @NotEmpty(message = "Expiration date cannot be empty")
    private String expirationDate;

    @NotEmpty(message = "Card holder name cannot be empty")
    @Size(min = 2, max = 50, message = "Card holder name must be between 2 and 50 characters")
    private String cardHolderName;
}
