package com.sintialab.controller;

import com.sintialab.api.AlbumApi;
import com.sintialab.entity.Album;
import com.sintialab.mapper.AlbumMapper;
import com.sintialab.repo.AlbumRepository;
import com.sintialab.rest.ApiError;
import com.sintialab.rest.BaseRestResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumApiController implements AlbumApi {

    private static final Logger logger = LogManager.getLogger(AlbumApiController.class);
    private static final String EXCEPTION_LOG = "Eccezione";

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    AlbumMapper albumMapper;

    @Override
    public ResponseEntity<Object> getAllAlbumsByArtistId(int artistId) {
        try
        {
            logger.info("esecuzione di getAllAlbumsByArtistId()");

            List<Album> albums = albumRepository.getByArtistId(artistId);

            return new ResponseEntity<>(albumMapper.mapToAlbumDtoList(albums), HttpStatus.OK);
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
    public ResponseEntity<Object> getAlbumById(int id) {
        try
        {
            logger.info("esecuzione di getAlbumById()");

            Album album = null;

            Optional<Album> optAlbum = albumRepository.findById(id);

            if (optAlbum.isPresent())
                album = optAlbum.get();

            return new ResponseEntity<>(albumMapper.mapToAlbumDto(album), HttpStatus.OK);
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