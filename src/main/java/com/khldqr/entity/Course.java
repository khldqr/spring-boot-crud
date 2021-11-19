package com.khldqr.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Course {

	@Id
	private int courseNo;

	private String courseName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "gradeNo")
	private List<Grade> grades = new ArrayList<>();

	public Course() {

	}

	public Course(int courseNo, String courseName, List<Grade> grades) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.grades = grades;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}
