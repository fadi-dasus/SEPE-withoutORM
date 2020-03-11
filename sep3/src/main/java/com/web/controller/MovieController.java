package com.web.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.model.movie.AbstractMovie;
import com.data.model.movie.MovieFactory;
import com.web.BrokerClient;

@RestController
@RequestMapping("/sep3/movie")
public class MovieController {

	private BrokerClient brokerClient;

	@Autowired
	public MovieController(BrokerClient brokerClient) {

		this.brokerClient = brokerClient;

	}

	@GetMapping("/{name}")

	public AbstractMovie readMovie(@PathVariable String name) throws RemoteException {

		AbstractMovie movie = brokerClient.readMovie(name);
		return movie;

	}

	@PostMapping()
	public @ResponseBody AbstractMovie createUser(@RequestParam String name, @RequestParam String director,@RequestParam String discription, @RequestParam String category,
			@RequestParam String duration, @RequestParam String urlTrailer,@RequestParam String urlFullMovie, @RequestParam String urlImage) throws RemoteException {

		AbstractMovie movie =MovieFactory.create(name, director, discription, duration, urlTrailer, urlFullMovie, urlImage,category);
		
		
		brokerClient.createMovie(movie);
		return movie;

	}

	@DeleteMapping("/{name}")
	public AbstractMovie deleteUser(@PathVariable String name) throws RemoteException {

		AbstractMovie movie = brokerClient.readMovie(name);
		brokerClient.deleteMovie(movie);
		;
		return movie;
	}
	
	@GetMapping()
	public @ResponseBody  ArrayList<AbstractMovie> getAll() throws RemoteException, ClassNotFoundException, SQLException {
		ArrayList<AbstractMovie> list = new ArrayList<AbstractMovie>();
			list = 	brokerClient.getAllMovies();
		return list;
	} 

}
