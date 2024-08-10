package com.demo.moviebooking.delegate;

import com.demo.moviebooking.api.ShowApiDelegate;
import com.demo.moviebooking.api.model.Show;
import com.demo.moviebooking.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowApiDelegateImpl implements ShowApiDelegate {

    
    private final ShowService showService;
    
    public ShowApiDelegateImpl(ShowService showService) {
		this.showService = showService;
	}

    @Override
    public ResponseEntity<List<Show>> searchShows(String movieTitle, String city, OffsetDateTime date) {
    	LocalDateTime localDateTime=null;
    	if(date!=null) {
         localDateTime = date.toLocalDateTime();
    	}
        List<Show> shows = showService.searchShows(movieTitle, city, localDateTime);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @Override
	public ResponseEntity<Show> addShow(Show show) {
		Show createdShow = showService.addShow(show);
		if (createdShow != null) {
			return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
