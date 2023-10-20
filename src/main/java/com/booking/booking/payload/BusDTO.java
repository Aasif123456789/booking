package com.booking.booking.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDTO {

    private Long id;

    @NotNull(message = "Operator ID cannot be null")
    private Long operatorId;

    @NotEmpty(message = "Bus type cannot be empty")
    private String busType;

    @Positive(message = "Total seats must be a positive number")
    private int totalSeats;

    private String amenities;
}
