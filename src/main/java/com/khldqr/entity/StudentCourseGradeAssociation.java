package com.khldqr.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class StudentCourseGradeAssociation {

	@EmbeddedId
	private StudentCourseGradeAssociationId id;
	@ManyToOne
	@MapsId("courseNo")
	private Course course;
	@ManyToOne
	@MapsId("studentId")
	private Student student;
	@ManyToOne
	@MapsId("gradeNo")
	private Grade grade;

	public StudentCourseGradeAssociation() {
		id = new StudentCourseGradeAssociationId();
	}

	@Embeddable
	public class StudentCourseGradeAssociationId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer studentId;
		private Integer courseNo;
		private Integer gradeNo;

		public StudentCourseGradeAssociationId() {
			super();
			// TODO Auto-generated constructor stub
		}

		public StudentCourseGradeAssociationId(Integer studentId, Integer courseNo, Integer gradeNo) {
			super();
			this.studentId = studentId;
			this.courseNo = courseNo;
			this.gradeNo = gradeNo;
		}

		public Integer getStudentId() {
			return studentId;
		}

		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}

		public Integer getCourseNo() {
			return courseNo;
		}

		public void setCourseNo(Integer courseNo) {
			this.courseNo = courseNo;
		}

		public Integer getGradeNo() {
			return gradeNo;
		}

		public void setGradeNo(Integer gradeNo) {
			this.gradeNo = gradeNo;
		}

	}

}
