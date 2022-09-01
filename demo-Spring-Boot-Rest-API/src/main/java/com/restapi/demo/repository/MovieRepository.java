package com.restapi.demo.repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.demo.model.Movie;

@Repository
public class MovieRepository {
	
	private List<Movie> movieList = new ArrayList<Movie>();
	ObjectMapper objectMapper = new ObjectMapper();
	
	{
		try {
			movieList = objectMapper.readValue(Paths.get("movies-compact.json").toFile(),
					new TypeReference<List<Movie>>() {
					});
		} catch (StreamReadException e) {
			System.out.println(e);
		} catch (DatabindException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public List<Movie> getAllMovies() {
		return movieList;
	}
	
	public Movie saveMovie(Movie m) {
		Movie movie = new Movie();
		movie.setName(m.getName());
		movie.setYear(m.getYear());
		movie.setGenres(m.getGenres());
		movie.setAgeLimit(m.getAgeLimit());
		movie.setRating(m.getRating());
		movie.setActors(m.getActors());
		movie.setDirector(m.getDirector());
		movie.setSynopsis(m.getSynopsis());
		movieList.add(movie);
		writeMovies();
		return movie;
	}
	
	public String deleteMovie(String movieName) {
		for (Movie m : movieList) {
			if (m.getName().equals(movieName)) {
				movieList.remove(m);
				break;
			}
		}
		writeMovies();
		return movieName + " movie deleted";
	}
	
	public void writeMovies() {
		try {
			objectMapper.writeValue(Paths.get("movies-compact.json").toFile(), movieList);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
