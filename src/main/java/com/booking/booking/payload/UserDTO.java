package com.booking.booking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.jaxb.internal.stax.LocalXmlResourceResolver;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
private Long id;
    @NotEmpty(message = "first name cannot be empty")
    @Size(min = 2, max = 50, message = "first name must be between 2 and 50 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password should have minimum 8 characters")
    private String password;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNumber;

    private String profilePicture;
    private MultipartFile profileImage;

    private Date createdAt;
    private Date updatedAt;


    }
