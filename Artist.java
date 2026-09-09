 package com.sintialab.entity; 
import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import java.io.Serializable; 
@Entity 
@Table(name="artist") 
public class Artist implements Serializable { 
 private static final long serialVersionUID = 1L; 
 @Id 
 @Column(name="id", unique=true, nullable=false) 
 private int id; 
 @Column(name="name", nullable=false)
 private String name; 
 public int getId() { 
 return id; 
 } 
 public void setId(int id) { 
 this.id = id; 
 } 
 public String getName() { 
 return name; 
 } 
 public void setName(String name) { 
 this.name = name; 
 } 
 @Override 
 public String toString() { 
 return "Artist{" + 
 "id=" + id + 
 ", name='" + name + '\'' + 
 '}'; 
 } 
} 
