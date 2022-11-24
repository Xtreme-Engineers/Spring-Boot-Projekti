package com.example.ohjelmointiprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "addquestion";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuiz(@PathVariable("id") Long quizId, Model model) {
		quizrepository.deleteById(quizId);
		return "redirect:../";
	}

	// save the new question and redirect to /homepage
	@RequestMapping(value = "/savequestion/{id}", method = RequestMethod.POST)
	public String saveQuestion(@PathVariable("id") Long quizId, Question question) {
		System.out.println(question);
		questionrepository.save(question);
		return "redirect:/add/" + quizId;

	}

	// Rest sivusto
	@GetMapping(value = "/rest")
	public String restSivu(Model model) {
		return "rest";
	}

	@RequestMapping(value = "/savequiz")
	public String saveQuiz(Quiz quiz, Model odel) {
		System.out.println(quiz);
		quizrepository.save(quiz); // save updates quiz object to get ID
		Long quizId = quiz.getQuizId();
		System.out.print(quiz);
		// Long ID = quiz.getQuizId();
		// Model.addAttribute("id", ID);
		return "redirect:/add/" + quizId;

	}

}