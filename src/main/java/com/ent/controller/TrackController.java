package com.ent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ent.dao.TrackRepository;
import com.ent.entity.TrackAccess;

@RestController
@RequestMapping("/app/track")
public class TrackController {

	@Autowired
	private TrackRepository repository;

	@GetMapping
	public ResponseEntity<List<TrackAccess>> getTrackDetails() {
		List<TrackAccess> trackList = repository.findAll();
		return new ResponseEntity<List<TrackAccess>>(trackList, new HttpHeaders(), HttpStatus.OK);
	}
}
