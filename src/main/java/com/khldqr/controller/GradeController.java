package com.khldqr.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khldqr.entity.Course;
import com.khldqr.entity.Grade;
import com.khldqr.entity.Student;
import com.khldqr.exception.NothingFoundException;
import com.khldqr.repository.CourseRepository;
import com.khldqr.repository.GradeRepository;
import com.khldqr.repository.StudentRepository;

@RestController
public class GradeController {

	@Autowired
	private GradeRepository gradeRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;

	@GetMapping("/grades/courses/{courseId}/students/{studentId}")
	public ResponseEntity<Grade> findGradeByCourseAndStudent(@PathVariable(value = "courseId") int courseId,
			@PathVariable(value = "studentId") int studentId) {
		Grade grade = gradeRepo.findByCourseIdAndStudentId(courseId, studentId)
				.orElseThrow(() -> new NothingFoundException("course not found"));
		return ResponseEntity.ok(grade);

	}

	// post a new grade by for a certain student in a certain course

	@PostMapping("/grades/courses/{courseId}/students/{studentId}")
	public Grade addGrade(@PathVariable(value = "courseId") int courseId,
			@PathVariable(value = "studentId") int studentId, @RequestBody Grade grade) throws NothingFoundException {

		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new NothingFoundException("student not found"));
		grade.setStudent(student);
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new NothingFoundException("course not found"));
		grade.setCourse(course);
		return gradeRepo.save(grade);

	}

	// to get all the grades for a single student

	@GetMapping("/students/{id}/grades")
	public Set<Grade> findAllGradesByStudent(@PathVariable(value = "id") int studentId) {

		return gradeRepo.findByStudentId(studentId);
	}

	// to get all the grades for a single course
	@GetMapping("/courses/{id}/grades")
	public Set<Grade> findAllGradesByCourse(@PathVariable(value = "id") int courseId) {

		return gradeRepo.findByCourseId(courseId);
	}

	// to delete a grade
	@DeleteMapping("/grades/courses/{courseId}/students/{studentId}")
	public ResponseEntity<?> deleteGrade(@PathVariable(value = "courseId") int courseId,
			@PathVariable(value = "studentId") int studentId) throws NothingFoundException {
		return gradeRepo.findByCourseIdAndStudentId(courseId, studentId).map(grade -> {
			gradeRepo.delete(grade);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new NothingFoundException("grade not found"));
	}

	// update grade
	@PutMapping("/grades/courses/{courseId}/students/{studentId}")
	public Grade updateGrade(@PathVariable(value = "courseId") int courseId,
			@PathVariable(value = "studentId") int studentId, @RequestBody Grade grade) throws NothingFoundException {

		if (!studentRepo.existsById(studentId)) {
			throw new NothingFoundException("student not found");
		}
		if (!courseRepo.existsById(courseId)) {
			throw new NothingFoundException("course not found");
		}

		Grade g = gradeRepo.findByCourseIdAndStudentId(courseId, studentId)
				.orElseThrow(() -> new NothingFoundException("grade not found"));
		g.setCourseMark(grade.getCourseMark());
		return gradeRepo.save(g);

	}

}
