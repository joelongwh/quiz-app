package com.fdmgroup.yousmartornot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Model.User;
import com.fdmgroup.yousmartornot.Repository.TopicRepository;
import com.fdmgroup.yousmartornot.Repository.UserRepository;
import com.fdmgroup.yousmartornot.Service.UserService;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class userServiceTest {
	
	@Mock
	private UserRepository userRepoMock;
	
	@Mock 
	private TopicRepository topicRepoMock;
	
	private UserService userService;
	
	@BeforeEach
	public void setup(){
		userService = new UserService (userRepoMock, topicRepoMock);
	}
	
	@Test
	public void testthat_getUsers_returnslistofusers(){
		
		//Arrange
		Topic topic1 = new Topic("testTopic");
		User user1 = new User("testUsername","testEmail", 3,topic1);
		User user2 = new User("testUsername","testEmail", 3,topic1);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		
		when(userRepoMock.findAll()).thenReturn(userList);
		
		//Act
		List<User> actual = userService.getUsers();
		
		//Assert
		verify(userRepoMock,times(1)).findAll();
		assertEquals(actual, userList);
	}
	
	@Test
	public void testthat_findUserByUsername_returnsuser(){
		
		//Arrange
		String username = "testUsername";
		Topic topic1 = new Topic("testTopic");
		User user1 = new User("testUsername","testEmail", 3,topic1);
		when(userRepoMock.findUserByUsername(username)).thenReturn(user1);
		
		//Act
		User actual = userService.findUserByUsername(username);
		
		//Assert
		verify(userRepoMock,times(1)).findUserByUsername(username);
		assertEquals( actual, user1);
	}
	
	@Test
	public void testthat_findUserByEmail_returnsuser(){
		
		//Arrange
		String email = "testEmail";
		Topic topic1 = new Topic("testTopic");
		User user1 = new User("testUsername","testEmail", 3,topic1);
		when(userRepoMock.findUserByEmail(email)).thenReturn(user1);
		
		//Act
		User actual = userService.findUserByEmail(email);
		
		//Assert
		verify(userRepoMock,times(1)).findUserByEmail(email);
		assertEquals( actual, user1);
	}
	
	@Test
	public void testthat_findByTopicId_returnslistofusers(){
		
		//Arrange
		Long topic_id = 1l;
		
		Topic topic1 = new Topic("testTopic");
		User user1 = new User("testUsername","testEmail", 3,topic1);
		User user2 = new User("testUsername","testEmail", 3,topic1);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		
		when(userRepoMock.findByTopicId(topic_id)).thenReturn(userList);
		
		//Act
		List<User> actual = userService.findByTopicId(topic_id);
		
		//Assert
		verify(userRepoMock,times(1)).findByTopicId(topic_id);
		assertEquals( actual, userList);
	}
	
	@Test
	public void testthat_findTop10ByTopicId_returnslistofusers(){
		
		//Arrange
		Long topic_id = 1l;
		Topic topic1 = new Topic("testTopic");
		User user1 = new User("testUsername","testEmail", 3,topic1);
		User user2 = new User("testUsername","testEmail", 3,topic1);
		User user3 = new User("testUsername","testEmail", 3,topic1);
		User user4 = new User("testUsername","testEmail", 3,topic1);
		User user5 = new User("testUsername","testEmail", 3,topic1);
		User user6 = new User("testUsername","testEmail", 3,topic1);
		User user7 = new User("testUsername","testEmail", 3,topic1);
		User user8 = new User("testUsername","testEmail", 3,topic1);
		User user9 = new User("testUsername","testEmail", 3,topic1);
		User user10 = new User("testUsername","testEmail", 3,topic1);
		User user11 = new User("testUsername","testEmail", 3,topic1);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10);
		userList.add(user11);
		
		when(userRepoMock.getMarkTop10(topic_id)).thenReturn(userList);
		
		//Act
		List<User> actual = userService.findTop10ByTopicId(topic_id);
		
		//Assert
		verify(userRepoMock,times(1)).getMarkTop10(topic_id);
		assertEquals(actual, userList.subList(0, 10));
	}
	
	@Test
	public void testthat_save_savesuser(){
		
		//Arrange
		Topic topic1 = new Topic(" testTopic");
		User user1 = new User( "testUsername", "testEmail", 5, topic1);
		Long id = 1l;
		when(userRepoMock.save(user1)).thenReturn(user1);

		
		//Act
		User actual = userService.save(user1, id);
		
		//Assert
		verify(userRepoMock,times(1)).save(user1);
		assertEquals(actual,user1);
	}
	
	@Test
	public void testthat_createUser_createsuser(){
		
		//Arrange
		User user1 = new User( "testUsername", "testEmail", 5, new Topic("testTopic"));
		when(userRepoMock.save(user1)).thenReturn(user1);
		
		//Act
		User actual = userService.createUser(user1);
		
		//Assert
		verify(userRepoMock,times(1)).save(user1);
		assertEquals(actual, user1);
	}
	

}
