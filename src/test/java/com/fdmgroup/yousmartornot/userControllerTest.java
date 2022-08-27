package com.fdmgroup.yousmartornot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.fdmgroup.yousmartornot.Controller.UserController;
import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Model.User;
import com.fdmgroup.yousmartornot.Service.UserService;

@ExtendWith(MockitoExtension.class)
public class userControllerTest {
	
	@Mock
	private UserService userServiceMock;
	
	@Mock
	private Model modelMock;
	
	private UserController userController;
	
	@BeforeEach
	public void setup(){
		userController = new UserController( userServiceMock);
	}
	
	@Test
	public void testthat_getTop10ByTopicId_returnslistofusers(){
		
		//Arrange
		Long topic_id = 1l;
		
		Topic topic1 = new Topic("testTopic");
		User user1 = new User( "username","email",5,topic1);
		User user2 = new User( "username","email",5,topic1);
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		
		when(userServiceMock.findTop10ByTopicId(topic_id)).thenReturn(userList);
		
		//Act
		List<User> actual = userController.getTop10ByTopicId(topic_id);
		
		//Assert
		verify(userServiceMock,times(1)).findTop10ByTopicId(topic_id);
		assertEquals(userList, actual);
	}
	
	@Test
	public void testthat_createNewUser_createsuser(){
		
		//Arrange
		
		//Act
		userController.create_NewUser(modelMock);
		
		//Assert
		verify(modelMock, times(1)).addAttribute("newuser", new User());
	}
	
	@Test
	public void testthat_saveUser_savesuser(){
		
		//Arrange
		Long id = 1l;
		User user1 = new User("testUsername", "testEmail", 3, new Topic("test Topic"));
		when(userServiceMock.save(user1, id)).thenReturn(user1);
		
		//Act
		User actual = userController.saveUser(user1, id);
		
		//Assert
		verify(userServiceMock, times(1)).save(user1, id);
		assertEquals( user1, actual);
	}
}
