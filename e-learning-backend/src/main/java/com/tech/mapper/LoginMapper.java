package com.tech.mapper;

import org.springframework.stereotype.Component;

import com.tech.dto.LoginDTO;
import com.tech.entity.Login;

@Component // Spring will create an instance of this mapper component
public class LoginMapper {

    // Method to map Login entity to LoginDTO
    public LoginDTO toDTO(Login login) {
        LoginDTO loginDto = new LoginDTO();
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        return loginDto;
    }

    // Method to map LoginDTO to Login entity
    public Login toEntity(LoginDTO loginDto) {
        Login login = new Login();
        login.setUsername(loginDto.getUsername());
        login.setPassword(loginDto.getPassword());
        return login;
    }
}
