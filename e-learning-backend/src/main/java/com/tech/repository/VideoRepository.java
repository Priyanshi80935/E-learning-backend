package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
