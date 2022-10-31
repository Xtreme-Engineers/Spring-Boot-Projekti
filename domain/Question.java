package com.example.ohjelmointiprojekti1.domain;

public class Question {

	private int Id;
	private String Question;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	
	public Question(int id, String question) {
		super();
		Id = id;
		Question = question;
	}
	
	public Question() {
		super();
	}
	
	@Override
	public String toString() {
		return "Question [Id=" + Id + ", Question=" + Question + "]";
	}
	
	
	
}

