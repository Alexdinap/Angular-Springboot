package com.sintialab.api;

import com.sintialab.dto.ArtistDto;
import com.sintialab.rest.BaseRestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Validated
@CrossOrigin
public interface ArtistApi {

    @Operation(summary = "Get all artists", description = "Get all records from the table artist", tags={ "All artists get api" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ArtistDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))) })
    @GetMapping(value = "/artist/get",
            produces = { "application/json" })
    ResponseEntity<Object> getAllArtists();


    @Operation(summary = "Get artist by id", description = "Get artist given the id", tags={ "Artist by id get api" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArtistDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))) })
    @GetMapping(value = "/artist/get/{id}",
            produces = { "application/json" })
    ResponseEntity<Object> getArtistById(
            @Parameter(in = ParameterIn.PATH, description = "The id of the artist to be retrieved", required=true) @PathVariable("id") int id
    );
}