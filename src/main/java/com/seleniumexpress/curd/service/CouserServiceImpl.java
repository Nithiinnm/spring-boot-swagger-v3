package com.seleniumexpress.curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.curd.dao.CourseRepo;
import com.seleniumexpress.curd.entity.Course;

@Service
public class CouserServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courserepo;
	
	@Override
	public List<Course> getallcourses() {

		System.out.println("Welcome to Get all Courses Impl");
		List<Course> allcourses = courserepo.findAll();
		System.out.println("allcourses  :"+allcourses);
		return allcourses;
	}

	@Override
	public Course getCourseById(int courseid) {

		Course ret = null;
		Optional<Course> course = courserepo.findById(courseid);
		if(course.isPresent()) {
			 ret = course.get();
			 System.out.println("Ret In Course  :"+ret);
		}
		return ret; 
	}

	@Override
	public Course saveCourse(Course course) {
		
		Course savedCourse = courserepo.save(course);
		System.out.println("Saved Course :"+savedCourse);
		return savedCourse;
	}

	@Override
	public void deleteCourseByid(int id) {

		courserepo.deleteById(id);
	}

}
