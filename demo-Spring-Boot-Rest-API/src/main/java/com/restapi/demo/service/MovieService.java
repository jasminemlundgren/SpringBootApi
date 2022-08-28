package com.restapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.Movie;
import com.restapi.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public List<Movie> getAllMovies() {
		return repository.getAllMovies();
	}
	
	public Movie saveMovie(Movie movie) {
		return repository.saveMovie(movie);
	}
	
//	public String deleteMovie(String name) {
//		repository.deleteMovie(name);
//		return name + "-movie deleted";
//	}

}
