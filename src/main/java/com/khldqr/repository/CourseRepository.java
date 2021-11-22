package com.khldqr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khldqr.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
