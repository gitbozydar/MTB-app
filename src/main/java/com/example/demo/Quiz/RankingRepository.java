package com.example.demo.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    Optional<Ranking> findByUsername(String username);
}