package com.example.ohjelmointiprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;

@Controller
public class QuizController {

	@Autowired
	QuestionRepository questionRepository;

	@RequestMapping(value = "/homepage")
	public String questionList(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "homepage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		questionRepository.save(question);
		return "redirect:homepage";

	}
}