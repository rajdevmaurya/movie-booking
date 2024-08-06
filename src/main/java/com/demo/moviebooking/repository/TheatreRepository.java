package com.demo.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.moviebooking.model.TheatreEntity;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {
}
