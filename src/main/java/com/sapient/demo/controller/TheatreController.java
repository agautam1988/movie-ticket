package com.sapient.demo.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.demo.domain.TheatreShows;
import com.sapient.demo.exception.MovieException;
import com.sapient.demo.exception.TheatreCreationException;
import com.sapient.demo.exception.TheatreShowException;
import com.sapient.demo.service.TheatreService;

@RestController

public class TheatreController {

	private TheatreService theatreService;

	public TheatreController(TheatreService theatreService) {
		this.theatreService = theatreService;
	}

	@PostMapping(path = "/createShow", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addShows(@RequestBody TheatreShows theatreShows) {
		try {
			com.sapient.demo.entity.TheatreShows tse = theatreService.createTheatreShows(theatreShows);
			return new ResponseEntity<>(tse, HttpStatus.CREATED);
		} catch (TheatreCreationException e) {
			return new ResponseEntity<>("EIther City or movie or theatre id is not correct", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/updateShow", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> updateShows(@RequestBody TheatreShows theatreShows) {

		try {
			Optional<com.sapient.demo.entity.TheatreShows> tse = theatreService.updateTheatreShows(theatreShows);

			if (tse.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(tse.get(), HttpStatus.ACCEPTED);
		} catch (TheatreShowException e) {
			return new ResponseEntity<>("Theatre show id is not correct", HttpStatus.BAD_REQUEST);
		} catch (MovieException e) {
			return new ResponseEntity<>("Movie id not correct", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/deleteShow/{theatreShowId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> deleteShow(@PathVariable("theatreShowId") long theatreShowId) {
		try {
			theatreService.deleteTheatreShows(theatreShowId);
		} catch (Exception e) {
			return new ResponseEntity<>("Some error occurred , plz check the show id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("deleted", HttpStatus.ACCEPTED);
	}

}
