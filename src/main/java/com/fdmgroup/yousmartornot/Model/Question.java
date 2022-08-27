package com.fdmgroup.yousmartornot.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class (Question) contains the attributes of each questions
 * @author SmartPeople
 *
 */
@Entity
public class Question {

	/**
	 * The primary key of the question(id)
	 */
	@Id
	@GeneratedValue
	private Long id;
	private String question;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private int answer;
	
	/**
	 * The foreign key of topic
	 */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "FK_topic_id")
	private Topic topic;
	
	/**
	 * Getters and setters of questions class
	 * @return
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	/**
	 * Constructors of the question class
	 * @param question
	 * @param option_1
	 * @param option_2
	 * @param option_3
	 * @param option_4
	 * @param answer
	 * @param topic
	 */
	public Question(String question, String option_1, String option_2, String option_3, String option_4, int answer,
			Topic topic) {
		super();
		this.question = question;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.answer = answer;
		this.topic = topic;
	}
	
	/**
	 * ({@inheritDoc}
	 */
	public Question() {
		super();
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", option_1=" + option_1 + ", option_2=" + option_2
				+ ", option_3=" + option_3 + ", option_4=" + option_4 + ", answer=" + answer + ", topic=" + topic + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(answer, id, option_1, option_2, option_3, option_4, question, topic);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return answer == other.answer && Objects.equals(id, other.id) && Objects.equals(option_1, other.option_1)
				&& Objects.equals(option_2, other.option_2) && Objects.equals(option_3, other.option_3)
				&& Objects.equals(option_4, other.option_4) && Objects.equals(question, other.question)
				&& Objects.equals(topic, other.topic);
	}

	

}