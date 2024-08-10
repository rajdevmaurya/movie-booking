package com.demo.moviebooking.service;

import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.model.TheatreEntity;
import com.demo.moviebooking.model.mapper.TheatreMapper;
import com.demo.moviebooking.repository.TheatreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 

@ExtendWith(MockitoExtension.class)
class TheatreServiceTest {

    @Mock
    private TheatreRepository theatreRepository;

    @Mock
    private TheatreMapper theatreMapper;

    @InjectMocks
    private TheatreService theatreService;

    private TheatreEntity theatreEntity;
    private Theatre theatreDto;

    @BeforeEach
    void setUp() {
        theatreEntity = new TheatreEntity();
        theatreDto = new Theatre();
    }

    @Test
    void retrieveAllTheatres_ShouldReturnListOfTheatres_WhenEntitiesFound() {
        List<TheatreEntity> theatreEntities = Arrays.asList(theatreEntity);
        
        when(theatreRepository.findAll()).thenReturn(theatreEntities);
        when(theatreMapper.convertToDtoList(theatreEntities)).thenReturn(Arrays.asList(theatreDto));

        List<Theatre> theatres = theatreService.retrieveAllTheatres();

        assertNotNull(theatres);
        assertEquals(1, theatres.size());
        assertEquals(theatreDto, theatres.get(0));

        verify(theatreRepository, times(1)).findAll();
        verify(theatreMapper, times(1)).convertToDtoList(theatreEntities);
    }
}
