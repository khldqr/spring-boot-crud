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
import com.khldqr.service.CourseService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("/courses")
	public List<Course> getAllStudents() {
		return service.getAll();
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping("/newcourse")
	public void addCourse(@RequestBody Course c) {
		service.saveCourse(c);
	}

	@PutMapping("/course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course c) {
		Course course = service.getById(id);
		course.setCourseName(c.getCourseName());
		service.saveCourse(course);
		return ResponseEntity.ok(course);
	}

	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable() int id) {
		service.deleteCourse(id);
	}

}
