package com.fdmgroup.yousmartornot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.yousmartornot.Model.Question;
import com.fdmgroup.yousmartornot.Repository.QuestionRepository;

/**
 * This is a service class for the topic repository
 * @author SmartPeople
 *
 */
@Service
public class QuestionService {
	
	private QuestionRepository questionRepo;

	@Autowired
	public QuestionService(QuestionRepository questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}

	/**
	 * The save method to save created question
	 * @param question
	 * @return
	 */
	public Question save(Question question) {
		return this.questionRepo.save(question);
	}

	/**
	 * The findByTopicId method to find topic id
	 * @param id
	 * @return
	 */
	public List<Question> findByTopicId(long id) {
		return this.questionRepo.findByTopicId(id);
	}

}
