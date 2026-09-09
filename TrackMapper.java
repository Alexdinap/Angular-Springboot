package com.sintialab.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sintialab.dto.TrackDto;
import com.sintialab.entity.Track;

@Mapper(componentModel = "spring")
public interface TrackMapper {

    TrackDto mapToTrackDto(Track source);

    Track mapToTrack(TrackDto source);

    List<TrackDto> mapToTrackDtoList(List<Track> sourceList);

    List<Track> mapToTrackList(List<TrackDto> sourceList);
}
