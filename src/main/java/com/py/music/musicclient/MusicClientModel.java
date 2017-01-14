package com.py.music.musicclient;

import java.util.ArrayList;
import java.util.List;

public class MusicClientModel {
  private Object[][] planets;
  private List<Song> songs = new ArrayList<Song>();

  public List<Song> getSongs() {
    return songs;
  }

  public MusicClientModel() {
    this.buildModel();
  }

  private void buildModel() {
  /*  this.planets = new Object[][] { new Object[] { "Mercury" }, new Object[] { "Venus" },
        new Object[] { "Earth", "The Moon" }, new Object[] { "Mars", "Phobos", "Deimos" },
        new Object[] { "Jupiter", "Io", "Europa", "Ganymedes", "Callisto" },
        new Object[] { "Saturn", "Titan", "Tethys", "Dione", "Rhea", "Iapetus" },
        new Object[] { "Uranus", "Miranda", "Ariel", "Umbriel", "Titania", "Oberon" },
        new Object[] { "Neptune", "Triton", "Proteus", "Nereid", "Larissa" } };*/
    songs.add(new Song("Led Zeppelin","Communication Breakdown"));
    songs.add(new Song("Black Sabbath","War Pigs"));
    songs.add(new Song("David Bowie","Starman"));
  }

  public Object[][] getPlanets() {
    return planets;
  }

  public class Song {
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

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }
}
