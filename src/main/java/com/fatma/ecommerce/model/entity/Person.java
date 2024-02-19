package com.fatma.ecommerce.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "firstName")
  @NotNull(message = "enter your firstName")
    @Size(min = 3,max = 14,message = "enter your firstName between 8 and 14 character")
    private String firstName;


    @Column(name = "lastName")
    @NotNull(message = "enter your lastName")
    @Size(min = 3,max = 14,message = "enter your lastName between 8 and 14 character")
    private String lastName;

    @Email
    @Column(unique = true)
    @NotNull(message = "enter your email")
    @NotEmpty
    private String email;

    @Size(min = 4,max = 15,message = "enter your password between 5 and 15 character")
    private String password;

    private String phone;
    private boolean status;
}
