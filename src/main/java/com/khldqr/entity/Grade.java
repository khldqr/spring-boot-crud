package com.khldqr.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeNo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseNo")
	private Course course;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId")
	private Student student;
	private int courseMark;

	public Grade() {

	}

	public Grade(int gradeNo, Course course, Student student, int courseMark) {
		super();
		this.gradeNo = gradeNo;
		this.course = course;
		this.student = student;
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

	public int getCourseMark() {
		return courseMark;
	}

	public void setCourseMark(int courseMark) {
		this.courseMark = courseMark;
	}

}
