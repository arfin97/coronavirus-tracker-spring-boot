package io.javabrains.coronavirustracker;

import io.javabrains.coronavirustracker.entities.Greetings;
import io.javabrains.coronavirustracker.repo.GreetingsRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusTrackerApplication.class, args);
		System.out.println("Hello World");
	}

	@Bean
	ApplicationRunner applicationRunner(GreetingsRepository greetingsRepository){
		return args -> {
			greetingsRepository.save(new Greetings("Hello"));
			greetingsRepository.save(new Greetings("World"));
		};
	}

}
