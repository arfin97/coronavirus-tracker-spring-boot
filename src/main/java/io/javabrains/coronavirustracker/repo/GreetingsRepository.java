package io.javabrains.coronavirustracker.repo;

import io.javabrains.coronavirustracker.entities.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingsRepository extends JpaRepository<Greetings, Long> {
}
