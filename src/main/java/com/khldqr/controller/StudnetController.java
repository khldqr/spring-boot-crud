package com.khldqr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khldqr.entity.Student;
import com.khldqr.service.StudentService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class StudnetController {

	@Autowired
	private StudentService service;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return service.getAll();
	}

}
