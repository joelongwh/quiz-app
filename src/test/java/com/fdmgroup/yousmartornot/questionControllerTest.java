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

import com.fdmgroup.yousmartornot.Controller.QuestionController;
import com.fdmgroup.yousmartornot.Model.Question;
import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Service.QuestionService;
import com.fdmgroup.yousmartornot.Service.TopicService;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class questionControllerTest {
	
	@Mock 
	private QuestionService questionServiceMock;
	
	@Mock
	private TopicService topicServiceMock;
	
	private QuestionController questionController;
	
	@BeforeEach
	public void setup(){
		questionController = new QuestionController(questionServiceMock, topicServiceMock);
	}
	
	@Test
	public void testthat_saveQuestion_savesquestion(){
		
		//Arrange
		Topic topic1 = new Topic("testTopic");
		Question question = new Question("testQuestion","1","2","3","4",1,topic1);
		topic1.setId(1l);
		when(questionServiceMock.save(question)).thenReturn(question);
		
		//Act
		Question actual = questionController.saveQuestion(question);
		
		//Assert
		verify(topicServiceMock,times(1)).findById(1l);
		verify(questionServiceMock,times(1)).save(question);
		assertEquals(actual, question);
	}
	
	@Test
	public void testthat_saveNewQuestion_savesquestion(){
		
		//Arrange
		Topic topic1 = new Topic("testTopic");
		Question question = new Question("testQuestion","1","2","3","4",1,topic1);
		when(questionServiceMock.save(question)).thenReturn(question);
		
		//Act
		Question actual = questionController.saveNewQuestion(question);
		
		//Assert
		verify(topicServiceMock,times(1)).save(topic1);
		verify(questionServiceMock,times(1)).save(question);
		assertEquals( actual, question);
	}

	@Test
	public void testthat_attemptQuestion_returnsselectedQuestion(){
		
		//Arrange
		Long id = 1l;
		Topic topic1 = new Topic("testTopic");
		when(topicServiceMock.findById(id)).thenReturn(topic1);
		
		Question question1 = new Question("testQuestion","1","2","3","4",1,topic1);
		Question question2 = new Question("testQuestion2","1","2","3","4",1,topic1);
		Question question3 = new Question("testQuestion3","1","2","3","4",1,topic1);
		Question question4 = new Question("testQuestion4","1","2","3","4",1,topic1);
		Question question5 = new Question("testQuestion5","1","2","3","4",1,topic1);
		Question question6 = new Question("testQuestion6","1","2","3","4",1,topic1);
		Question question7 = new Question("testQuestion7","1","2","3","4",1,topic1);
		Question question8 = new Question("testQuestion8","1","2","3","4",1,topic1);
		Question question9 = new Question("testQuestion9","1","2","3","4",1,topic1);
		Question question10 = new Question("testQuestion10","1","2","3","4",1,topic1);
		
		List<Question> listQuestion = new ArrayList<Question>();
		listQuestion.add(question2);
		listQuestion.add(question1);
		listQuestion.add(question3);
		listQuestion.add(question4);
		listQuestion.add(question5);
		listQuestion.add(question6);
		listQuestion.add(question7);
		listQuestion.add(question8);
		listQuestion.add(question9);
		listQuestion.add(question10);
		
		topic1.setQuestions(listQuestion);
		
		
		//Act
		List<Question> actual = questionController.attemptQuestion(id);
		
		//Assert
		verify(topicServiceMock,times(1)).findById(id);
		
	}
}
