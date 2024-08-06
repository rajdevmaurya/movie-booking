package com.demo.moviebooking.delegate;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.moviebooking.api.TheatresApiDelegate;
import com.demo.moviebooking.api.model.Theatre;
import com.demo.moviebooking.service.TheatreService;

@Service
public class TheatresApiDelegateImpl implements TheatresApiDelegate{
	
	private final TheatreService theatreService;
	
	public TheatresApiDelegateImpl(TheatreService theatreService) {
		this.theatreService = theatreService;
	}
	
	 public ResponseEntity<List<Theatre>> findAllTheatres() {
		 return new ResponseEntity<List<Theatre>>(theatreService.retrieveAllTheatres(),HttpStatus.OK);
	    }

		public ResponseEntity<Theatre> createTheatre(Theatre theatre) {
			Theatre theatreDto = theatreService.saveTheatre(theatre);
			if (theatreDto!=null) {
				return new ResponseEntity<>(theatreDto,HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
