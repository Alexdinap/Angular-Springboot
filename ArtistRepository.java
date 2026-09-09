package com.sintialab.repo; 
import com.sintialab.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository; 
import java.util.List; 

@Repository 
public interface ArtistRepository extends JpaRepository<Artist, Integer>, JpaSpecificationExecutor<Artist> { 
 @Query(value = "SELECT * FROM artist WHERE name = ?1", nativeQuery = true) 
 List<Artist> getByName(String name); 
 @Query("select a from Artist a where a.name like %?1%") 
 List<Artist> getByNameLike(String like); 
} 
