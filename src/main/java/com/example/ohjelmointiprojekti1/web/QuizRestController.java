package com.example.ohjelmointiprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmointiprojekti1.domain.Answer;
import com.example.ohjelmointiprojekti1.domain.AnswerRepository;
import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;
import com.example.ohjelmointiprojekti1.domain.Quiz;
import com.example.ohjelmointiprojekti1.domain.QuizRepository;

@RestController
public class QuizRestController {

	@Autowired
	private QuizRepository quizrepository;

	@Autowired
	private QuestionRepository questionrepository;

	@Autowired
	private AnswerRepository answerrepository;

	// RESTful quizlist
	@RequestMapping(value = "/quizzes", method = RequestMethod.GET)
	public List<Quiz> quizRest() {
		return (List<Quiz>) quizrepository.findAll();
	}

	// RESTful quiz by ID
	@RequestMapping(value = "/quizzes/{id}", method = RequestMethod.GET)
	public Quiz findQuiz(@PathVariable("id") Long quizId) {
		Quiz quiz = quizrepository.findById(quizId).get();
		return quiz;

	}

	// RESTful service to save quiz
	@RequestMapping(value = "/quizzes", method = RequestMethod.POST)
	public Quiz saveQuizRest(@RequestBody Quiz quiz) {
		return quizrepository.save(quiz);
	}

	// RESTful questions list
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public List<Question> questionRest() {
		return (List<Question>) questionrepository.findAll();
	}

	// RESTful get question by ID
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public Question findQuestion(@PathVariable("id") Long questionId) {
		Question question = questionrepository.findById(questionId).get();
		return question;

	}

	// RESTful service to save question
	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public Question saveQuestionRest(@RequestBody Question question) {
		return questionrepository.save(question);
	}

	// RESTful questions list
	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public List<Answer> answerRest() {

		Iterable<Answer> answers = answerrepository.findAll();
		System.out.println("answers rest are:" + answers);

		return (List<Answer>) answerrepository.findAll();
	}

	@RequestMapping(value = "/answers/{id}", method = RequestMethod.GET)
	public Answer findAnswer(@PathVariable("id") Long answerId) {
		Answer answer = answerrepository.findById(answerId).get();
		return answer;

	}

	// @RequestMapping(value = "/answers", method = RequestMethod.POST)
	// public Iterable<Answer> saveAnswersRest(@RequestBody List<Answer> answers) {

	// return answerrepository.saveAll((Iterable<Answer>) answers);
	// }

	@RequestMapping(value = "/answers", method = RequestMethod.POST)
	public Answer saveAnswerRest(@RequestBody Answer answer) {

		return answerrepository.save(answer);
	}

}
