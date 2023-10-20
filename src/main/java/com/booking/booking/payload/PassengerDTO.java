package com.booking.booking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @NotNull(message = "Age cannot be null")
    @PositiveOrZero(message = "Age must be a positive number")
    private Integer age;

    @NotEmpty(message = "Gender cannot be empty")
    private String gender;

    @NotNull(message = "Seat number cannot be null")
    @PositiveOrZero(message = "Seat number must be a positive number")
    private Integer seatNumber;
}
