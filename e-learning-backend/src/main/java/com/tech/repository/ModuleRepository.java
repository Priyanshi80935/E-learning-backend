package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.ModuleEntity;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

}
