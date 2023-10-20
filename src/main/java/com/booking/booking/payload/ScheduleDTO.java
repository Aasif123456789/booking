package com.booking.booking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    private Long busId;
    private Long routeId;




    @NotNull(message = "Departure time cannot be null")
    @FutureOrPresent(message = "Departure time can not in minute ")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time cannot be null")
    @FutureOrPresent(message = "Arrival time can not in minute")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Price cannot be null")
    @Min( value =0,message = "Arrival time can not in ")
    private Double price;
}
