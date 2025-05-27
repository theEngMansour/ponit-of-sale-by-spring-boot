package com.learn.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestValidDto {

    @Pattern(regexp = "^[A-Z]+$", message = "natural letters only")
    private String name;
    @Email
    @NotNull()
    private String email;
    @Min(1)
    @NotNull()
    @Email
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String dateOfBirth;

}
