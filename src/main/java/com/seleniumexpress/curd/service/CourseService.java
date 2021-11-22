package com.seleniumexpress.curd.service;

import java.util.List;

import com.seleniumexpress.curd.entity.Course;

public interface CourseService {

	public List<Course> getallcourses();

	public Course getCourseById(int courseid);

	public Course saveCourse(Course course);

	public void deleteCourseByid(int id);

}
