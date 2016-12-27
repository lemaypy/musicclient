package com.py.music.musicclient;

public class MusicClientModel {
  private Object[][] planets;

    public MusicClientModel(){
      this.buildModel();
    }
    private void buildModel(){
      this.planets = new Object[][] { new Object[] { "Mercury" }, new Object[] { "Venus" },
        new Object[] { "Earth", "The Moon" }, new Object[] { "Mars", "Phobos", "Deimos" },
        new Object[] { "Jupiter", "Io", "Europa", "Ganymedes", "Callisto" },
        new Object[] { "Saturn", "Titan", "Tethys", "Dione", "Rhea", "Iapetus" },
        new Object[] { "Uranus", "Miranda", "Ariel", "Umbriel", "Titania", "Oberon" },
        new Object[] { "Neptune", "Triton", "Proteus", "Nereid", "Larissa" } };
    }
    public Object[][] getPlanets() {
      return planets;
    }
}
