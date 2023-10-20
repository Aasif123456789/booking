package com.booking.booking.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;

    private Long userId;

    private Long scheduleId;

    @NotNull(message = "Total passengers cannot be null")
    @Min(value = 1, message = "Total passengers should be at least 1")
    private Integer totalPassengers;

    @NotNull(message = "Total amount cannot be null")
    @Min(value = 1, message = "Total amount should be at least 1")
    private Double totalAmount;

    @NotNull(message = "Payment method ID cannot be null")
    private Long paymentMethodId;

    @NotNull(message = "Status cannot be null")
    private String status;


}
