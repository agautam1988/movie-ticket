package com.sapient.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sapient.demo.entity.City;
import com.sapient.demo.entity.Movie;
import com.sapient.demo.entity.Theatre;
import com.sapient.demo.entity.TheatreShows;

public interface TheatreShowsRepo extends CrudRepository<TheatreShows, Long>{
   public List<TheatreShows> getByMovieAndCityAndShowDate(Movie movie,City city,LocalDate showDate );
   
   @Query(value = "SELECT max(theatreShowId) FROM TheatreShows where theatre=:theatre")
   public long findMaxIdByTheatre(@Param("theatre") Theatre theatre);
   
   
}

