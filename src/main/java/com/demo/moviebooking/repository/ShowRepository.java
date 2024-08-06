package com.demo.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.moviebooking.model.ShowEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<ShowEntity, Long> {
	List<ShowEntity> findByMovieTitleAndTheatreCityAndShowTimeBetween(String movieTitle, String city,
			LocalDateTime start, LocalDateTime end);
}
