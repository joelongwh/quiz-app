package com.fdmgroup.yousmartornot.Model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class (Topic) contains the attributes of the topic
 * @author SmartPeople
 *
 */
@Entity
public class Topic {
	
	/**
	 * The primary key of the Topic(id)
	 */
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true, nullable=false, length=45 )
	private String title;
	@JsonManagedReference
	@OneToMany(mappedBy="topic", cascade=CascadeType.ALL)
	private List<Question> questions;
	

	/**
	 * Getters and setters of topic class
	 * @return
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/**
	 * Constructor for the topic class
	 * @param title
	 */
	public Topic(String title) {
		super();
		this.title = title;
	}

	/**
	 * ({@inheritDoc}
	 */
	public Topic() {
		super();
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, questions, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		return Objects.equals(id, other.id) && Objects.equals(questions, other.questions)
				&& Objects.equals(title, other.title);
	}
		
	
	
}
