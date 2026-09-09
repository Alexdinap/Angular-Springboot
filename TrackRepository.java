package com.sintialab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sintialab.entity.Track;

@Repository
public interface TrackRepository extends 
    JpaRepository<Track, Integer>, JpaSpecificationExecutor<Track> {
    @Query(nativeQuery = true)List<Track> getByAlbumId(int albumId);
}