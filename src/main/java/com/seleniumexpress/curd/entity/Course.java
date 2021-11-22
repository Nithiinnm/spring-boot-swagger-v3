package com.seleniumexpress.curd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int courseid;
	
	@Column(name = "course_name")
	private String coursename;
	
	@Column(name = "instructor_name")
	private String instructorname;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "age")
	private int age;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(int courseid, String coursename, String instructorname, String duration) {
		super();
		this.duration = duration;
		this.courseid = courseid;
		this.coursename = coursename;
		this.instructorname = instructorname;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getInstructorname() {
		return instructorname;
	}
	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", instructorname=" + instructorname
				+ ", duration=" + duration + ", age=" + age + "]";
	}

	
	
}
