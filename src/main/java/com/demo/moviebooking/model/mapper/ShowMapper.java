package com.demo.moviebooking.model.mapper;

import com.demo.moviebooking.api.model.Movie;
import com.demo.moviebooking.api.model.Show;
import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.model.MovieEntity;
import com.demo.moviebooking.model.ShowEntity;
import com.demo.moviebooking.model.TheatreEntity;

import org.springframework.stereotype.Component;

@Component
public class ShowMapper extends BaseMapper<ShowEntity, Show> {

    @Override
    public ShowEntity convertToEntity(Show dto, Object... args) {
        if (dto == null) {
            return null;
        }
        
        ShowEntity entity = new ShowEntity();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        TheatreEntity te= new TheatreEntity();
        if(dto.getTheatre()!=null) {
            te.setName(dto.getTheatre().getName());
            te.setCity(dto.getTheatre().getCity());
            }
        
        entity.setTheatre(te);
        MovieEntity me = new MovieEntity();
        if(dto.getMovie()!=null) {
        	me.setLanguage(dto.getMovie().getLanguage());
        	me.setTitle(dto.getMovie().getTitle());
        }
        entity.setMovie(me);
        entity.setShowTime(dto.getShowTime() != null ? dto.getShowTime().toLocalDateTime() : null);
        
        return entity;
    }

    @Override
    public Show convertToDto(ShowEntity entity, Object... args) {
        if (entity == null) {
            return null;
        }

        Show dto = new Show();
        Theatre theatreDto = new Theatre();
        Movie movieDto = new Movie();
        dto.setId(entity.getId() != null ? entity.getId().intValue() : null);
        if(entity.getTheatre()!=null) {
        TheatreEntity te=entity.getTheatre();
        theatreDto.setId(te.getId().intValue());
        theatreDto.setName(te.getName());
        theatreDto.setCity(te.getCity());
        }
        dto.setTheatre(theatreDto);
        if(entity.getMovie()!=null) {
        	MovieEntity me=	entity.getMovie();
        	movieDto.setId(me.getId().intValue());
        	movieDto.setLanguage(me.getLanguage());
        	movieDto.setTitle(me.getTitle());
        }
        dto.setMovie(movieDto);
        dto.setShowTime(entity.getShowTime() != null ? entity.getShowTime().atOffset(java.time.ZoneOffset.UTC) : null);
        
        return dto;
    }
}
