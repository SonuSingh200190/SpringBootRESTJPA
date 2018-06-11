package com.springboot.io.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.io.bean.Topic;
import com.springboot.io.repo.TopicRepository;

@Service
public class TopicService {
	// Spring Businesss Service class is always a Singlton class.

	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Boot Learning"),
					new Topic("emberjs", "EmberJs Framework", "EmberJs Learning"),
					new Topic("java", "Java Framework", "Java Learning")));

	public List<Topic> getAllTopics() {
		List<Topic> topicList = new ArrayList<>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}

	public Topic getTopic(String id) {
		// With Lamda Expression
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();

		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		// for (int i = 0; i < topics.size(); i++) {
		// Topic t = topics.get(i);
		// if (id.equals(t.getId())) {
		// topics.set(i, topic);
		// return;
		// }
		// }
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
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
		topicRepository.delete(id);
	}
}
