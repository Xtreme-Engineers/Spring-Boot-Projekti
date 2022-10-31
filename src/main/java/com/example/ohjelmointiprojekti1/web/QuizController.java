package com.example.ohjelmointiprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;
import com.example.ohjelmointiprojekti1.domain.Quiz;
import com.example.ohjelmointiprojekti1.domain.QuizRepository;

@Controller
public class QuizController {

	@Autowired
	QuizRepository quizRepository;

	@Autowired
	QuestionRepository questionRepository;

	// LIST ALL QUIZZES
	@RequestMapping(value = "/quizlist", method = RequestMethod.GET)
	public String quizzes(Model model) {
		List<Quiz> quizzes = (List<Quiz>) quizRepository.findAll();
		model.addAttribute("quizzes", quizzes);
		return "quizlist";
	}

	// CREATE NEW EMPTY FORM
	@RequestMapping(value = "/newquiz", method = RequestMethod.GET)
	public String newQuiz(Model model) {
		model.addAttribute("quiz", new Quiz()); // empty Quiz
		return "quizform";
	}

	// RECEIVE NEW FORM DATA AND SAVE
	@RequestMapping(value = "/savequiz", method = RequestMethod.POST)
	public String saveQuiz(@ModelAttribute Quiz quiz) {
		quizRepository.save(quiz);
		return "redirect:/quizzes";
	}

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