package com.restapi.demo.model;

import java.util.HashMap;
import java.util.List;

public class Movie {
	
	private String name;
	private int year;
	private List<String> genres;
	private int ageLimit;
	private int rating;
	private List<Actors> actors;
	private HashMap<String, String> director = new HashMap<String, String>();
	private String synopsis;
	
	public Movie(){}
	
	public Movie(String name, int year, List <String> genres, int ageLimit, int rating,
			List<Actors> actors, HashMap<String, String> director, String synopsis)
	{
		this.name = name;
		this.year = year;
		this.genres = genres;
		this.ageLimit = ageLimit;
		this.rating = rating;
		this.actors = actors;
		this.director = director;
		this.synopsis = synopsis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}

	public HashMap<String, String> getDirector() {
		return director;
	}

	public void setDirector(HashMap<String, String> director) {
		this.director = director;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	@Override
	public String toString() {
		return "Movie { " +
	"Name: " + name +
	", Year: " + year +
	", Genres: " + genres +
	", Age limit: " + ageLimit +
	", Rating: " + rating +
	", Actors: " + actors +
	", Director: " + director +
	", Synopsis: " + synopsis;
	}
}
