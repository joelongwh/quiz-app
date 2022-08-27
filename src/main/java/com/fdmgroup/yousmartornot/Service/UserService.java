package com.fdmgroup.yousmartornot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Model.User;
import com.fdmgroup.yousmartornot.Repository.TopicRepository;
import com.fdmgroup.yousmartornot.Repository.UserRepository;

/**
 * This is a service class for the user repository
 * @author SmartPeople
 *
 */
@Service
public class UserService {
	
	private UserRepository userRepo;
	private TopicRepository topicRepo;
	
	@Autowired
	public UserService(UserRepository userRepo, TopicRepository topicRepo) {
		super();
		this.userRepo = userRepo;
		this.topicRepo = topicRepo;
	}
	
	/**
	 * The getUsers method to find the list of users
	 * @return
	 */
	public List<User> getUsers() {
		return this.userRepo.findAll();
	}
	
	/**
	 * The findUserByUsername method to find users from username
	 * @param user_name
	 * @return
	 */
	public User findUserByUsername(String user_name) {
		return this.userRepo.findUserByUsername(user_name);
	}
	
	/**
	 * The findUserByEmail method to find users from email
	 * @param user_email
	 * @return
	 */
	public User findUserByEmail(String user_email) {
		return this.userRepo.findUserByEmail(user_email);
	}
	
	/**
	 * The findByTopicId method to get topic id from user
	 * @param topic_id
	 * @return
	 */
	public List<User> findByTopicId (Long topic_id){
		return this.userRepo.findByTopicId(topic_id);
	}
	 
	/**
	 * The findTop10ByTopicId method to get top 10 user score by topic id
	 * @param topic_id
	 * @return
	 */
	public List<User> findTop10ByTopicId(Long topic_id){
		List<User> users = this.userRepo.getMarkTop10(topic_id);
		if (users.size() <= 10) {
			return users;
		} else {
			return this.userRepo.getMarkTop10(topic_id).subList(0, 10);
		}
	}
	 
	/**
	 * The save method to save topic id of the user
	 * @param user
	 * @param id
	 * @return
	 */
	public User save(User user, Long id) {
		Topic topic = this.topicRepo.findById(id).orElse(null);
		user.setTopic(topic);
		return this.userRepo.save(user);
	}
	
	/**
	 * The createUser method to save into user
	 * @param user
	 * @return
	 */
	public User createUser(User user) {
		return this.userRepo.save(user);
	}
	 
}