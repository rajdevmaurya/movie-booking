package com.demo.moviebooking.service;

import com.demo.moviebooking.api.model.Show;
import com.demo.moviebooking.model.ShowEntity;
import com.demo.moviebooking.model.mapper.ShowMapper;
import com.demo.moviebooking.repository.ShowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 

@ExtendWith(MockitoExtension.class)
class ShowServiceTest {

    @Mock
    private ShowRepository showRepository;

    @Mock
    private ShowMapper showMapper;

    @InjectMocks
    private ShowService showService;

    private ShowEntity showEntity;
    private Show showDto;

    @BeforeEach
    void setUp() {
        showEntity = new ShowEntity();
        showDto = new Show();
    }

    @Test
    void searchShows_ShouldReturnListOfShows_WhenShowEntitiesFound() {
        List<ShowEntity> showEntities = Arrays.asList(showEntity);
        
        when(showRepository.findByMovieTitleAndTheatreCity(anyString(), anyString())).thenReturn(showEntities);
        when(showMapper.convertToDtoList(showEntities)).thenReturn(Arrays.asList(showDto));

        List<Show> shows = showService.searchShows("Movie Title", "City", LocalDateTime.now());

        assertNotNull(shows);
        assertEquals(1, shows.size());
        assertEquals(showDto, shows.get(0));

        verify(showRepository, times(1)).findByMovieTitleAndTheatreCity(anyString(), anyString());
        verify(showMapper, times(1)).convertToDtoList(showEntities);
    }
}
