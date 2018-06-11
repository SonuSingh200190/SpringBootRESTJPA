package com.springboot.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.io.bean.Course;
import com.springboot.io.bean.Topic;
import com.springboot.io.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllTopics(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String topicId, String courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/course/{courseId}")
	public void deleteCourse(@PathVariable String topicId, @PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
}
