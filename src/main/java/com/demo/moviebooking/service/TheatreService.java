package com.demo.moviebooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.model.TheatreEntity;
import com.demo.moviebooking.model.mapper.TheatreMapper;
import com.demo.moviebooking.repository.TheatreRepository;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    private TheatreMapper theatreMapper = new TheatreMapper();

    public List<Theatre> retrieveAllTheatres() {
        List<TheatreEntity> theatreEntities = theatreRepository.findAll();
        return theatreMapper.convertToDtoList(theatreEntities);
    }

    public Theatre saveTheatre(Theatre theatreDto) {
        TheatreEntity entity = theatreMapper.convertToEntity(theatreDto);
        TheatreEntity savedEntity = theatreRepository.save(entity);
        return theatreMapper.convertToDto(savedEntity);
    }
}
