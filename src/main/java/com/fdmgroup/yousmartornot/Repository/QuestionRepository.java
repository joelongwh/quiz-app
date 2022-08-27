package com.fdmgroup.yousmartornot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.yousmartornot.Model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByTopicId(long id);
	
//	@Query("SELECT COUNT(q) from Question q JOIN User u on q.topic.id=u.topic.id WHERE (q.option_1 IS NOT NULL AND q.answer=1) OR (q.option_2 IS NOT NULL AND q.answer=2) OR (q.option_3 IS NOT NULL AND q.answer=3) OR (q.option_4 IS NOT NULL AND q.answer=4) AND u.id = :userid ")
//	int findGetScore(long id, long userid);
	
}
