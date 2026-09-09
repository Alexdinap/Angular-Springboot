package com.sintialab.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sintialab.dto.AlbumDto;
import com.sintialab.entity.Album;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    AlbumDto mapToAlbumDto(Album source);

    Album mapToAlbum(AlbumDto source);

    List<AlbumDto> mapToAlbumDtoList(List<Album> sourceList);

    List<Album> mapToAlbumList(List<AlbumDto> sourceList);
}
