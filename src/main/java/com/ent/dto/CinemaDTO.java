package com.ent.dto;

import com.ent.entity.Cinema.CinemaPlatform;
import com.ent.entity.Cinema.CinemaType;

public class CinemaDTO {

	private Long cinemaId;
	private String cinemaName;
	private String releaseDate;
	private CinemaType cinemaType;
	private CinemaPlatform cinemaPlatform;

	public CinemaDTO() {
	}

	public CinemaDTO(Long cinemaId, String cinemaName, String releaseDate, CinemaType cinemaType,
			CinemaPlatform cinemaPlatform) {
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.releaseDate = releaseDate;
		this.cinemaType = cinemaType;
		this.cinemaPlatform = cinemaPlatform;
	}

	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public CinemaType getCinemaType() {
		return cinemaType;
	}

	public void setCinemaType(CinemaType cinemaType) {
		this.cinemaType = cinemaType;
	}

	public CinemaPlatform getCinemaPlatform() {
		return cinemaPlatform;
	}

	public void setCinemaPlatform(CinemaPlatform cinemaPlatform) {
		this.cinemaPlatform = cinemaPlatform;
	}

}
