package com.demo.moviebooking.service;

import com.demo.moviebooking.api.model.Show;
import com.demo.moviebooking.model.ShowEntity;
import com.demo.moviebooking.model.mapper.ShowMapper;
import com.demo.moviebooking.repository.MovieRepository;
import com.demo.moviebooking.repository.ShowRepository;
import com.demo.moviebooking.repository.TheatreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowMapper showMapper;

    public List<Show> searchShows(String movieTitle, String city, LocalDateTime date) {
        List<ShowEntity> showEntities = showRepository.findByMovieTitleAndTheatreCity(movieTitle, city);
        return showMapper.convertToDtoList(showEntities);
    }
    
	public Show addShow(Show show) {
		ShowEntity showEntity = showMapper.convertToEntity(show);
		theatreRepository.save(showEntity.getTheatre());
		movieRepository.save(showEntity.getMovie());
		showRepository.save(showEntity);
		ShowEntity shownNewEntity = showRepository.saveAndFlush(showEntity);
		return showMapper.convertToDto(shownNewEntity);
	}
}
