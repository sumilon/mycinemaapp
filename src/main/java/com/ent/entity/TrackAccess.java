package com.ent.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TrackAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "track_details")
	private String tractDetails;

	@Enumerated(EnumType.STRING)
	@Column(name = "track_operation")
	private TrackOperation trackOperation;

	@Column(name = "track_date")
	private Date trackDate;
	
	public TrackAccess() {
	}

	public TrackAccess(String tractDetails, TrackOperation trackOperation, Date trackDate) {
		this.tractDetails = tractDetails;
		this.trackOperation = trackOperation;
		this.trackDate = trackDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTractDetails() {
		return tractDetails;
	}

	public void setTractDetails(String tractDetails) {
		this.tractDetails = tractDetails;
	}

	public Date getTrackDate() {
		return trackDate;
	}

	public void setTrackDate(Date trackDate) {
		this.trackDate = trackDate;
	}

	public TrackOperation getTrackOperation() {
		return trackOperation;
	}

	public void setTrackOperation(TrackOperation trackOperation) {
		this.trackOperation = trackOperation;
	}

	public enum TrackOperation {
		SAVECINEMA, GETCINEMA, GETCINEMABYTYPE, GETCINEMABYPLATFORM, GETCINEMABYCATEGORY;
	}
}
