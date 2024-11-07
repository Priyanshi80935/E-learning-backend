package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech.entity.Login;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    // Custom method to find a login entry by username
    Optional<Login> findByUsername(String username);
}
