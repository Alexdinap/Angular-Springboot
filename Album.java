package com.sintialab.entity; 

import java.io.Serializable;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

@Entity 
@Table(name="album") 
public class Album implements Serializable { 
    private static final long serialVersionUID = 1L; 

    @Id 
    @Column(name="id", unique=true, nullable=false) 
    private int id; 

    @Column(name="title", nullable=false) 
    private String title; 

    @Column(name="artist_id", nullable=false) 
    private int artistId; 

    @Column(name="cover_url") 
    private String coverUrl;

    public int getId() { 
        return id; 
    } 

    public void setId(int id) { 
        this.id = id; 
    } 

    public String getTitle() { 
        return title; 
    } 

    public void setTitle(String title) { 
        this.title = title; 
    } 

    public int getArtistId() { 
        return artistId; 
    } 

    public void setArtistId(int artistId) { 
        this.artistId = artistId; 
    } 

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override 
    public String toString() { 
        return "Album{" + 
               "id=" + id + 
               ", title='" + title + '\'' + 
               ", artistId=" + artistId + 
               ", coverUrl='" + coverUrl + '\'' + 
               '}'; 
    } 
}