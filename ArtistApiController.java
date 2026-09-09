package com.sintialab.controller;

import com.sintialab.api.ArtistApi;
import com.sintialab.dto.ArtistDto;
import com.sintialab.entity.Artist;
import com.sintialab.mapper.ArtistMapper;
import com.sintialab.repo.ArtistRepository;
import com.sintialab.rest.ApiError;
import com.sintialab.rest.BaseRestResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistApiController implements ArtistApi {

    private static final Logger logger = LogManager.getLogger(ArtistApiController.class);
    private static final String EXCEPTION_LOG = "Eccezione";

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    ArtistMapper artistMapper;

    @Override
    public ResponseEntity<Object> getAllArtists() {
        try
        {
            logger.info("esecuzione di getAllArtists()");

            List<Artist> artists = artistRepository.findAll();

            return new ResponseEntity<>(artistMapper.mapToArtistDtoList(artists), HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error(EXCEPTION_LOG, e);
            return new ResponseEntity<>(
                    new BaseRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            new ApiError(EXCEPTION_LOG, e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<Object> getArtistById(int id) {
        try
        {
            logger.info("esecuzione di getArtistById()");

            Artist artist = null;

            Optional<Artist> optArtist = artistRepository.findById(id);

            if (optArtist.isPresent())
                artist = optArtist.get();

            return new ResponseEntity<>(artistMapper.mapToArtistDto(artist), HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error(EXCEPTION_LOG, e);
            return new ResponseEntity<>(
                    new BaseRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            new ApiError(EXCEPTION_LOG, e.getMessage())),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
