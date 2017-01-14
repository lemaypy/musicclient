package com.py.music.musicclient.dashboard;

import com.py.music.musicclient.MusicClientModel;
import com.py.music.musicclient.explorer.ExplorerPresenter;

public class DashboardPresenter {
  private DashboardView view; 
//  private MusicClientModel model;
  private ExplorerPresenter explorerPresenter;
  
  public DashboardPresenter(DashboardView view, MusicClientModel model) {
    this.view = view;
   // this.model = model;
    
    this.explorerPresenter = new ExplorerPresenter(view.getExplorerView(),model);
    this.fillAllSongs();
  }

  public DashboardView getView() {
    return view;
  }
  public void fillAllSongs() {
    this.explorerPresenter.showAllSongs();
  }
}
