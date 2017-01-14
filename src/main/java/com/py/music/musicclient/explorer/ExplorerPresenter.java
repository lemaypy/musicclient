package com.py.music.musicclient.explorer;

import com.py.music.musicclient.MusicClientModel;
import com.py.music.musicclient.MusicClientModel.Song;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Grid;

public class ExplorerPresenter {
  private ExplorerView     view;
  private MusicClientModel model;

  public ExplorerPresenter(ExplorerView view, MusicClientModel model) {
    this.view = view;
    this.model = model;
  }

  public void showAllSongs() {
    Grid grid = this.view.getGrid();

    BeanItemContainer<Song> container = new BeanItemContainer<Song>(Song.class, model.getSongs());
    grid.setContainerDataSource(container);
    /*
     * ((BeanItemContainer<Song>)grid.getContainerDataSource()).removeAllItems()
     * ; ((BeanItemContainer<Song>)grid.getContainerDataSource()).addAll(songs);
     */
    grid.markAsDirty();
    // BeanItemContainer<Song> container = new
    // BeanItemContainer<Song>(Song.class, songs);
    // grid.setContainerDataSource(container);

  }
}
