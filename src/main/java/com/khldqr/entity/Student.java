package com.khldqr.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	private String studentName;

	private String sex;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate birthday;

	private String phoneNo;

	private String address;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<StudentCourseGradeAssociation> associations;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentName, String sex, LocalDate birthday, String phoneNo, String address,
			Set<StudentCourseGradeAssociation> associations) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.sex = sex;
		this.birthday = birthday;
		this.phoneNo = phoneNo;
		this.address = address;
		this.associations = associations;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<StudentCourseGradeAssociation> getAssociations() {
		return associations;
	}

	public void setAssociations(Set<StudentCourseGradeAssociation> associations) {
		this.associations = associations;
	}

}
