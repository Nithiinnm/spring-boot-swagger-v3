package com.seleniumexpress.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.curd.dao.CourseRepo;
import com.seleniumexpress.curd.entity.Course;
import com.seleniumexpress.curd.service.CourseService;

@RestController
@RequestMapping(value = "/api")
public class CourseRestController {

	@Autowired
	private CourseService courseservice;
	
	@Autowired
	private CourseRepo courserepo;
	
	@GetMapping(value = "/getAllCourses")
	public List<Course> getAllCourses(){
		
		System.out.println("Welcome to Get All Courses");
		List<Course> getallcourses = courseservice.getallcourses();
		return  getallcourses;
		
	}

	@GetMapping("/getCourseById/{id}")
	public Course getCourseById(@PathVariable("id") int courseid) {
		
		System.out.println("Welcome to course By Id");
		Course courseById = courseservice.getCourseById(courseid);
		return courseById;
		
	}
	
	@PostMapping("/saveCourse")
	public Course postCourse(@RequestBody Course course) {
		
		if(course != null) {
			course.setCourseid(0);
		}
		System.out.println("Welcome to Save course  :"+course);
		courseservice.saveCourse(course);
		return course;
		
	}
	
	
	@PutMapping("/updateCourse")
	public Course updateCourse(@RequestBody Course course) {
		
		System.out.println("Welcome to updateCourse");
		courseservice.saveCourse(course);
		return course;
		
	}

	@DeleteMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable("id") int id) {
		
		System.out.println("Welcome to DeleteCourse");
		
		courseservice.deleteCourseByid(id);
		
		return "Delete is :"+id;
		
	}
	
	
	
}
