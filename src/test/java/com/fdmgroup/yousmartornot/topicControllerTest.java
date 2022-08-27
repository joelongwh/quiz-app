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

import com.fdmgroup.yousmartornot.Controller.TopicController;
import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Service.TopicService;

@ExtendWith(MockitoExtension.class)
public class topicControllerTest {
	
	@Mock 
	private TopicService topicServiceMock;
	
	private TopicController topicController;
	
	@BeforeEach
	public void setup(){
		topicController = new TopicController( topicServiceMock);
	}
	
	@Test
	public void testthat_viewAllTopics_returnslistoftopics(){
		
		//Arrange
		Topic topic1 = new Topic("testTopic");
		Topic topic2 = new Topic("testTopic");
		List<Topic> topicList = new ArrayList<>();
		topicList.add(topic1);
		topicList.add(topic2);
		when(topicServiceMock.findAll()).thenReturn(topicList);
		
		//Act
		List<Topic> actual = topicController.viewAllTopics();
		
		//Assert
		verify(topicServiceMock,times(1)).findAll();
		assertEquals( actual, topicList);
	}
	
	@Test
	public void testthat_findIdByTitle_returnsid(){
		
		//Arrange
		String title = "testTitle";
		Long id = 1l;
		Topic topic1 = new Topic(title);
		when(topicServiceMock.findByTitle(title)).thenReturn(topic1);
		topic1.setId(id);
		
		//Act
		Long actual = topicController.findIdByTitle(title);
		
		//Assert
		verify(topicServiceMock,times(1)).findByTitle(title);
		assertEquals(actual, 1l);
	}
		

}
