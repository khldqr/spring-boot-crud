package com.khldqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khldqr.entity.Grade;
import com.khldqr.repository.GradeRepository;

@Service
public class GradeService {
	@Autowired
	private GradeRepository repo;

	public List<Grade> getByStudent(int studnetId) {
		return repo.findByStudent(studnetId);
	}

	public List<Grade> getByCourse(int courseNo) {
		return repo.findByCourse(courseNo);
	}

	public Grade getById(int id) {
		return repo.findById(id).get();
	}

	public void saveGrade(Grade g) {
		repo.save(g);
	}

	public void deleteGreade(int id) {
		repo.deleteById(id);
	}

}
