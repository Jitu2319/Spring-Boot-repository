package restPackage.services;

import java.util.*;

import restPackage.entities.Course;

public interface HomeControllerService {

	public List<Course> getAllCourses();

	public Course getCourseById(Long courseId);
	
	public void addCourse(Course course);

}
