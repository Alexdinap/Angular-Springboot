package com.sintialab.controller;

import com.sintialab.api.SimpleApi;
import com.sintialab.rest.ApiError;
import com.sintialab.rest.BaseRestResponse;
import com.sintialab.rest.SimpleObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
public class SimpleApiController implements SimpleApi {

    private static final Logger logger = LogManager.getLogger(SimpleApiController.class);
    private static final String EXCEPTION_LOG = "Eccezione: {}";

    @Override
    public ResponseEntity<Object> simpleGet() {
        try
        {
            logger.info("esecuzione di simpleGet()");

            SimpleObject result = new SimpleObject();
            result.setId((SecureRandom.getInstanceStrong()).nextInt());
            result.setDescription("Oggetto con id creato casualmente");

            return new ResponseEntity<>(result, HttpStatus.OK);
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
    public ResponseEntity<Object> simpleGetPathParam(int id) {
        try
        {
            logger.info("esecuzione di simpleGetPathParam() con id {}", id);

            SimpleObject result = new SimpleObject(id,
                    "Oggetto con id inviato in richiesta come parametro di percorso");

            return new ResponseEntity<>(result, HttpStatus.OK);
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
    public ResponseEntity<Object> simpleGetQueryParam(int id) {
        try
        {
           logger.info("esecuzione di simpleGetQueryParam() con id {}", id);

           if (id <= 0) {
               logger.debug("simpleGetQueryParam(): id <= 0 , restituisco BAD_REQUEST");
               return new ResponseEntity<>(
                       new BaseRestResponse(HttpStatus.BAD_REQUEST.value(), new ApiError("Parametro id errato", "id deve essere un numero intero positivo")),
                       HttpStatus.BAD_REQUEST);
           }

            SimpleObject result = new SimpleObject(id,
                    "Oggetto con id inviato in richiesta come parametro di query");

            return new ResponseEntity<>(result, HttpStatus.OK);
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

