package com.restapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.model.Movie;
import com.restapi.demo.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public List<Movie> findAllMovies() {
		return service.getAllMovies();
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return service.saveMovie(movie);
	}
	
	@DeleteMapping("/{name}")
	public String deleteMovie(@PathVariable(value = "name") String name) {
		return service.deleteMovie(name);
	}
}
