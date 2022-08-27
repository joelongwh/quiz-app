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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Repository.TopicRepository;
import com.fdmgroup.yousmartornot.Service.TopicService;

@ExtendWith(MockitoExtension.class)
public class topicServiceTest {
	
	@Mock 
	private TopicRepository topicRepoMock;
	
	private TopicService topicService;
	
	@BeforeEach
	public void setup(){
		topicService = new TopicService( topicRepoMock);
	}
	
	@Test
	public void testthat_save_savestopic(){
		
		//Arrange
		Topic topic1 = new Topic("testTopic");
		when(topicRepoMock.save(topic1)).thenReturn(topic1);
		
		//Act
		Topic actual = topicService.save(topic1);
		
		//Assert
		verify(topicRepoMock,times(1)).save(topic1);
		assertEquals( actual, topic1);
	}
	
	@Test
	public void testthat_findAll_returnslistofTopic(){
		
		//Arrange
		Topic topic1 = new Topic("testTopic");
		Topic topic2 = new Topic("testTopic");
		List<Topic> topicList = new ArrayList<>();
		topicList.add(topic1);
		topicList.add(topic2);
		when(topicRepoMock.findAll()).thenReturn(topicList);
		
		//Act
		List<Topic> actual = topicService.findAll();
		
		//Assert
		verify(topicRepoMock,times(1)).findAll();
		assertEquals( actual, topicList);
	}
	
	@Test
	public void testthat_findById_returnstopic_whenvalid(){
		
		//Arrange
		Long id = 1l;
		Topic topic1 = new Topic("TestTopic");
		when(topicRepoMock.findById(id)).thenReturn(Optional.of(topic1));
		
		//Act
		Topic actual = topicService.findById(id);
		
		//Assert
		assertEquals(actual,topic1);
		verify(topicRepoMock,times(1)).findById(id);
	}
	
	public void testthat_findById_returnsnull_wheninvalid(){
		
		//Arrange
		Long id =1l;
		Topic topic1 = new Topic("TestTopic");
		when(topicRepoMock.findById(id)).thenReturn(Optional.ofNullable(null));
		
		//Act
		Topic actual = topicService.findById(id);
		
		//Assert
		assertEquals(actual,null);
		verify(topicRepoMock,times(1)).findById(id);
	}
	
	public void testthat_findByTitle_returnstopic(){
		
		//Arrange
		String title = "test title";
		Topic topic1 = new Topic("testTopic");
		when(topicRepoMock.findByTitle(title)).thenReturn(topic1);
		
		//Act
		Topic actual = topicService.findByTitle(title);
		
		//Assert
		verify(topicRepoMock,times(1)).findByTitle(title);
		assertEquals(actual, topic1);
	}
		
}
