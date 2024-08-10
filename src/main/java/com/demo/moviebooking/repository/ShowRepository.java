package com.demo.moviebooking.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.moviebooking.model.ShowEntity;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long> {
    //List<ShowEntity> findByMovieTitleAndTheatreCityAndShowTime(String movieTitle, String city, LocalDateTime date);
    
    List<ShowEntity> findByMovieTitleAndTheatreCity(String movieTitle, String city);
}