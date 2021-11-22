package com.seleniumexpress.curd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seleniumexpress.curd.dao.CourseRepo;
import com.seleniumexpress.curd.entity.Course;
import com.seleniumexpress.curd.entity.CourseDto;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@SpringBootApplication
public class SpringBootCurdAppApplication implements CommandLineRunner{

	/*
	 * @Autowired private StudentRepo studentrepo;
	 */
	
	@Autowired
	private CourseRepo courserepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Course coursename = courserepo.findBycoursename("Java");
		System.out.println("Course Obj by Custom method :"+coursename);
		
		
		  Course courseByHql = courserepo.something("Java");
		  System.out.println("By HQL query :"+courseByHql);
		  
		  Course coursebynativequery = courserepo.getcoursebynativequery("Spring");
		  System.out.println("By Native Query :"+coursebynativequery);
		 
		  List<Course> listofCourse = courserepo.findByInstructornameAndDuration("Abhilash", "20");
		  
		  for(Course temp : listofCourse) {
			  
			  System.out.println("List of Course :"+temp);
		  }
		 
		  
		  System.out.println("*********** Count **************");
		  
		  int countByInstructorname = courserepo.countByInstructorname("Abhilash");
		  System.out.println("Count of Instructor :"+countByInstructorname);
		  
		  
		  System.out.println("******* OR ********");
		  
		  List<Course> nameOrDuration = courserepo.findByInstructornameOrDuration("Abhilash", "30");
		  for(Course temp: nameOrDuration) {
			  System.out.println("Name Or Duration :"+temp);
		  }
		  
		  System.out.println("******* Declarative  ********");
		  List<Course> notDeclarativeQuery = courserepo.notDeclarativeQuery( "30","Abhilash");
		  System.out.println("Not Declarative  :"+notDeclarativeQuery);
		  for(Course temp: notDeclarativeQuery) {
			  System.out.println("Name Or Duration :"+temp);
		  }
		  
		  List<Course> findingCousreWithAge = courserepo.findByInstructornameAndDurationAndAge("Abhilash", "20",30);
		  for(Course temp : findingCousreWithAge) {
			  
			  System.out.println("3 Condition with Age :" + temp);
		  }
		  
		  
		  
		  List<Course> findByInstructornameAndAge = courserepo.findByInstructornameAndAge("Nithi",25);
		  for(Course temp : findByInstructornameAndAge) {
			  System.out.println("Only InstructorName and Age :"+temp);
		  }
		  
		  List<Course> instructor = courserepo.findTop2ByInstructorname("Abhilash");
		  for (Course temp : instructor) {
			  System.out.println("Temp   :"+temp);
		  }
		  
		  
		  List<Course> orderByCoursename = courserepo.findByInstructornameOrderByCoursenameDesc("Abhilash");
		  for(Course temp : orderByCoursename) {
			  System.out.println("OrderByCourseName  :"+temp);
		  }
		  
		  List<Course> ageLessThan = courserepo.findByAgeLessThanOrderByDurationDesc(30);
		  for(Course temp : ageLessThan) {
			  System.out.println("AgeLessThan   :"+temp);
		  }
		  
		  List<CourseDto> ageBetween = courserepo.findByAgeBetween(20, 30);
//		  for(CourseDto temp : ageBetween) {
//			  System.out.println("AgeBetween :"+temp);
//		  }
		  ageBetween.forEach(
				  CourseDto -> System.out.println(CourseDto.getInstructorname()+" & "
		  +CourseDto.getCoursename()+" & "
		  +CourseDto.getAge()));
		  
		  List<Course> coursenameLike = courserepo.findByCoursenameLike("Spring");
		  for(Course temp : coursenameLike) {
			  System.out.println("CourseName  :"+temp);
		  }
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		List<Student> StudentList = studentrepo.findAll();
		System.out.println("ListofStudents  :"+StudentList);
		
		StudentList.forEach(student -> System.out.println(student));
		
		
		
		Optional<Student> StudentId = studentrepo.findById(2);
		
		if(StudentId.isPresent()) {
		System.out.println("StduentId :"+StudentId.get());
		}
		
		
		
		Student nithi = new Student();
		nithi.setName("nithi");
		nithi.setAddress("Chennai");
		
		studentrepo.save(nithi);
		
		List<Student> StudentList1 = studentrepo.findAll();
		System.out.println("ListofStudents  :"+StudentList1);
		
		StudentList1.forEach(student -> System.out.println(student));
		
		

		
		studentrepo.deleteById(7);
		
		List<Student> StudentList3 = studentrepo.findAll();
		System.out.println("ListofStudents  :"+StudentList3);
		
		StudentList3.forEach(student -> System.out.println(student));
		

	}*/

}
