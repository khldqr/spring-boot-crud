package com.khldqr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private int courseMark;

	@ManyToOne()
	@JoinColumn(name = "course_id")
	@JsonIgnoreProperties("grades")
	private Course course;

	@ManyToOne()
	@JoinColumn(name = "student_id")
	@JsonIgnoreProperties("grades")
	private Student student;

	public Grade() {

	}

	public Grade(int courseMark) {

		this.courseMark = courseMark;

	}

	public int getCourseMark() {
		return courseMark;
	}

	public void setCourseMark(int courseMark) {
		this.courseMark = courseMark;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
