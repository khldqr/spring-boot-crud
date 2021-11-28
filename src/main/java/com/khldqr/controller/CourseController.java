package com.khldqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khldqr.entity.Course;
import com.khldqr.exception.NothingFoundException;
import com.khldqr.repository.CourseRepository;

@RestController
@CrossOrigin("http://localhost:4200/")
public class CourseController {

	@Autowired
	private CourseRepository repo;

	@GetMapping("/courses")
	public List<Course> getAllStudents() {
		return repo.findAll();
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id) {
		Course course = repo.findById(id).orElseThrow(() -> new NothingFoundException("course not found"));
		return ResponseEntity.ok(course);
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course c) {
		return repo.save(c);
	}

	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course c) {
		Course course = repo.findById(id).orElseThrow(() -> new NothingFoundException("course not found"));
		course.setCourseName(c.getCourseName());
		repo.save(course);
		return ResponseEntity.ok(course);
	}

	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable() int id) {
		repo.findById(id).orElseThrow(() -> new NothingFoundException("course not found"));
		repo.deleteById(id);
	}

}
