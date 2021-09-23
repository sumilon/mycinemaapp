package com.ent.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.ent.dto.CinemaDTO;
import com.ent.entity.Cinema;
import com.ent.entity.Cinema.CinemaCategory;
import com.ent.entity.Cinema.CinemaPlatform;
import com.ent.entity.Cinema.CinemaType;
import com.ent.entity.TrackAccess.TrackOperation;
import com.ent.exception.RecordNotFoundException;
import com.ent.service.CinemaService;
import com.ent.util.Utility;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/app")
public class CinemaController {

	@Autowired
	private CinemaService service;

	@Autowired
	private Utility util;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to AWS programming. Thank You";
	}

	@GetMapping("/save/{cinemaName}/{cinemaType}/{cinemaPlatform}/{releaseDate}")
	public ResponseEntity<Cinema> create(@PathVariable(value = "cinemaName") String cinemaName,
			@PathVariable(value = "cinemaType") CinemaType cinemaType,
			@PathVariable(value = "cinemaPlatform") CinemaPlatform cinemaPlatform,
			@PathVariable(value = "releaseDate") @ApiParam(defaultValue = "10-10-2021") String releaseDate)
			throws ParseException {

		Cinema cinema = new Cinema(0L, cinemaName, sdf.parse(releaseDate), cinemaType, cinemaPlatform, true);
		util.saveUserDetails(TrackOperation.SAVECINEMA);
		Cinema updated = service.createOrUpdate(cinema);
		return new ResponseEntity<Cinema>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cinema> createOrUpdate(@RequestBody Cinema cinema) {

		util.saveUserDetails(TrackOperation.SAVECINEMA);
		Cinema updated = service.createOrUpdate(cinema);
		return new ResponseEntity<Cinema>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CinemaDTO>> getAllCinema() throws RecordNotFoundException {

		util.saveUserDetails(TrackOperation.GETCINEMA);
		List<CinemaDTO> cinemaDTOs = util.mapCinemaData(service.getAllCinema());
		return new ResponseEntity<List<CinemaDTO>>(cinemaDTOs, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("type/{cinemaType}")
	public ResponseEntity<List<CinemaDTO>> getAllByCinemaType(@PathVariable CinemaType cinemaType)
			throws RecordNotFoundException {

		util.saveUserDetails(TrackOperation.GETCINEMABYTYPE);
		List<CinemaDTO> cinemaDTOs = util.mapCinemaData(service.getAllByCinemaType(cinemaType));
		return new ResponseEntity<List<CinemaDTO>>(cinemaDTOs, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("platform/{cinemaPlatform}")
	public ResponseEntity<List<CinemaDTO>> getAllByCinemaPlatform(@PathVariable CinemaPlatform cinemaPlatform)
			throws RecordNotFoundException {

		util.saveUserDetails(TrackOperation.GETCINEMABYPLATFORM);
		List<CinemaDTO> cinemaDTOs = util.mapCinemaData(service.getAllByCinemaPlatform(cinemaPlatform));
		return new ResponseEntity<List<CinemaDTO>>(cinemaDTOs, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("category/{cinemaCategory}")
	public ResponseEntity<List<CinemaDTO>> getAllByCinemaPlatform(@PathVariable CinemaCategory cinemaCategory)
			throws RecordNotFoundException {

		util.saveUserDetails(TrackOperation.GETCINEMABYCATEGORY);
		List<CinemaDTO> cinemaDTOs = util.mapCinemaData(service.getAllByCinemaCategory(cinemaCategory));
		return new ResponseEntity<List<CinemaDTO>>(cinemaDTOs, new HttpHeaders(), HttpStatus.OK);
	}

}
