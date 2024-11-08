package com.tech.service;

import com.tech.dto.ApplicationUserDTO;
import com.tech.entity.ApplicationUser;
import com.tech.mapper.ApplicationUserMapper;
import com.tech.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    @Lazy
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ApplicationUserMapper applicationUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findByUsername(username);
    }

    public ApplicationUserDTO saveStudent(ApplicationUserDTO applicationUserDTO) {
        ApplicationUser entity = applicationUserMapper.toEntity(applicationUserDTO);
        entity.setRole("STUDENT");
        String encode = bCryptPasswordEncoder.encode(entity.getPassword());
        entity.setPassword(encode);
        ApplicationUser save = applicationUserRepository.save(entity);
        return applicationUserMapper.toDTO(save);
    }
}
