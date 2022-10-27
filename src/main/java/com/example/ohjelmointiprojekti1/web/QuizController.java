package com.example.ohjelmointiprojekti1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	
	@RequestMapping("/quizzes")
	public String quizzes() {
		return "Hello World!";
	}
}
