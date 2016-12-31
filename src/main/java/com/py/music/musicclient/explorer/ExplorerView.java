package com.py.music.musicclient.explorer;

import java.io.Serializable;

import com.vaadin.ui.Component;
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
    final Label labelDashboard = new Label("Header");
    labelDashboard.setStyleName("musicclient-label-1");
  //  final Label labelBand = new Label("Press Tone");
  //  labelBand.setSizeUndefined(); // Take minimum space

    this.header.addComponent(labelDashboard);
   // this.header.addComponent(labelBand);
    this.header.setWidth("100%");
    this.header.setExpandRatio(labelDashboard, 1.0f); // Expand
    
    this.root.addComponent(this.header);
  }
  private void buildContent() {
    content.setSizeFull();
    contentLayout.setSizeUndefined(); // to ensure a scrollbar appears if the content won't fit otherwise
    contentLayout.setSizeFull();
    contentLayout.addStyleName("backLightBlue");
    content.setContent(contentLayout);
    
    HorizontalLayout hl = new HorizontalLayout();
    hl.setHeight("100%");
    hl.setWidth("100%"); 
    Panel left = this.createListPanel();
    left.setSizeFull();
    left.addStyleName("backLightBlue");
    left.setHeight("100%");
    left.setWidth("100%");    

    Panel right = this.createToolPanel();
    right.setWidthUndefined();
    right.setHeight("100%");
    hl.addComponent(left);
    hl.addComponent(right);
    hl.setExpandRatio(left, 1.0f); // Expand
   // final Label labelCenter = new Label("Liste");
   // contentLayout.addComponent(labelCenter);
    contentLayout.addComponent(hl);
    
    root.addComponent(content);
  }
  private Panel createListPanel() {
    return new Panel();
  }
  private Panel createToolPanel() {
    return new Panel("tools");
  }
}
