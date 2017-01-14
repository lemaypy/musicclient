package com.py.music.musicclient.dashboard;

import java.io.Serializable;

import com.py.music.musicclient.explorer.ExplorerView;
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
  final private HorizontalSplitPanel setlistContent= new HorizontalSplitPanel();
  final private ExplorerView explorerView = new ExplorerView();
  
  public ExplorerView getExplorerView() {
    return explorerView;
  }


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
    HorizontalSplitPanel hsplit = this.setlistContent;
    Panel leftPanel = new Panel();
    Panel rightPanel = new Panel();   
    
    leftPanel.addStyleName("backColorGrey");
    leftPanel.setSizeUndefined();
    leftPanel.setHeight("100%");
    leftPanel.setWidth("100%");    
    
   // ExplorerView ex = new ExplorerView();

    //leftPanel.setContent(new Label("Here's the left panel")); 
    //leftPanel.setContent(ex.getContent()); 
    leftPanel.setContent(this.explorerView.getContent()); 
    
    rightPanel.addStyleName("backColorGrey");
    rightPanel.setSizeUndefined();
    rightPanel.setHeight("100%");
    rightPanel.setWidth("100%");
    rightPanel.setContent(new Label("Here's the right panel"));
    
    hsplit.setSizeUndefined();
    hsplit.setHeight("100%");
    hsplit.setWidth("100%");
    hsplit.setFirstComponent(leftPanel);
    hsplit.setSecondComponent(rightPanel);
    hsplit.setVisible(true);

    return hsplit;
  }

}
