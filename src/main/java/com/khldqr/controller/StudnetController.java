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
import com.khldqr.exception.NothingFoundException;
import com.khldqr.repository.StudentRepository;

@RestController
@CrossOrigin("http://localhost:4200/")
public class StudnetController {

	@Autowired
	private StudentRepository repo;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = repo.findById(id).orElseThrow(() -> new NothingFoundException("student not found"));
		return ResponseEntity.ok(student);
	}

	@PostMapping("/students")
	public void addStudent(@RequestBody Student s) {
		repo.save(s);
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student = repo.findById(id).orElseThrow(() -> new NothingFoundException("student not found"));
		repo.deleteById(id);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s) {
		Student student = repo.findById(id).orElseThrow(() -> new NothingFoundException("student not found"));
		student.setAddress(s.getAddress());
		student.setSex(s.getSex());
		student.setBirthday(s.getBirthday());
		student.setPhoneNo(s.getPhoneNo());
		repo.save(student);
		return ResponseEntity.ok(student);
	}

}
