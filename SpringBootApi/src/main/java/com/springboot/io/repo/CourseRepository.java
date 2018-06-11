package com.springboot.io.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.io.bean.Course;

public interface CourseRepository extends CrudRepository<Course, String>{

}
