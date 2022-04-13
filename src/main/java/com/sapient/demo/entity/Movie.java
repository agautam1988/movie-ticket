package com.sapient.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
  @Column(name = "name")
  private String name;
  @Id
  @Column(name = "movie_id")
  private long id;
  @Column(name = "release_date")
  private LocalDate releaseDate;
  @Column(name = "duration")
  private long duration;
  @Column(name = "star_cast")
  private String startCast;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public LocalDate getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(LocalDate releaseDate) {
	this.releaseDate = releaseDate;
}
public long getDuration() {
	return duration;
}
public void setDuration(long duration) {
	this.duration = duration;
}
public String getStartCast() {
	return startCast;
}
public void setStartCast(String startCast) {
	this.startCast = startCast;
}
@Override
public String toString() {
	return "Movie [name=" + name + ", id=" + id + ", releaseDate=" + releaseDate + ", duration=" + duration
			+ ", startCast=" + startCast + "]";
}
  
}
