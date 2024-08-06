package com.demo.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.moviebooking.model.MovieEntity;


public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
