package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.SignInDTO;
import com.tech.entity.SignIn;

@Component // Spring will create an object of this mapper component
public class SignInMapper {

    // Method to map SignIn entity to SignInDto
    public SignInDTO toDTO(SignIn signIn) {
        SignInDTO signInDto = new SignInDTO();
        signInDto.setFullName(signIn.getFullName());
        signInDto.setDateOfBirth(signIn.getDateOfBirth());
        signInDto.setAccountDetails(signIn.getAccountDetails());
        signInDto.setLocation(signIn.getLocation());
        signInDto.setCountry(signIn.getCountry());
        signInDto.setPincode(signIn.getPincode());
        return signInDto;
    }

    // Method to map SignInDto to SignIn entity
    public SignIn toEntity(SignInDTO signInDto) {
        SignIn signIn = new SignIn();
        signIn.setFullName(signInDto.getFullName());
        signIn.setDateOfBirth(signInDto.getDateOfBirth());
        signIn.setAccountDetails(signInDto.getAccountDetails());
        signIn.setLocation(signInDto.getLocation());
        signIn.setCountry(signInDto.getCountry());
        signIn.setPincode(signInDto.getPincode());
        return signIn;
    }
}
