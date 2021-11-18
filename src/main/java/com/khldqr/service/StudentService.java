package com.khldqr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khldqr.entity.Student;
import com.khldqr.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;

	public List<Student> getAll() {
		return repo.findAll();
	}

	public Student getById(int id) {
		return repo.findById(id).get();
	}

	public void saveStudent(Student s) {
		repo.save(s);
	}

	public void deleteStudent(int id) {
		repo.deleteById(id);
	}

}
