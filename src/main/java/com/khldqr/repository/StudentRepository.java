package com.khldqr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khldqr.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
