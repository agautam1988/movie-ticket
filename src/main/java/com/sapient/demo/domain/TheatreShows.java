package com.sapient.demo.domain;

public class TheatreShows {
	private long theatreShowId;
	private long theatreId;
	private int showTime;
	private String showDate;
	private long movieId;
	private long cityId;
	
	public long getTheatreShowId() {
		return theatreShowId;
	}
	public void setTheatreShowId(long theatreShowId) {
		this.theatreShowId = theatreShowId;
	}
	public long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}
	public int getShowTime() {
		return showTime;
	}
	public void setShowTime(int showTime) {
		this.showTime = showTime;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	
	
}
