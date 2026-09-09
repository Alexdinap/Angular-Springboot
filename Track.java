package com.sintialab.entity; 
import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import java.io.Serializable; 
@Entity 
@Table(name="track") 
public class Track implements Serializable {  private static final long serialVersionUID = 1L; 
 @Id 
 @Column(name="id", unique=true, nullable=false)  private int id; 
 @Column(name="number", nullable=false)  private int number;
 @Column(name="title", nullable=false) 
 private String title; 
 @Column(name="album_id", nullable=false) 
 private int albumId; 
 public int getId() { 
 return id; 
 } 
 public void setId(int id) { 
 this.id = id; 
 } 
 public int getNumber() { 
 return number; 
 } 
 public void setNumber(int number) { 
 this.number = number; 
 } 
 public String getTitle() { 
 return title; 
 } 
 public void setTitle(String title) { 
 this.title = title; 
 } 
 public int getAlbumId() { 
 return albumId; 
 } 
 public void setAlbumId(int albumId) { 
 this.albumId = albumId; 
 } 
 @Override 
 public String toString() { 
 return "Track{" + 
 "id=" + id + 
 ", number=" + number + 
 ", title='" + title + '\'' + 
 ", albumId=" + albumId + 
 '}'; 
 } 
} 
