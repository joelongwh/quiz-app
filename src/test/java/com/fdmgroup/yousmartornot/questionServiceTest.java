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

import com.fdmgroup.yousmartornot.Model.Question;
import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Repository.QuestionRepository;
import com.fdmgroup.yousmartornot.Service.QuestionService;



@ExtendWith(MockitoExtension.class)
public class questionServiceTest {
	
	@Mock
	private QuestionRepository questionRepoMock;
	
	private QuestionService questionService;
	
	@BeforeEach
	public void setup(){
		questionService = new QuestionService( questionRepoMock);
	}
	
	@Test
	public void testthat_save_savesquestion(){
		
		//Arrange
		Question question = new Question("testQuestion","1","2","3","4",1,new Topic("testTopic"));
		when(questionRepoMock.save(question)).thenReturn(question);
		//Act
		Question actual = questionService.save(question);
		
		//Assert
		verify(questionRepoMock,times(1)).save(question);
		assertEquals( actual, question);
	}
	
	@Test
	public void testthat_findByTopicId_returnslistofquestion(){
		
		//Arrange
		long id = 1l;
		Question question1 = new Question("testQuestion","1","2","3","4",1,new Topic("testTopic"));
		Question question2 = new Question("testQuestion","1","2","3","4",1,new Topic("testTopic"));
		
		List<Question> quesList = new ArrayList<Question>();
		quesList.add(question1);
		quesList.add(question2);
		
		when(questionRepoMock.findByTopicId(id)).thenReturn(quesList);
		
		//Act
		List<Question> actual = questionService.findByTopicId(id);
		
		//Assert
		verify(questionRepoMock,times(1)).findByTopicId(id);
		assertEquals( actual, quesList);
	}
	
	

}
