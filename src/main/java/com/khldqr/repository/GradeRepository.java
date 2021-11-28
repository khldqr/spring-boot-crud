package com.khldqr.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khldqr.entity.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

	Set<Grade> findByCourseId(int courseId);

	Set<Grade> findByStudentId(int studentId);

	Optional<Grade> findByCourseIdAndStudentId(int courseId, int studentId);

	boolean existsByCourseIdAndStudentId(int courseId, int studentId);

}
