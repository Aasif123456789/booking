package com.booking.booking.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {

    @NotNull(message = "Rating cannot be null")
    @PositiveOrZero(message = "Rating should be a positive number or zero")
    private Integer rating;

    private String comments;
}
