package com.khldqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khldqr.entity.Course;
import com.khldqr.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repo;

	public List<Course> getAll() {
		return repo.findAll();
	}

	public Course getById(int id) {
		return repo.findById(id).get();
	}

	public void saveCourse(Course c) {
		repo.save(c);
	}

	public void deleteCourse(int id) {
		repo.deleteById(id);
	}

}
