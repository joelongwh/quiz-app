package com.fdmgroup.yousmartornot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.yousmartornot.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByUsername(String user_name);
	
	User findUserByEmail(String user_email);
	
	User findUserById(Long user_id);
		
	@Query("SELECT u " + "FROM User u " + "WHERE u.topic.id = :topic_id")
	List<User> findByTopicId(@Param("topic_id") Long topic_id);
	
	@Query("SELECT u " + "FROM User u " + "WHERE u.topic.id = :topic_id " + "ORDER BY u.score DESC ")
	List<User> getMarkTop10(@Param("topic_id") Long topic_id);

	}
