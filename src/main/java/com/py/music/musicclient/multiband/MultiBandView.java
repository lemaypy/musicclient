package com.py.music.musicclient.multiband;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class MultiBandView implements IMultiBandView{
  final private VerticalLayout root = new VerticalLayout();
  final private HorizontalLayout titleBar = new HorizontalLayout();
  private Tree menu;
  private Label location;
  
  public MultiBandView() {
    this.buildLayout();
  }
  @Override
  public Tree getMenu() {
    return menu;
  }
  @Override
  public Layout getLayout() {
    return root;
  }

  private void buildLayout() {
    titleBar.setWidth("100%");
    root.addComponent(titleBar);

    Label title = new Label("The Band Toolkit");
    // title.setHeight("28px");
 //   title.setStyleName("valo-font-color");
    title.setStyleName("musicclient-label-1");
    titleBar.addComponent(title);
    titleBar.setExpandRatio(title, 1.0f); // Expand

    Label titleComment = new Label("for Press Tone");
    titleComment.setSizeUndefined(); // Take minimum space
    titleBar.addComponent(titleComment);
    titleBar.setExpandRatio(title, 1.0f); // Minimize the comment

    // Horizontal layout with selection tree on the left and
    // a details panel on the right.
    HorizontalLayout horlayout = new HorizontalLayout();
    horlayout.setSizeFull();
    horlayout.setSpacing(true);
    root.addComponent(horlayout);
    root.setExpandRatio(horlayout, 1);

    // Layout for the menu area. Wrap the menu in a Panel to allow
    // scrollbar.
    Panel menuContainer = new Panel("The Possible Places");
    menuContainer.addStyleName("menucontainer");
    menuContainer.addStyleName("light"); // No border
    menuContainer.setWidth("-1px"); // Undefined width
    menuContainer.setHeight("100%");
    // menuContainer.getContent().setWidth("-1px"); // Undefined width
    horlayout.addComponent(menuContainer);

    // A menu tree, fill it later.
    this.menu = new Tree();
    menu.setSizeUndefined();
    // menuContainer.addComponent(menu);
    menuContainer.setContent(menu);

    // A panel for the main view area on the right side
    Panel detailspanel = new Panel("Details");
    detailspanel.addStyleName("detailspanel");
    detailspanel.addStyleName("light"); // No borders
    detailspanel.setSizeFull();
    horlayout.addComponent(detailspanel);

    // Have a vertical layout in the Details panel.
    VerticalLayout detailslayout = new VerticalLayout();
    detailslayout.setSizeFull();
    detailspanel.setContent(detailslayout);

    // Put some stuff in the Details view.
    VerticalLayout detailsbox = new VerticalLayout();
    detailsbox.setSizeUndefined();
    final Label question = new Label("Where is the cat?");
    question.setSizeUndefined();
    detailsbox.addComponent(question);
    location = new Label("I don't know! Tell me!");
    location.setSizeUndefined();
    detailsbox.addComponent(location);
    detailslayout.addComponent(detailsbox);
    detailslayout.setComponentAlignment(detailsbox, Alignment.MIDDLE_CENTER);

    // Let the details panel take as much space as possible and
    // have the selection tree to be as small as possible
    horlayout.setExpandRatio(detailspanel, 1);
    horlayout.setExpandRatio(menuContainer, 0);
    root.setMargin(true);  
  }
  @Override
  public Label getLocation() {
    return this.location;
  }
  
}
