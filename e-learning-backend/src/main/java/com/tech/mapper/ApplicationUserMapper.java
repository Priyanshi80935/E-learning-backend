package com.tech.mapper;

import com.tech.dto.ApplicationUserDTO;
import com.tech.entity.ApplicationUser;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserMapper {
    public ApplicationUser toEntity(ApplicationUserDTO applicationUserDTO) {
        if (applicationUserDTO == null) {
            return null;
        }

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setId(applicationUserDTO.getId());
        applicationUser.setUsername(applicationUserDTO.getUsername());
        applicationUser.setPassword(applicationUserDTO.getPassword()); // Make sure to hash the password before saving it to the database
        applicationUser.setRole(applicationUserDTO.getRole());
        applicationUser.setDateOfBirth(applicationUserDTO.getDateOfBirth());
        applicationUser.setAccountDetails(applicationUserDTO.getAccountDetails());
        applicationUser.setLocation(applicationUserDTO.getLocation());
        applicationUser.setCountry(applicationUserDTO.getCountry());
        applicationUser.setPinCode(applicationUserDTO.getPinCode());

        return applicationUser;
    }

    public ApplicationUserDTO toDTO(ApplicationUser applicationUser) {
        if (applicationUser == null) {
            return null;
        }

        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();
        applicationUserDTO.setId(applicationUser.getId());
        applicationUserDTO.setUsername(applicationUser.getUsername());
        applicationUserDTO.setPassword(applicationUser.getPassword()); // Optionally mask or avoid exposing password
        applicationUserDTO.setRole(applicationUser.getRole());
        applicationUserDTO.setDateOfBirth(applicationUser.getDateOfBirth());
        applicationUserDTO.setAccountDetails(applicationUser.getAccountDetails());
        applicationUserDTO.setLocation(applicationUser.getLocation());
        applicationUserDTO.setCountry(applicationUser.getCountry());
        applicationUserDTO.setPinCode(applicationUser.getPinCode());

        return applicationUserDTO;
    }
}

