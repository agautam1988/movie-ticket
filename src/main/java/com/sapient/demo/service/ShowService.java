package com.sapient.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.demo.entity.City;
import com.sapient.demo.entity.Movie;
import com.sapient.demo.entity.TheatreShows;
import com.sapient.demo.exception.ShowQueryException;
import com.sapient.demo.repository.CItyRepo;
import com.sapient.demo.repository.MovieRepo;
import com.sapient.demo.repository.TheatreShowsRepo;

@Service
public class ShowService {
	private MovieRepo movieRepo;
	private CItyRepo cityRepo;
	private TheatreShowsRepo tsr;

	public ShowService(MovieRepo movieRepo, CItyRepo cityRepo, TheatreShowsRepo tsr) {
		this.movieRepo = movieRepo;
		this.cityRepo = cityRepo;
		this.tsr = tsr;
	}

	public List<TheatreShows> getShowDetails(String city, String movie, String date) throws ShowQueryException {
		City cityDb = cityRepo.findByName(city);
		Movie movDb = movieRepo.findByName(movie);
		if (cityDb == null || movDb == null) {
			throw new ShowQueryException(" Either city or movie name is not correct");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate showDate = LocalDate.parse(date, formatter);

		List<TheatreShows> ts = tsr.getByMovieAndCityAndShowDate(movDb, cityDb, showDate);

		return ts;
	}
}
