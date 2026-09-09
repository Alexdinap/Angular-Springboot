package com.sintialab.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sintialab.dto.TrackDto;
import com.sintialab.rest.BaseRestResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Validated
@CrossOrigin
public interface TrackApi {

    @Operation(summary = "Get all tracks of an album", description = "Get all tracks given the album id", tags = {"Tracks by album id get api"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TrackDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class)))
    })
    @GetMapping(value = "/track/getByAlbum/{albumId}", produces = {"application/json"})
    ResponseEntity<Object> getAllTracksByAlbumId(
            @Parameter(in = ParameterIn.PATH, description = "The id of the album", required = true)
            @PathVariable("albumId") int albumId
    );

    @Operation(summary = "Get track by id", description = "Get track given the id", tags = {"Track by id get api"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TrackDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class)))
    })
    @GetMapping(value = "/track/get/{id}", produces = {"application/json"})
    ResponseEntity<Object> getTrackById(
            @Parameter(in = ParameterIn.PATH, description = "The id of the track", required = true)
            @PathVariable("id") int id
    );
}
