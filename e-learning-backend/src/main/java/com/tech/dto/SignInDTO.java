package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInDTO {
    private String fullName;
    private String dateOfBirth; // Date format can be managed as needed
    private String accountDetails;
    private String location;
    private String country;
    private String pincode;
}
