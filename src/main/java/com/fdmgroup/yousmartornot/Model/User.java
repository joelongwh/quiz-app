package com.fdmgroup.yousmartornot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * This class (User) contains the attributes of the user
 * @author SmartPeople
 *
 */
@Entity
public class User {

	/**
	 * The primary key of the User (id)
	 */
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String email;
	private int score;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="FK_topic_id")
	private Topic topic;

	/**
	 * Getters and setters of User class
	 * @return
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/**
	 * Constructors for the User class
	 * @param username
	 * @param email
	 * @param score
	 * @param topic
	 */
	public User(String username, String email, int score, Topic topic) {
		super();
		this.username = username;
		this.email = email;
		this.score = score;
		this.topic = topic;
	}

	/**
	 * ({@inheritDoc}
	 */
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", score=" + score + ", Topic="
				+ topic + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, score, topic, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && score == other.score
				&& Objects.equals(topic, other.topic) && Objects.equals(username, other.username);
	}
	
	
	
}
