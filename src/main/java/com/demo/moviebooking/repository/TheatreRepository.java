package com.demo.moviebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.moviebooking.model.TheatreEntity;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {
}