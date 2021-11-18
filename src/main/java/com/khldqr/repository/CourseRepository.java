package com.khldqr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khldqr.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
