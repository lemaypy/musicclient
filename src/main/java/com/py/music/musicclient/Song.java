package com.py.music.musicclient;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Song implements Serializable{
  private String artist = "";
  private String title  = "";
  
  public Song(String pArtist, String pTitle){
    this.artist=pArtist;
    this.title=pTitle;
    }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
//test
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
