package com.py.music.musicclient.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.py.music.musicclient.Song;

public class MusicService {
  private static String sourceDirectory = "/opt/music/allsongs/";

  public MusicService() {

  }

  public static List<Song> getAllSongs() {
    List<Song> songs = new ArrayList<Song>();

    File directory = new File(sourceDirectory);

    String[] mp3Filenames;
    FilenameFilter filter = new FilenameFilter() {
      public boolean accept(File directory, String fileName) {
        return fileName.endsWith(".mp3");
      }
    };
    mp3Filenames = directory.list(filter);
    directory.listFiles(filter);

    for (String f : mp3Filenames) {
      Mp3File mp3Song = null;
      try {
        mp3Song = new Mp3File(sourceDirectory+f);
      } catch (UnsupportedTagException e) {
        e.printStackTrace();
      } catch (InvalidDataException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (mp3Song.hasId3v2Tag()) {
        ID3v2 id3v2tag = mp3Song.getId3v2Tag();
        String artist = id3v2tag.getAlbumArtist();
        String title = id3v2tag.getTitle();
        songs.add(new Song(artist,title));
       // System.out.println("artist : "+artist);
        // byte[] imageData = id3v2tag.getAlbumImage();
        // converting the bytes to an image
        // BufferedImage img = ImageIO.read(new
        // ByteArrayInputStream(imageData));
      }
    }
    return songs;
  }
}
