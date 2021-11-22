package com.khldqr.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeNo;

	private int courseMark;
	@OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
	private Set<StudentCourseGradeAssociation> associations;

	public Grade() {

	}

	public Grade(int gradeNo, int courseMark, Set<StudentCourseGradeAssociation> associations) {
		super();
		this.gradeNo = gradeNo;
		this.courseMark = courseMark;
		this.associations = associations;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public int getCourseMark() {
		return courseMark;
	}

	public void setCourseMark(int courseMark) {
		this.courseMark = courseMark;
	}

	public Set<StudentCourseGradeAssociation> getAssociations() {
		return associations;
	}

	public void setAssociations(Set<StudentCourseGradeAssociation> associations) {
		this.associations = associations;
	}

}
