package com.sapient.demo.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.sapient.demo.entity.City;
import com.sapient.demo.entity.Movie;
import com.sapient.demo.entity.Theatre;
import com.sapient.demo.entity.TheatreShows;

public class TheatreMapper {
	
	public static TheatreShows getTheatreShowsEntity(com.sapient.demo.domain.TheatreShows theatreShows,
			City city, Movie movie, Theatre theatre) {
		TheatreShows ts = new TheatreShows();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate showDate = LocalDate.parse(theatreShows.getShowDate(), formatter);
		ts.setShowDate(showDate);
		ts.setShowTime(theatreShows.getShowTime());
		ts.setCity(city);
		ts.setMovie(movie);
		ts.setTheatre(theatre);
		return ts;
		
	}

}
