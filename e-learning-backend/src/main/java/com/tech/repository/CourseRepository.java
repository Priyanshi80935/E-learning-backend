package com.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	//insert -> save()
	//findAll
}
