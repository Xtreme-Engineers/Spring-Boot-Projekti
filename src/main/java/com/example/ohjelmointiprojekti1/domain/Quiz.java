package com.example.ohjelmointiprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quizId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
	@JsonIgnoreProperties("quiz")
	private List<Question> questions;

	public Quiz() {
	}

	public Quiz(String name) {
		super();
		this.name = name;
	}

	public Long getQuizId() {
		return quizId;
	}

	public String getName() {
		return name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", name=" + name + "]";
	}
}