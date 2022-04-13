package com.sapient.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "theatre_shows")

public class TheatreShows {
  @Id
  @Column(name="theatre_show_id")
  

  private long theatreShowId;
  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id", insertable = false, updatable = false)
  private Theatre theatre;
  
  @Column(name="show_date")
  private LocalDate showDate;
  
  @Column(name="show_time")
  private int showTime;
  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;
  
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "city_id", nullable = false)
    @JsonIgnore
	private City city;
  
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}
public long getTheatreShowId() {
	return theatreShowId;
}
public void setTheatreShowId(long theatreShowId) {
	this.theatreShowId = theatreShowId;
}
public Theatre getTheatre() {
	return theatre;
}
public void setTheatre(Theatre theatre) {
	this.theatre = theatre;
}
public LocalDate getShowDate() {
	return showDate;
}
public void setShowDate(LocalDate showDate) {
	this.showDate = showDate;
}
public int getShowTime() {
	return showTime;
}
public void setShowTime(int showTime) {
	this.showTime = showTime;
}
@Override
public String toString() {
	return "TheatreShows [theatreShowId=" + theatreShowId + ", theatre=" + theatre + ", showDate=" + showDate
			+ ", showTime=" + showTime + ", movie=" + movie + ", city=" + city + "]";
}
  
  
}
