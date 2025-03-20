package restPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restPackage.entities.Course;
import restPackage.services.HomeControllerService;

import java.util.*;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private HomeControllerService homeService;

	@GetMapping("/page")
	public String home() {
		return "This is Home Page...";
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		List<Course> allCourses = homeService.getAllCourses();
		return allCourses;

	}

	@GetMapping("/courses/{id}")
	public Course getCoursesById(@PathVariable("id") Long courseId) {
		Course allCourses = homeService.getCourseById(courseId);
		return allCourses;

	}
	
	@PostMapping("/addcourse")
	public void addCourse(@RequestBody Course course) {
		homeService.addCourse(course);
	}
}
