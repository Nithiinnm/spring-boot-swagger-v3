package com.seleniumexpress.curd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.curd.entity.Course;
import com.seleniumexpress.curd.entity.CourseDto;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	// Custom Query Rules
	// It should always Start with findBy or getBy
	// Then follwed by a Entity parameter
	// then given return type

	Course findBycoursename(String course);

	@Query(value = "from Course c where c.coursename = :anynamee", nativeQuery = false)
	Course something(@Param("anynamee") String anyname);

	@Query(value = "Select * from courses c where c.course_name = ?", nativeQuery = true)
	Course getcoursebynativequery(String course);

	//This is called Declarative Method 
	List<Course> findByInstructornameAndDuration(String instructor, String duration);
	
	//For Count Query:
	int countByInstructorname(String instructor);

	List<Course> findByInstructornameOrDuration(String instuctor, String duration);
	
	
	//Find the list of Course by Using Instructor name & duration
	@Query(value = "SELECT * FROM courses c where c.instructor_name= ?2 or c.duration = ?1",nativeQuery = true)
	List<Course> notDeclarativeQuery(String ins, String dur);
	
	
	List<Course> findByInstructornameAndDurationAndAge(String name,String duration,int age);
	
	List<Course> findByInstructornameAndAge(String name,int age);
	
	List<Course> findTop2ByInstructorname(String name);
	
	List<Course> findByInstructornameOrderByCoursenameDesc(String name);
	
	List<Course> findByAgeLessThanOrderByDurationDesc(int age);
	
	List<CourseDto> findByAgeBetween(int age1,int age2);
	
	List<Course> findByCoursenameLike(String course);
	
	
}
