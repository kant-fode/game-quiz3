package com.quiz3.game3.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Game3QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(Game3QuizApplication.class, args);
	}

}
