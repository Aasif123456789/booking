package com.booking.booking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {


@Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
@Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
