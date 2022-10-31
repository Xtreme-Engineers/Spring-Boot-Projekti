package com.example.ohjelmointiprojekti1.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
	List<Quiz> findByName(String Name);
}