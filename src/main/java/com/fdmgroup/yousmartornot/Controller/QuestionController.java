package com.fdmgroup.yousmartornot.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.yousmartornot.Model.Question;
import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Service.QuestionService;
import com.fdmgroup.yousmartornot.Service.TopicService;
/**
 * Controller for the Question class
 * @author SmartPeople
 *
 */
@RestController
@RequestMapping("/question")
@CrossOrigin(origins="http://localhost:3000")
public class QuestionController {
	
	private QuestionService questionService;
	private TopicService topicService;

	@Autowired
	public QuestionController(QuestionService questionService, TopicService topicService) {
		super();
		this.questionService = questionService;
		this.topicService = topicService;
	}
	
	/**
	 * Method to save a single created question into an existing topic 
	 * @param question
	 * @return questionService.save(question)
	 */
	@RequestMapping(value="",method = {RequestMethod.POST, RequestMethod.PUT})
	public Question saveQuestion(@RequestBody Question question) {
		Topic topic = topicService.findById(question.getTopic().getId());
		question.setTopic(topic);
		return this.questionService.save(question);
	}
	
	/**
	 * Method to save a set of created questions into a newly created topic 
	 * @param question
	 * @return questionService.save(question)
	 */
	@RequestMapping(value="new",method = {RequestMethod.POST, RequestMethod.PUT})
	public Question saveNewQuestion(@RequestBody Question question) {
		Topic topic = new Topic(question.getTopic().getTitle());
		topicService.save(topic);
		question.setTopic(topic);
		return this.questionService.save(question);
	}

	/**
	 * Method to pull random available questions from the database
	 * @param id
	 * @return selectedQuestions
	 */
	@GetMapping("{id}")
	public List<Question> attemptQuestion(@PathVariable Long id) {
		
		Topic topic = this.topicService.findById(id);
		List<Question> allQuestions = topic.getQuestions();;
		
		Random rand = new Random();
		List<Question> selectedQuestions = new ArrayList<Question>();
		
		for (int i=0; i<5; i++) {
			int randomIndex = rand.nextInt(allQuestions.size());
			selectedQuestions.add(allQuestions.get(randomIndex));
			allQuestions.remove(randomIndex);
		}
		
		return selectedQuestions;
	}
	

}
