package com.ent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ent.entity.TrackAccess;

public interface TrackRepository extends JpaRepository<TrackAccess, Long> {

}
