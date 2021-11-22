package com.khldqr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khldqr.entity.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
