package com.example.ohjelmointiprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;
import com.example.ohjelmointiprojekti1.domain.Quiz;
import com.example.ohjelmointiprojekti1.domain.QuizRepository;

@CrossOrigin
@Controller
public class QuizController {

	@Autowired
	private QuestionRepository questionrepository;
	@Autowired
	private QuizRepository quizrepository;

	// list all questions on homepage

	// list all questions on /homepage

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("questions", questionrepository.findAll());
		model.addAttribute("quizzes", quizrepository.findAll());
		model.addAttribute("quiz", new Quiz());
		return "homepage";
	}

	// add new question
	@RequestMapping(value = "/add/{id}")
	public String addQuestion(@PathVariable("id") Long quizId, Model model) {
		Quiz quiz = quizrepository.findById(quizId).get();
		// model.addAttribute("parentquiz", quiz);
		Question question = new Question();
		question.setQuiz(quiz);
		model.addAttribute("question", question);
		System.out.print(quiz);
		return "/addquestion";
	}

	// save the new question and redirect to /homepage
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		System.out.println(question);
		questionrepository.save(question);
		return "redirect:/";

	}

	@RequestMapping(value = "/savequiz", method = RequestMethod.POST)
	public String saveQuiz(Quiz quiz) {
		System.out.println(quiz);
		quizrepository.save(quiz);
		return "redirect:/add/1";

	}

}