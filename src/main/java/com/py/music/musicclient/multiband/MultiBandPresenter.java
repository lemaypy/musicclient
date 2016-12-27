package com.py.music.musicclient.multiband;

import com.py.music.musicclient.MusicClientModel;
import com.py.music.musicclient.MvpPresenter;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Tree;

public class MultiBandPresenter implements MvpPresenter{
  private IMultiBandView view;
  private MusicClientModel model;
  @Override
  public Layout getViewLayout() {
    return view.getLayout();
  }

  public MultiBandPresenter(MultiBandView pMultiBandView, MusicClientModel pMusicClientModel){
    this.view = pMultiBandView;
    this.model = pMusicClientModel;
    this.initView();
  }
  private void initView() {
    Tree menu = view.getMenu();
    Object[][] planets = model.getPlanets();
    // Add planets as root items in the tree.
    for (int i = 0; i < planets.length; i++) {
      final String planet = (String) (planets[i][0]);
      menu.addItem(planet);

      if (planets[i].length == 1) {
        // The planet has no moons so make it a leaf.
        menu.setChildrenAllowed(planet, false);
      } else {
        // Add children (moons) under the planets.
        for (int j = 1; j < planets[i].length; j++) {
          final String moon = (String) planets[i][j];

          // Add the item as a regular item.
          menu.addItem(moon);

          // Set it to be a child.
          menu.setParent(moon, planet);

          // Make the moons look like leaves.
          menu.setChildrenAllowed(moon, false);
        }

        // Expand the subtree.
        menu.expandItemsRecursively(planet);
      }
    }
    menu.addValueChangeListener(new Property.ValueChangeListener() {
      private static final long serialVersionUID = 1L;

      public void valueChange(ValueChangeEvent event) {
        if (event.getProperty() != null && event.getProperty().getValue() != null) {
          view.getLocation().setValue("The cat is in " + event.getProperty().getValue());
        }
      }
    });
    menu.setImmediate(true);

  }
}
