package com.example.ohjelmointiprojekti1.domain;

public class Quiz {

	private int Id;
	private String name;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Quiz(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	
	public Quiz() {
		super();
	}
	
	@Override
	public String toString() {
		return "Quiz [Id=" + Id + ", name=" + name + "]";
	}
	
	
}
