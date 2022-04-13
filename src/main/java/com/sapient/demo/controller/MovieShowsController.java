package com.sapient.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.demo.entity.TheatreShows;
import com.sapient.demo.exception.ShowQueryException;
import com.sapient.demo.service.ShowService;

@RestController

public class MovieShowsController {

	private ShowService showService;

	public MovieShowsController(ShowService showService) {
		this.showService = showService;
	}

	@RequestMapping(value = "/getShowDetails/{city}/{movieName}/{date}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getShowsDetails(@PathVariable("city") String city,
			@PathVariable("movieName") String movieName, @PathVariable("date") String date) {
		try {
			List<TheatreShows> list = showService.getShowDetails(city, movieName, date);
			if (list == null || list.size() == 0) {
				return new ResponseEntity<>("No movie found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ShowQueryException e) {
			return new ResponseEntity<>("Some error occurred , plz check the city or movie name",
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}