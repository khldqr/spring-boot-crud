package com.khldqr.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Course {

	@Id
	private int id;

	private String courseName;

	@OneToMany(orphanRemoval = true, mappedBy = "course", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("course")
	private Set<Grade> grades;

	public Course() {

	}

	public Course(int id, String courseName) {
		this.id = id;
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setCourse(Set<Grade> grades) {
		this.grades = grades;
	}

}
