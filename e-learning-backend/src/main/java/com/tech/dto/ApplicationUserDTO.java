package com.tech.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationUserDTO {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String dateOfBirth; // Date format can be managed as needed
    private String accountDetails;
    private String location;
    private String country;
    private String pinCode;
}
