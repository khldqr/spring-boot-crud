package com.khldqr.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Course {

	@Id
	private int courseNo;

	private String courseName;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<StudentCourseGradeAssociation> associations;

	public Course() {

	}

	public Course(int courseNo, String courseName, Set<StudentCourseGradeAssociation> associations) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.associations = associations;
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

	public Set<StudentCourseGradeAssociation> getAssociations() {
		return associations;
	}

	public void setAssociations(Set<StudentCourseGradeAssociation> associations) {
		this.associations = associations;
	}

}
