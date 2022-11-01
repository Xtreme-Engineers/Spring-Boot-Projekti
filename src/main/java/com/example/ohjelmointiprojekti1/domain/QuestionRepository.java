package com.example.ohjelmointiprojekti1.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findByQuestionText(String questionText);
}
