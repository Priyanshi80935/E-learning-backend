package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.SignInDTO;
import com.tech.entity.SignIn;
import com.tech.mapper.SignInMapper;
import com.tech.repository.SignInRepository;

@Service  // Spring will create an object of this service//used as directly inject to controller
public class SignInService {
    
    @Autowired // Spring will inject the SignInRepository dependency
    private SignInRepository signInRepository;
    
    @Autowired // Spring will inject the SignInMapper dependency
    private SignInMapper signInMapper;

    // Method to save a SignIn DTO
    public SignInDTO save(SignInDTO signInDto) {
        SignIn entity = signInMapper.toEntity(signInDto);
        SignIn savedEntity = signInRepository.save(entity); // Saves entity to the database
        return signInMapper.toDTO(savedEntity);
    }

    // Method to find all SignIn records
    public List<SignInDTO> findAll() {
        List<SignIn> allSignIns = signInRepository.findAll();
        List<SignInDTO> signInDtos = new ArrayList<>();
        
        // Converting each SignIn entity to SignInDto
        for (SignIn signIn : allSignIns) {
            signInDtos.add(signInMapper.toDTO(signIn));
        }
        return signInDtos;
    }
}
