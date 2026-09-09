package com.sintialab.repo;

import com.sintialab.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlbumRepository extends 
    JpaRepository<Album, Integer>, JpaSpecificationExecutor<Album> {
    @Query(nativeQuery = true)   List<Album> getByArtistId(int artistId);
}