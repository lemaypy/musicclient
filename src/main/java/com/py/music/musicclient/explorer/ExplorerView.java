package com.py.music.musicclient.explorer;

import java.io.Serializable;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class ExplorerView implements Serializable {

  private static final long serialVersionUID = 1L;
  final private HorizontalLayout header = new HorizontalLayout();
  final private Panel content = new Panel();
  final private VerticalLayout contentLayout = new VerticalLayout();
  final private VerticalLayout root = new VerticalLayout();
  private Grid grid;

  public Grid getGrid() {
    return grid;
  }
  public ExplorerView() {
    this.buildLayout();
  }
  public Component getContent() {
    return this.root;
  }
  private void buildLayout() {    
    this.buildHeader();
    this.buildContent();
 
    root.setSizeFull(); 
    root.setExpandRatio(content, 1);
  }
  
  private void buildHeader() {
    final Label labelExplorer = new Label("Explorer");
    labelExplorer.setStyleName("musicclient-label-1");
    this.header.addComponent(labelExplorer);
    this.header.setWidth("100%");
    this.header.setExpandRatio(labelExplorer, 1.0f); // Expand
    
    this.root.addComponent(this.header);
  }
  private void buildContent() {
    content.setSizeFull();
    contentLayout.setSizeUndefined(); // to ensure a scrollbar appears if the content won't fit otherwise
    contentLayout.setSizeFull();
    //contentLayout.addStyleName("backLightBlue");
    contentLayout.addStyleName("deepSkyBlue");
    content.setContent(contentLayout);
    
    HorizontalLayout hl = new HorizontalLayout();
    hl.setHeight("100%");
    hl.setWidth("100%"); 
    Component left = this.createListPanel();  

    Panel right = this.createToolPanel();
    right.setWidthUndefined();
    right.setHeight("100%");

    hl.addComponent(left);
    hl.addComponent(right);
    hl.setExpandRatio(left, 1.0f); // Expand

    contentLayout.addComponent(hl);
    
    root.addComponent(content);
  }
  private Component createListPanel() {
    ExplorerGrid eg = new ExplorerGrid();
    grid = eg.getGrid();
    //Component grid = eg.getComponent();
    grid.setSizeFull();
    grid.addStyleName("backColorGrey");
    grid.setHeight("100%");
    grid.setWidth("100%");    
    return grid;
  }
  private Panel createToolPanel() {
    return new Panel("tools");
  }
}
