package com.example.ohjelmointiprojekti1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ohjelmointiprojekti1.domain.Answer;
import com.example.ohjelmointiprojekti1.domain.AnswerRepository;
import com.example.ohjelmointiprojekti1.domain.Question;
import com.example.ohjelmointiprojekti1.domain.QuestionRepository;
import com.example.ohjelmointiprojekti1.domain.Quiz;
import com.example.ohjelmointiprojekti1.domain.QuizRepository;

@SpringBootApplication
public class Ohjelmointiprojekti1Application {
	private static final Logger log = LoggerFactory.getLogger(Ohjelmointiprojekti1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Ohjelmointiprojekti1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(AnswerRepository arepository, QuestionRepository querepository,
			QuizRepository quirepository) {

		return (args) -> {
			log.info("Save example quizzes");
			Quiz qz1 = new Quiz("Hyvinvointikysely");
			quirepository.save(qz1);

			log.info("Save example questions");
			Question q1 = new Question("Ikä:", qz1);
			querepository.save(q1);
			Question q2 = new Question("Sukupuoli:", qz1);
			querepository.save(q2);
			Question q3 = new Question("Opiskeluvuosi:", qz1);
			querepository.save(q3);
			Question q4 = new Question("Oletko tyytyväinen tämänhetkiseen opintomenestykseesi?", qz1);
			querepository.save(q4);
			Question q5 = new Question("Tuntuuko, että olet oikealla alalla?", qz1);
			querepository.save(q5);
			Question q6 = new Question("Tunnetko olevasi väsynyt opintojen kanssa?", qz1);
			querepository.save(q6);
			Question q7 = new Question("Onko sinulla ollut mielenterveysongelmia opintojen aikana?", qz1);
			querepository.save(q7);
			Question q8 = new Question("jos vastasit kyllä, minkälaisia ongelmia?", qz1);
			querepository.save(q8);
			Question q9 = new Question("Koetko, että ongelmat ovat vaikuttaneet opintomenestykseen?", qz1);
			querepository.save(q9);
			Question q10 = new Question("Koetko yksinäisyyttä koulussa?", qz1);
			querepository.save(q10);
			Question q11 = new Question(
					"Mitä kehitysideoita sinulla olisi koululle liittyen mielenterveysongelmien ja yksinäisyyden kannalta?",
					qz1);
			querepository.save(q11);
			log.info("Save example answers");
			Answer a1 = new Answer("22", q1);
			arepository.save(a1);
			Answer a2 = new Answer("Mies", q2);
			arepository.save(a2);
			Answer a3 = new Answer("2", q3);
			arepository.save(a3);
			Answer a4 = new Answer("Kyllä", q4);
			arepository.save(a4);
			Answer a5 = new Answer("Kyllä", q5);
			arepository.save(a5);
			Answer a6 = new Answer("En", q6);
			arepository.save(a6);
			Answer a7 = new Answer("Ei ole", q7);
			arepository.save(a7);
			Answer a8 = new Answer("Tyhjä / ei näy, jos ei vastaus kysymyseen 6 on ei", q8);
			arepository.save(a8);
			Answer a9 = new Answer("Tyhjä / ei näy, jos ei vastaus kysymyseen 6 on ei", q9);
			arepository.save(a9);
			Answer a10 = new Answer("En", q10);
			arepository.save(a10);
			Answer a11 = new Answer("Ei ideoita / voi jättää tyhjäksi", q11);
			arepository.save(a11);

			log.info("Vastaukset");
			for (Answer answer : arepository.findAll()) {
				log.info(answer.toString());
			}
		};

	};
}
