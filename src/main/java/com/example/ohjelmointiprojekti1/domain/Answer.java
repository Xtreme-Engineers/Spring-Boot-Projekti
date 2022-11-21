package com.example.ohjelmointiprojekti1.domain;

import javax.persistence.Entity;

@Entity
public class Answer {
private long answerId;
private String answerText;

private Question question;

public long getAnswerId() {
	return answerId;
}

public void setAnswerId(long answerId) {
	this.answerId = answerId;
}

public String getAnswerText() {
	return answerText;
}

public void setAnswerText(String answerText) {
	this.answerText = answerText;
}

public Question getQuestion() {
	return question;
}

public void setQuestion(Question question) {
	this.question = question;
	
	
}

public Answer(long answerId, String answerText, Question question) {
	super();
	this.answerId = answerId;
	this.answerText = answerText;
	this.question = question;
	
}

public Answer() {
	super();
}

@Override
public String toString() {
	return "Answer [answerId=" + answerId + ", answerText=" + answerText + ", question=" + question + "]";
}




}
