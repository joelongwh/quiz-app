package com.fdmgroup.yousmartornot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Service.TopicService;

/**
 * Controller for Quiz topics class
 * @author SmartPeople
 *
 */
@RestController
@RequestMapping("/topic")
@CrossOrigin(origins="http://localhost:3000")
public class TopicController {
	
	private TopicService topicService;

	@Autowired
	public TopicController(TopicService topicService) {
		super();
		this.topicService = topicService;
	}
	
	/**
	 * Method to view all the topics available from database
	 * @return
	 */
	@GetMapping("select")
	public List<Topic> viewAllTopics() {
		return this.topicService.findAll();
	}

	/**
	 * Method to find topic title from database 
	 * @param title
	 * @return id
	 */
	@GetMapping("{title}")
	public Long findIdByTitle(@PathVariable String title) {
		Topic topic = this.topicService.findByTitle(title);
		Long id = topic.getId();
		return id;
	}
}
