package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.LoginDTO;
import com.tech.entity.Login;
import com.tech.mapper.LoginMapper;
import com.tech.repository.LoginRepository;

@Service // Marks this as a Spring service component
public class LoginService {
    
    @Autowired // Injects the LoginRepository dependency
    private LoginRepository loginRepository;
    
    @Autowired // Injects the LoginMapper dependency
    private LoginMapper loginMapper;

    // Method to save a LoginDTO
    public LoginDTO save(LoginDTO loginDto) {
        Login entity = loginMapper.toEntity(loginDto);
        Login savedEntity = loginRepository.save(entity); // Saves entity to the database
        return loginMapper.toDTO(savedEntity);
    }

    // Method to find all Login records
    public List<LoginDTO> findAll() {
        List<Login> allLogins = loginRepository.findAll();
        List<LoginDTO> loginDtos = new ArrayList<>();
        
        // Converting each Login entity to LoginDTO
        for (Login login : allLogins) {
            loginDtos.add(loginMapper.toDTO(login));
        }
        return loginDtos;
    }
    
    // Method to authenticate login by username and password
    public boolean authenticate(String username, String password) {
        return loginRepository.findByUsername(username)
            .map(login -> login.getPassword().equals(password))
            .orElse(false);
    }

	public LoginDTO authenticate(LoginDTO loginDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
