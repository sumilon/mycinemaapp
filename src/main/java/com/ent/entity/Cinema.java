package com.ent.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CINEMA")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "cinema_name")
	private String cinemaName;

	@Column(name = "release_date")
	private Date releaseDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "cinema_type")
	private CinemaType cinemaType;

	@Enumerated(EnumType.STRING)
	@Column(name = "cinema_platform")
	private CinemaPlatform cinemaPlatform;

	@Column(name = "flag")
	private Boolean flag;

	public Cinema() {
	}

	public Cinema(Long id, String cinemaName, Date releaseDate, CinemaType cinemaType, CinemaPlatform cinemaPlatform,
			Boolean flag) {
		this.id = id;
		this.cinemaName = cinemaName;
		this.releaseDate = releaseDate;
		this.cinemaType = cinemaType;
		this.cinemaPlatform = cinemaPlatform;
		this.flag = flag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", cinemaName=" + cinemaName + ", releaseDate=" + releaseDate + ", cinemaType="
				+ cinemaType + ", cinemaPlatform=" + cinemaPlatform + ", flag=" + flag + "]";
	}

	public enum CinemaType {
		MOVIE, WEBSERIES;
	}

	public enum CinemaPlatform {
		NETFLIX, PRIME, HOTSTAR, HOICHOI, ADDATIMES, THREATER, VOD, ZEE5, SONYLIV;
	}

	public enum CinemaCategory {
		THISWEEK, NEXTWEEK, THISMONTH, NEXTMONTH;
	}

}
