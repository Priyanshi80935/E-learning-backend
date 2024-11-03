package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tech.entity.SignIn;

public interface SignInRepository extends JpaRepository<SignIn, Long> {
    // save() for inserting or updating records
    // findAll() for retrieving all records
    // Additional query methods can be defined here as needed
}
