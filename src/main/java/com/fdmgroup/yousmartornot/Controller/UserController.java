package com.fdmgroup.yousmartornot.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.yousmartornot.Model.User;
import com.fdmgroup.yousmartornot.Service.UserService;

/**
 * Controller for user class
 * @author SmartPeople
 *
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	private UserService userService; 
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService=userService;
	}
	
	/**
	 * Method to show the top 10 scored user for each topics
	 * @param topic_id
	 * @return user
	 */
	@GetMapping("{topic_id}")
	public List<User> getTop10ByTopicId(@PathVariable Long topic_id){
		return this.userService.findTop10ByTopicId(topic_id);
	}
	
	/**
	 * Method to create new user
	 * @param model
	 */
	@GetMapping("create_newuser")
	public void create_NewUser(Model model) {
		model.addAttribute("newuser", new User());
	}
	
	/**
	 * Method to save and update user
	 * @param newuser
	 * @param id
	 * @return
	 */
	@PostMapping("save")
	public User saveUser(@RequestBody User newuser, @RequestParam Long id) {
		return this.userService.save(newuser, id);
	}
	
	

}
