package controller;

import model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Ratings, Long> {
}