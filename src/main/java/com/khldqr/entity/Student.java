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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String studentName;

	private String sex;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate birthday;

	private String phoneNo;

	private String address;

	@OneToMany(orphanRemoval = true, mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("student")
	private Set<Grade> grades;

	public Student() {

	}

	public Student(int studentId, String studentName, String sex, LocalDate birthday, String phoneNo, String address) {

		this.studentName = studentName;
		this.sex = sex;
		this.birthday = birthday;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setStudent(Set<Grade> grades) {
		this.grades = grades;
	}

}
