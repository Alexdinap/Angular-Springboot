package com.sintialab.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sintialab.rest.BaseRestResponse;
import com.sintialab.rest.SimpleObject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@Validated
@CrossOrigin
public interface SimpleApi {

    @Operation(summary = "Get with no parameters", description = "Simple get api without query or path parameters", tags={ "Test get api" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "The result of the get operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SimpleObject.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))
) })
    @GetMapping(value = "/simple/get",
        produces = { "application/json" })
    ResponseEntity<Object> simpleGet();


    @Operation(summary = "Get with path parameter", description = "Simple get api with path parameter", tags={ "Test get api" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result of the get operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SimpleObject.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))
),
            @ApiResponse(responseCode = "500", description = "Internal server error",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))
) })
    @GetMapping(value = "/simple/get/{id}",
            produces = { "application/json" })
    ResponseEntity<Object> simpleGetPathParam(
            @Parameter(in = ParameterIn.PATH, description = "The id of the object to be retrieved", required=true) @PathVariable("id") int id
    );


        @Operation(summary = "Get with query parameter", description = "Simple get api with query parameter", tags={ "Test get api" })
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "The result of the get operation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = SimpleObject.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))
        ),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseRestResponse.class))
        ) })
@GetMapping(value = "/simple/get/query",
        produces = { "application/json" })
ResponseEntity<Object> simpleGetQueryParam(
        @Parameter(in = ParameterIn.QUERY, description = "The id of the object to be retrieved", required=true)  @Valid @RequestParam(value = "id")  int id
);
}