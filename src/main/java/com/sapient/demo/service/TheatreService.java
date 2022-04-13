package com.sapient.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sapient.demo.domain.TheatreShows;
import com.sapient.demo.entity.City;
import com.sapient.demo.entity.Movie;
import com.sapient.demo.entity.Theatre;
import com.sapient.demo.exception.MovieException;
import com.sapient.demo.exception.TheatreCreationException;
import com.sapient.demo.exception.TheatreShowException;
import com.sapient.demo.mapper.TheatreMapper;
import com.sapient.demo.repository.CItyRepo;
import com.sapient.demo.repository.MovieRepo;
import com.sapient.demo.repository.TheatreRepo;
import com.sapient.demo.repository.TheatreShowsRepo;

@Service
public class TheatreService {
	private TheatreShowsRepo theatreShowsRepo;
	private MovieRepo movieRepo;
	private CItyRepo cityRepo;
	private TheatreRepo theatreRepo;

	public TheatreService(TheatreShowsRepo theatreShowsRepo, MovieRepo movieRepo, CItyRepo cityRepo,
			TheatreRepo theatreRepo) {
		this.theatreShowsRepo = theatreShowsRepo;
		this.movieRepo = movieRepo;
		this.cityRepo = cityRepo;
		this.theatreRepo = theatreRepo;
	}

	public Optional<com.sapient.demo.entity.TheatreShows> updateTheatreShows(TheatreShows theatreShows)
			throws TheatreShowException, MovieException {
		Optional<com.sapient.demo.entity.TheatreShows> tsold = theatreShowsRepo
				.findById(theatreShows.getTheatreShowId());
		if (tsold.isEmpty()) {
			throw new TheatreShowException("Provided show id does not exist");
		}
		Optional<Movie> movieOpt = movieRepo.findById(theatreShows.getMovieId());

		if (movieOpt.isPresent()) {
			tsold.get().setMovie(movieOpt.get());
		} else {
			throw new MovieException("Movie not present");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate showDate = LocalDate.parse(theatreShows.getShowDate(), formatter);

		tsold.get().setShowDate(showDate);
		tsold.get().setShowTime(theatreShows.getShowTime());
		return theatreShowsRepo.findById(theatreShows.getTheatreShowId());

	}

	public com.sapient.demo.entity.TheatreShows createTheatreShows(TheatreShows theatreShows)
			throws TheatreCreationException {

		Optional<Movie> movieOpt = movieRepo.findById(theatreShows.getMovieId());
		Optional<City> cityOpt = cityRepo.findById(theatreShows.getCityId());
		Optional<Theatre> theatreOpt = theatreRepo.findById(theatreShows.getTheatreId());
		if (movieOpt.isEmpty() || cityOpt.isEmpty() || theatreOpt.isEmpty()) {
			throw new TheatreCreationException("EIther City or movie or theatre id is not correct");
		}
		com.sapient.demo.entity.TheatreShows tse = TheatreMapper.getTheatreShowsEntity(theatreShows, cityOpt.get(),
				movieOpt.get(), theatreOpt.get());
		long id = theatreShowsRepo.findMaxIdByTheatre(theatreOpt.get());
		tse.setTheatreShowId(id + 1);
		return theatreShowsRepo.save(tse);

	}

	public void deleteTheatreShows(long theatreShowId) {
		theatreShowsRepo.deleteById(theatreShowId);

	}
}
