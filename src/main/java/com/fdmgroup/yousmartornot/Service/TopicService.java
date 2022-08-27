package com.fdmgroup.yousmartornot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Repository.TopicRepository;

/**
 * This is a service class for the question repository
 * @author SmartPeople
 *
 */
@Service
public class TopicService {
	
	private TopicRepository topicRepo;

	@Autowired
	public TopicService(TopicRepository topicRepo) {
		super();
		this.topicRepo = topicRepo;
	}
	
	/**
	 * The save method to save a topic
	 * @param topic
	 * @return
	 */
	public Topic save(Topic topic) {
		return this.topicRepo.save(topic);
	}

	/** 
	 * The findAll method to find all topic
	 * @return
	 */
	public List<Topic> findAll() {
		return this.topicRepo.findAll();
	}

	/**
	 * The findbyId method to find topic by its id
	 * @param id
	 * @return
	 */
	public Topic findById(Long id) {
		return this.topicRepo.findById(id).orElse(null);
	}

	/**
	 * The findByTitle method to find topic by its title
	 * @param title
	 * @return
	 */
	public Topic findByTitle(String title) {
		return this.topicRepo.findByTitle(title);
	}
}
