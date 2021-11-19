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

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping("/newstudent")
	public void addStudent(@RequestBody Student s) {
		service.saveStudent(s);
	}

	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s) {
		Student student = service.getById(id);
		student.setAddress(s.getAddress());
		student.setSex(s.getSex());
		student.setBirthday(s.getBirthday());
		student.setPhoneNo(s.getPhoneNo());
		service.saveStudent(student);
		return ResponseEntity.ok(student);
	}

}
