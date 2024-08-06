package com.demo.moviebooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.model.TheatreEntity;
import com.demo.moviebooking.model.mapper.TheatreMapper;
import com.demo.moviebooking.repository.TheatreRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class TheatreService {
	@Autowired
	private TheatreRepository theatreRepository;
	
	private TheatreMapper theatreMapper = new TheatreMapper();

	public List<Theatre> retrieveAllTheatres () {
		List<TheatreEntity> theatreEntitys = theatreRepository.findAll();
		return theatreMapper.convertToDtoList(theatreEntitys);
	}

	public Theatre saveTheatre(Theatre theatreDto) {
		TheatreEntity entity = new TheatreEntity();
		entity.setCity(theatreDto.getName());
		entity.setName(theatreDto.getCity());
		TheatreEntity theatreEntity = theatreRepository.save(entity);
		return theatreMapper.convertToDto(theatreEntity);
	}
}
