package com.demo.moviebooking.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.moviebooking.api.model.Show;

@Service
public class ShowService {
   

    public List<Show> findShows(String movieTitle, String city, LocalDateTime date) {
        return null;
    }

    public Show saveShow(Show show) {
        return null;
    }
}
