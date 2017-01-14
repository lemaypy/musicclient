package com.py.music.musicclient.explorer;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

public class ExplorerGrid {
  private Grid grid = new Grid();
  
  public ExplorerGrid() {
    this.initGrid();
  }
  public Component getComponent() {
    return grid;
  }
  public Grid getGrid() {
    return grid;
  }
  private void initGrid() {
    grid.setSelectionMode(SelectionMode.MULTI);
    grid.addColumn("artist", String.class);
    grid.addColumn("title", String.class);
   // MusicClientModel model = new MusicClientModel();
   // BeanItemContainer<Song> container = new BeanItemContainer<Song>(Song.class, model.getSongs());
  //  grid.setContainerDataSource(container);
 //   grid.addRow("Led Zeppelin","Communication Breakdown");
  //  grid.addRow("Black Sabbath","War Pigs");
    
  }
  /*
  public void fillGrid(List<Song> songs) {
    BeanItemContainer<Song> container = new BeanItemContainer<Song>(Song.class, songs);
    grid.setContainerDataSource(container);
    grid.markAsDirty();    
  }*/
}
