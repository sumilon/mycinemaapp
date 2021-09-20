package com.ent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ent.entity.Cinema;
import com.ent.entity.Cinema.CinemaCategory;
import com.ent.entity.Cinema.CinemaPlatform;
import com.ent.entity.Cinema.CinemaType;
import com.ent.service.CinemaService;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

	@Autowired
	private CinemaService service;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to AWS programming";
	}

	@PostMapping
	public ResponseEntity<Cinema> createOrUpdate(@RequestBody Cinema cinema) {

		Cinema updated = service.createOrUpdate(cinema);
		return new ResponseEntity<Cinema>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Cinema>> getAllCinema() {

		List<Cinema> listCinema = service.getAllCinema();
		return new ResponseEntity<List<Cinema>>(listCinema, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("type/{cinemaType}")
	public ResponseEntity<List<Cinema>> getAllByCinemaType(@PathVariable CinemaType cinemaType) {

		List<Cinema> listCinema = service.getAllByCinemaType(cinemaType);
		return new ResponseEntity<List<Cinema>>(listCinema, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("platform/{cinemaPlatform}")
	public ResponseEntity<List<Cinema>> getAllByCinemaPlatform(@PathVariable CinemaPlatform cinemaPlatform) {

		List<Cinema> listCinema = service.getAllByCinemaPlatform(cinemaPlatform);
		return new ResponseEntity<List<Cinema>>(listCinema, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("category/{cinemaCategory}")
	public ResponseEntity<List<Cinema>> getAllByCinemaPlatform(@PathVariable CinemaCategory cinemaCategory) {

		List<Cinema> listCinema = service.getAllByCinemaCategory(cinemaCategory);
		return new ResponseEntity<List<Cinema>>(listCinema, new HttpHeaders(), HttpStatus.OK);
	}

}
