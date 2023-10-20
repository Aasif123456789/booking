package com.booking.booking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    @NotEmpty(message = "Origin cannot be empty")
    private String origin;

    @NotEmpty(message = "Destination cannot be empty")
    private String destination;

    private double distance;
}
