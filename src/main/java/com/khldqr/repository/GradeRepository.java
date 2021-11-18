package com.khldqr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khldqr.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
	public List<Grade> findByStudent(int studentId);

	public List<Grade> findByCourse(int courseNO);
}
