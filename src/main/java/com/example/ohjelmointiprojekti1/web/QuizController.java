package com.example.ohjelmointiprojekti1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;
import com.example.ohjelmointiprojekti1.domain.QuizRepository;

@CrossOrigin
@Controller
public class QuizController {

	@Autowired
	private QuestionRepository questionrepository;
	@Autowired
	private QuizRepository quizrepository;

	//	list all questions on /homepage
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("questions", questionrepository.findAll());
		return "homepage";
	}
	
	//	add new question
	@RequestMapping(value = "/add")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("quizzes", quizrepository.findAll());
		return "addquestion";
	}
	
	// save the new question and redirect to /homepage
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
    	System.out.println(question);
		questionrepository.save(question);
		return "redirect:homepage";

	}
}