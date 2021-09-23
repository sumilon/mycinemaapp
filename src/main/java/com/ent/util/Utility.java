package com.ent.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ent.dao.TrackRepository;
import com.ent.dto.CinemaDTO;
import com.ent.entity.Cinema;
import com.ent.entity.TrackAccess;
import com.ent.entity.TrackAccess.TrackOperation;

@Component
public class Utility {

	@Autowired
	private TrackRepository dao;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

	public void saveUserDetails(TrackOperation trackOperation) {

		try {
			dao.save(new TrackAccess(InetAddress.getLocalHost().toString(), trackOperation, new Date()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CinemaDTO> mapCinemaData(List<Cinema> listCinema) {

		List<CinemaDTO> cinemaDTOs = new ArrayList<CinemaDTO>();
		for (Cinema cc : listCinema) {
			cinemaDTOs.add(new CinemaDTO(cc.getId(), cc.getCinemaName(), sdf.format(cc.getReleaseDate()),
					cc.getCinemaType(), cc.getCinemaPlatform()));
		}

		return cinemaDTOs;
	}
}
