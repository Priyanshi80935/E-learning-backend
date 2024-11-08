package com.tech.repository;

import com.tech.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * It will manage all the database related stuffs like : save, update , delete, view all other
 */
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
