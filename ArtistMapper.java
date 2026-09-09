package com.sintialab.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sintialab.dto.ArtistDto;
import com.sintialab.entity.Artist;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    ArtistDto mapToArtistDto(Artist source);

    Artist mapToArtist(ArtistDto source);

    List<ArtistDto> mapToArtistDtoList(List<Artist> sourceList);

    List<Artist> mapToArtistList(List<ArtistDto> sourceList);
}