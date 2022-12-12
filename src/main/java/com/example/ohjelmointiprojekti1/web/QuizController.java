package com.example.ohjelmointiprojekti1.web;

import java.util.List;

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

	// Uuden kysymyksen luonti
	@RequestMapping(value = "/add/{id}")
	public String addQuestion(@PathVariable("id") Long quizId, Model model) {

		Quiz quiz = quizrepository.findById(quizId).get(); // Hakee kyselyn, johon kysymys lisätään
		Question question = new Question();
		question.setQuiz(quiz); // Antaa kysymykselle kyselyn ID:n
		List<Question> questionlist = quiz.getQuestions(); // Hakee kyselyn kysymykset

		// Palauttaa thymeleaf templatelle kyselyn nimen, kysymysobjektin ja kysymykset
		model.addAttribute("quiz", quiz);
		model.addAttribute("question", question);
		model.addAttribute("questions", questionlist); //
		return "addquestion";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuiz(@PathVariable("id") Long quizId, Model model) {

		Quiz poistettava = quizrepository.findById(quizId).get();

		System.out.println("Poistettava quiz on: " + poistettava);

		quizrepository.deleteById(quizId);
		return "redirect:../";
	}

	// Tallentaa kysymyksen tietokantaan ja uudelleenohjaa takaisin uuden kysymyksen
	// luontiin
	@RequestMapping(value = "/savequestion/{id}", method = RequestMethod.POST)
	public String saveQuestion(@PathVariable("id") Long quizId, Question question) {

		questionrepository.save(question);
		return "redirect:/add/" + quizId;

	}

	// Rest sivusto
	@GetMapping(value = "/rest")
	public String restSivu(Model model) {
		return "rest";
	}

	// Uuden kyselyn luonti
	@RequestMapping(value = "/savequiz")
	public String saveQuiz(Quiz quiz) {

		quizrepository.save(quiz);
		Long quizId = quiz.getQuizId(); // Hakee Quiz objektin ID:n
		return "redirect:/add/" + quizId; // Uudelleenohjaus sivulle, jossa lisätään kysymykset
	}

	@RequestMapping(value = "/quiz/{id}")
	public String showQuiz(@PathVariable("id") Long quizId, Model model) {

		Quiz quiz = quizrepository.findById(quizId).get();
		List<Question> questionlist = quiz.getQuestions();
		System.out.println("Quiz questions are:" + questionlist);
		model.addAttribute("questions", questionlist);
		model.addAttribute("quiz", quiz);

		return "singlequiz";
	}

}