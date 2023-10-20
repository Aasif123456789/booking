package com.booking.booking.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusOperatorDTO {

    private Long id;

    @NotEmpty(message = "Operator name cannot be empty")
    @Size(min = 2, max = 50, message = "Operator name must be between 2 and 50 characters")
    private String operatorName;

    @NotEmpty(message = "Contact email cannot be empty")
    @Email(message = "Contact email should be valid")
    private String contactEmail;

    @NotEmpty(message = "Contact phone cannot be empty")
    @Size(min = 10, max = 10, message = "Contact phone should be valid 10 digit number")
    private String contactPhone;

    private String logoUrl;


}
