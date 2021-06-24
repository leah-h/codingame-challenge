package io.lhdev.codinggamechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.lhdev")
public class CodinggamechallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodinggamechallengeApplication.class, args);
	}

}
