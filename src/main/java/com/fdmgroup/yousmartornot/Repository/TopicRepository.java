package com.fdmgroup.yousmartornot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.yousmartornot.Model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
	
	Topic findByTitle(String title);

}
