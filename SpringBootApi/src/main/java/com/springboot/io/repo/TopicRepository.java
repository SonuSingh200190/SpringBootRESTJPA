package com.springboot.io.repo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.io.bean.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
