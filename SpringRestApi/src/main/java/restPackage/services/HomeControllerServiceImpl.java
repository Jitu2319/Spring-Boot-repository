package restPackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restPackage.dao.HomeControllerDao;
import restPackage.entities.Course;

@Service
public class HomeControllerServiceImpl implements HomeControllerService {

	List<Course> list;
//	@Autowired
//	private HomeControllerDao homeDao;

	public HomeControllerServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1L, "Jitendra", "Books are the best companion for everyone."));
		list.add(new Course(2L, "Rahul", "Second book description"));
		list.add(new Course(3L, "Ketan", "Third book description"));
	}

	@Override
	public List<Course> getAllCourses() {
//		homeDao.getAllCourses();
		return list;
	}

	@Override
	public Course getCourseById(Long courseId) {

		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
			}

		}
		return c;
	}

	@Override
	public void addCourse(Course course) {
		list.add(course);
	}

}
