package com.ent.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ent.entity.Cinema;
import com.ent.entity.Cinema.CinemaPlatform;
import com.ent.entity.Cinema.CinemaType;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	public List<Cinema> findAllByOrderByReleaseDateAsc();
	
	public List<Cinema> findAllByCinemaTypeOrderByReleaseDateAsc(CinemaType cinemaType);
	
	public List<Cinema> findAllByCinemaPlatformOrderByReleaseDateAsc(CinemaPlatform cinemaPlatform);
	
	@Query(value = "from Cinema where releaseDate BETWEEN :startDate AND :endDate")
	public List<Cinema> getAllBetweenData(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
