package com.py.music.musicclient.multiband;

import com.py.music.musicclient.MvpView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;

public interface IMultiBandView extends MvpView {
  public Tree getMenu();
  public Label getLocation();
}
