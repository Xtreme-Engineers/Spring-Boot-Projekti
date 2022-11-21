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
<<<<<<< HEAD

	@Bean
	public CommandLineRunner demo(AnswerRepository arepository, QuestionRepository querepository, QuizRepository quirepository){
	
		return (args) -> {
			//log.info("Save example quizzes");
			//Quiz qz1 = new Quiz(null);
			//quirepository.save(qz1);

			//log.info("Save example questions");
			//Question q1 = new Question("kysymys1", qz1);
			//querepository.save(q1);
			log.info("Save example answers");
			Answer a1 = new Answer("vastaus1",null);
			arepository.save(a1);

			log.info("Vastaukset");
			for (Answer answer : arepository.findAll()){
				log.info(answer.toString());
			}
		};
	}
=======
>>>>>>> f6e6e7cacaeb28a6907df315dad231bdfc2c41ed
}
