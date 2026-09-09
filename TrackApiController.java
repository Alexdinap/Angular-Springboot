package com.sintialab.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sintialab.api.TrackApi;
import com.sintialab.entity.Track;
import com.sintialab.mapper.TrackMapper;
import com.sintialab.repo.TrackRepository;
import com.sintialab.rest.ApiError;
import com.sintialab.rest.BaseRestResponse;

@RestController
public class TrackApiController implements TrackApi {

    private static final Logger logger = LogManager.getLogger(TrackApiController.class);
    private static final String EXCEPTION_LOG = "Eccezione";

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    TrackMapper trackMapper;

    @Override
    public ResponseEntity<Object> getAllTracksByAlbumId(int albumId) {
        try {
            logger.info("esecuzione di getAllTracksByAlbumId() con albumId {}", albumId);
            List<Track> tracks = trackRepository.getByAlbumId(albumId);
            return new ResponseEntity<>(trackMapper.mapToTrackDtoList(tracks), HttpStatus.OK);
        } catch (Exception exception) {
            logger.error(EXCEPTION_LOG, exception);
            return new ResponseEntity<>(
                    new BaseRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            new ApiError(EXCEPTION_LOG, exception.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getTrackById(int id) {
        try {
            logger.info("esecuzione di getTrackById() con id {}", id);
            Optional<Track> track = trackRepository.findById(id);
            return new ResponseEntity<>(
                    track.map(trackMapper::mapToTrackDto).orElse(null),
                    HttpStatus.OK);
        } catch (Exception exception) {
            logger.error(EXCEPTION_LOG, exception);
            return new ResponseEntity<>(
                    new BaseRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            new ApiError(EXCEPTION_LOG, exception.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
