package com.demo.moviebooking.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.model.TheatreEntity;
import com.demo.moviebooking.model.mapper.TheatreMapper;
import com.demo.moviebooking.repository.TheatreRepository;

@SpringBootTest
class TheatreServiceTest {

    @Mock
    private TheatreRepository theatreRepository;

    @Mock
    private TheatreMapper theatreMapper;

    @InjectMocks
    private TheatreService theatreService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllTheatres() {
        // Arrange
        TheatreEntity theatreEntity1 = new TheatreEntity();
        theatreEntity1.setName("Theatre 1");
        theatreEntity1.setCity("City 1");

        TheatreEntity theatreEntity2 = new TheatreEntity();
        theatreEntity2.setName("Theatre 2");
        theatreEntity2.setCity("City 2");

        List<TheatreEntity> theatreEntities = Arrays.asList(theatreEntity1, theatreEntity2);

        Theatre theatreDto1 = new Theatre();
        theatreDto1.setName("Theatre 1");
        theatreDto1.setCity("City 1");

        Theatre theatreDto2 = new Theatre();
        theatreDto2.setName("Theatre 2");
        theatreDto2.setCity("City 2");

        when(theatreRepository.findAll()).thenReturn(theatreEntities);
        when(theatreMapper.convertToDtoList(theatreEntities)).thenReturn(Arrays.asList(theatreDto1, theatreDto2));

        // Act
        List<Theatre> result = theatreService.retrieveAllTheatres();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Theatre 1", result.get(0).getName());
        assertEquals("City 1", result.get(0).getCity());
        assertEquals("Theatre 2", result.get(1).getName());
        assertEquals("City 2", result.get(1).getCity());

        verify(theatreRepository, times(1)).findAll();
        verify(theatreMapper, times(1)).convertToDtoList(theatreEntities);
    }

    @Test
    void testSaveTheatre() {
        // Arrange
        Theatre theatreDto = new Theatre();
        theatreDto.setName("Theatre 3");
        theatreDto.setCity("City 3");

        TheatreEntity theatreEntity = new TheatreEntity();
        theatreEntity.setName("Theatre 3");
        theatreEntity.setCity("City 3");

        TheatreEntity savedEntity = new TheatreEntity();
        savedEntity.setName("Theatre 3");
        savedEntity.setCity("City 3");

        Theatre savedTheatreDto = new Theatre();
        savedTheatreDto.setName("Theatre 3");
        savedTheatreDto.setCity("City 3");

        when(theatreRepository.save(any(TheatreEntity.class))).thenReturn(savedEntity);
        when(theatreMapper.convertToDto(savedEntity)).thenReturn(savedTheatreDto);

        // Act
        Theatre result = theatreService.saveTheatre(theatreDto);

        // Assert
        assertNotNull(result);
        assertEquals("Theatre 3", result.getName());
        assertEquals("City 3", result.getCity());

        verify(theatreRepository, times(1)).save(any(TheatreEntity.class));
        verify(theatreMapper, times(1)).convertToDto(savedEntity);
    }
}
