package com.sintialab.api;

import com.sintialab.dto.AlbumDto;
import com.sintialab.rest.BaseRestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Validated
@CrossOrigin
public interface AlbumApi {

    @Operation(summary = "Get all albums of an artist", description = "Get all albums given the artist id", tags={ "All albums by artist id get api" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AlbumDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))) })
    @GetMapping(value = "/album/getByArtist/{artistId}",
            produces = { "application/json" })
    ResponseEntity<Object> getAllAlbumsByArtistId(
            @Parameter(in = ParameterIn.PATH, description = "The id of the artist", required=true) @PathVariable("artistId") int artistId
    );


    @Operation(summary = "Get album by id", description = "Get album given the id", tags={ "Album by id get api" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlbumDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))) })
    @GetMapping(value = "/album/get/{id}",
            produces = { "application/json" })
    ResponseEntity<Object> getAlbumById(
            @Parameter(in = ParameterIn.PATH, description = "The id of the album to be retrieved", required=true) @PathVariable("id") int id
    );
}