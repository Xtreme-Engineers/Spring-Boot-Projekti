package com.example.ohjelmointiprojekti1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;
import com.example.ohjelmointiprojekti1.domain.Quiz;
import com.example.ohjelmointiprojekti1.domain.QuizRepository;


@SpringBootApplication
public class Ohjelmointiprojekti1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Ohjelmointiprojekti1Application.class, args);
	}
}
