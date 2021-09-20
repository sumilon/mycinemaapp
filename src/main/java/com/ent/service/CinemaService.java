package com.ent.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ent.dao.CinemaRepository;
import com.ent.entity.Cinema;
import com.ent.entity.Cinema.CinemaCategory;
import com.ent.entity.Cinema.CinemaPlatform;
import com.ent.entity.Cinema.CinemaType;

@Service
public class CinemaService {

	@Autowired
	private CinemaRepository dao;

	public Cinema createOrUpdate(Cinema entity) {
		Optional<Cinema> cinema = dao.findById(entity.getId());

		if (cinema.isPresent()) {
			Cinema newCinema = cinema.get();
			newCinema.setCinemaName(entity.getCinemaName());
			newCinema.setCinemaPlatform(entity.getCinemaPlatform());
			newCinema.setCinemaType(entity.getCinemaType());
			newCinema.setReleaseDate(entity.getReleaseDate());

			newCinema = dao.save(newCinema);

			return newCinema;
		} else {
			entity = dao.save(entity);

			return entity;
		}
	}

	public List<Cinema> getAllCinema() {

		List<Cinema> cinemaList = dao.findAllByOrderByReleaseDateAsc();

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			return new ArrayList<Cinema>();
		}
	}
	
	public List<Cinema> getAllByCinemaType(CinemaType cinemaType) {

		List<Cinema> cinemaList = dao.findAllByCinemaTypeOrderByReleaseDateAsc(cinemaType);

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			return new ArrayList<Cinema>();
		}
	}
	
	public List<Cinema> getAllByCinemaPlatform(CinemaPlatform cinemaPlatform) {

		List<Cinema> cinemaList = dao.findAllByCinemaPlatformOrderByReleaseDateAsc(cinemaPlatform);

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			return new ArrayList<Cinema>();
		}
	}
	
	public List<Cinema> getAllByCinemaCategory(CinemaCategory cinemaCategory) {
		
		Date startDate;
		Date endDate;
		Calendar calendar = Calendar.getInstance();
		List<Cinema> cinemaList = new ArrayList<Cinema>();
		if(cinemaCategory == CinemaCategory.THISWEEK) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			startDate = calendar.getTime();
			
			calendar.add(Calendar.DATE, 6);
			endDate = calendar.getTime();
			
			cinemaList = dao.getAllBetweenData(startDate, endDate);
		} else if(cinemaCategory == CinemaCategory.THISMONTH) {
			calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			startDate = calendar.getTime();
			
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			endDate = calendar.getTime();
			
			cinemaList = dao.getAllBetweenData(startDate, endDate);
		} else if(cinemaCategory == CinemaCategory.NEXTMONTH) {
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			startDate = calendar.getTime();
			
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			endDate = calendar.getTime();
			
			cinemaList = dao.getAllBetweenData(startDate, endDate);
		}
		

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			return new ArrayList<Cinema>();
		}
	}
	
	
}
