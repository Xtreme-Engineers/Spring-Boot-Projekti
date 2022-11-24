package com.example.ohjelmointiprojekti1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionText;

	@ManyToOne
	@JsonIgnoreProperties("question")
	@JoinColumn(name = "quizId")
	private Quiz quiz;

	public Question() {
	}

	public Question(String questionText, Quiz quiz) {
		super();
		this.questionText = questionText;
		this.quiz = quiz;
	}

	// SETTERS AND GETTERS

	public Long getQuestionId() {
		return questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", quiz=" + quiz + "]";
	}

}
