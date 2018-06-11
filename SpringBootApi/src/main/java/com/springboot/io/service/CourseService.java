package com.springboot.io.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.io.bean.Course;
import com.springboot.io.repo.CourseRepository;

@Service
public class CourseService {
	// Spring Businesss Service class is always a Singlton class.

	@Autowired
	private CourseRepository courseRepository;

//	private List<Topic> topics = new ArrayList<Topic>(
//			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Boot Learning"),
//					new Topic("emberjs", "EmberJs Framework", "EmberJs Learning"),
//					new Topic("java", "Java Framework", "Java Learning")));

	public List<Course> getAllCourses(String id) {
		List<Course> courseList = new ArrayList<>();
		courseRepository.findAll().forEach(courseList::add);
		return courseList;
	}

	public Course getCourse(String courseId) {
		// With Lamda Expression
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();

		return courseRepository.findOne(courseId);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		// for (int i = 0; i < topics.size(); i++) {
		// Topic t = topics.get(i);
		// if (id.equals(t.getId())) {
		// topics.set(i, topic);
		// return;
		// }
		// }
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		// Normal Java Code
		// for(int i= 0; i< topics.size(); i++){
		// Topic t = topics.get(i);
		// if(id.equals(t.getId())){
		// topics.remove(i);
		// return;
		// }
		// }

		// Lamda Expression
		// topics.removeIf(t -> t.getId().equals(id));

		// With JPA
		courseRepository.delete(id);
	}
}
