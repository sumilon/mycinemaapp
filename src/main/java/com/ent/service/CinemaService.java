package com.ent.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ent.dao.CinemaRepository;
import com.ent.entity.Cinema;
import com.ent.entity.Cinema.CinemaCategory;
import com.ent.entity.Cinema.CinemaPlatform;
import com.ent.entity.Cinema.CinemaType;
import com.ent.exception.RecordNotFoundException;

@Service
public class CinemaService {
	
	private static final Logger logger = LoggerFactory.getLogger(CinemaService.class);

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

	public List<Cinema> getAllCinema() throws RecordNotFoundException {

		List<Cinema> cinemaList = dao.findAllByOrderByReleaseDateAsc();

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			logger.error("getAllCinema ::: no record found");
			throw new RecordNotFoundException("No record found");
		}
	}

	public List<Cinema> getAllByCinemaType(CinemaType cinemaType) throws RecordNotFoundException {

		List<Cinema> cinemaList = dao.findAllByCinemaTypeOrderByReleaseDateAsc(cinemaType);

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			logger.error("getAllCinema ::: no record found");
			throw new RecordNotFoundException("No record found");
		}
	}

	public List<Cinema> getAllByCinemaPlatform(CinemaPlatform cinemaPlatform) throws RecordNotFoundException {

		List<Cinema> cinemaList = dao.findAllByCinemaPlatformOrderByReleaseDateAsc(cinemaPlatform);

		if (cinemaList.size() > 0) {
			return cinemaList;
		} else {
			logger.error("getAllCinema ::: no record found");
			throw new RecordNotFoundException("No record found");
		}
	}

	public List<Cinema> getAllByCinemaCategory(CinemaCategory cinemaCategory) throws RecordNotFoundException {

		Date startDate;
		Date endDate;
		Calendar calendar = Calendar.getInstance();
		List<Cinema> cinemaList = new ArrayList<Cinema>();
		if (cinemaCategory == CinemaCategory.THISWEEK) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			startDate = calendar.getTime();

			calendar.add(Calendar.DATE, 6);
			endDate = calendar.getTime();

			cinemaList = dao.getAllBetweenData(startDate, endDate);
		} else if (cinemaCategory == CinemaCategory.NEXTWEEK) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			calendar.add(Calendar.DATE, 7);
			startDate = calendar.getTime();

			calendar.add(Calendar.DATE, 12);
			endDate = calendar.getTime();

			cinemaList = dao.getAllBetweenData(startDate, endDate);
		} else if (cinemaCategory == CinemaCategory.THISMONTH) {
			calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			startDate = calendar.getTime();

			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			endDate = calendar.getTime();

			cinemaList = dao.getAllBetweenData(startDate, endDate);
		} else if (cinemaCategory == CinemaCategory.NEXTMONTH) {
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
			logger.error("getAllCinema ::: no record found");
			throw new RecordNotFoundException("No record found");
		}
	}

}
