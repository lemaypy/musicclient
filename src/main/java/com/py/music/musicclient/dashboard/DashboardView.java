package com.py.music.musicclient.dashboard;

import java.io.Serializable;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class DashboardView implements Serializable {
  private static final long serialVersionUID = 1L;
  
  final private VerticalLayout root = new VerticalLayout();
  final private HorizontalLayout header = new HorizontalLayout();
  final private Panel content = new Panel();
  final private VerticalLayout footer = new VerticalLayout();
  final private VerticalLayout contentLayout = new VerticalLayout();
  final private HorizontalSplitPanel hsplitSetlistView = new HorizontalSplitPanel();
  
  public DashboardView() {
    this.buildLayout();
    this.setContent(this.buildSetlistContent());
    
  }

  
  public VerticalLayout getRoot() {
    return root;
  }

  //final private HorizontalLayout header = new HorizontalLayout();
  //Panel hpanel = new Panel("Horizontal Split");
  
  
  private void buildLayout() {    
    this.buildHeader();
    this.buildContent();
    this.buildFooter(); 
    root.setSizeFull(); 
    root.setExpandRatio(content, 1);
  }
  private void buildHeader() {
    final Label labelDashboard = new Label("Dashboard");
    labelDashboard.setStyleName("musicclient-label-1");
    final Label labelBand = new Label("Press Tone");
    labelBand.setSizeUndefined(); // Take minimum space

    this.header.addComponent(labelDashboard);
    this.header.addComponent(labelBand);
    this.header.setWidth("100%");
    this.header.setExpandRatio(labelDashboard, 1.0f); // Expand
    
    this.root.addComponent(this.header);
  }
  private void setContent(Component c) {
    contentLayout.removeAllComponents();
    contentLayout.addComponent(c);
    contentLayout.setExpandRatio(c,1);
  }
  private void buildContent() {
    content.setSizeFull();
    contentLayout.setSizeUndefined(); // to ensure a scrollbar appears if the content won't fit otherwise
    contentLayout.setSizeFull();
    content.setContent(contentLayout);
    final Label labelCenter = new Label("Center");
    contentLayout.addComponent(labelCenter);
    root.addComponent(content);
  }
  private void buildFooter() {
    final Label labelFooter = new Label("Footer");

    footer.addComponent(labelFooter);   
    root.addComponent(footer); 
  }
  private Component buildSetlistContent(){
    HorizontalSplitPanel hsplit = this.hsplitSetlistView;
  //  hsplit.addStyleName("backColorAzure");
    //hsplit.setSizeFull();
    hsplit.setSizeUndefined();
    
  //  hpanel.setContent(hsplit);
    Panel leftPanel = new Panel();
    leftPanel.addStyleName("backColorGrey");
    leftPanel.setContent(new Label("Here's the left panel"));
   // leftPanel.addComponent(new Label("Here's the left panel"));
    hsplit.setFirstComponent(leftPanel);

    hsplit.setSecondComponent(new Label("Here's the right panel"));
    hsplit.setVisible(true);
    hsplit.setWidth("10px");
  //  this.root.addComponent(hsplit);
    //hsplit.setSizeFull();
   // hpanel.setSpacing(true);
   // root.setExpandRatio(hsplit, 1);
    return hsplit;
  }
  /*
  VerticalLayout mainLayout = new VerticalLayout();
  mainLayout.setSizeFull(); // to ensure whole space is in use
  mainWindow.setContent(mainLayout);
  setMainWindow(mainWindow);

  VerticalLayout header = new VerticalLayout();
  Panel content = new Panel();
  content.setSizeFull(); // to ensure the panel only takes the available space
  VerticalLayout footer = new VerticalLayout();

  mainLayout.addComponent(header);
  mainLayout.addComponent(content);
  mainLayout.addComponent(footer);
  mainLayout.setExpandRatio(content, 1); // to determine which component takes the excess space

  VerticalLayout contentLayout = new VerticalLayout();
  contentLayout.setSizeUndefined(); // to ensure a scrollbar appears if the content won't fit otherwise
  content.addComponent(contentLayout);*/
}
