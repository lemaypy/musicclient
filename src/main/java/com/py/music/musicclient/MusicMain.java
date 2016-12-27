package com.py.music.musicclient;

import javax.servlet.annotation.WebServlet;

import com.py.music.musicclient.multiband.MultiBandPresenter;
import com.py.music.musicclient.multiband.MultiBandView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("musictheme")
public class MusicMain extends UI {
  //private MultiBandView multibandview = new MultiBandView();
  private MusicClientModel musicClientModel = new MusicClientModel();
  private MultiBandPresenter multibandpresenter = new MultiBandPresenter(new MultiBandView(), musicClientModel );

 /* @Override
  protected void init(VaadinRequest vaadinRequest) {
    setContent(multibandview.getLayout());
  }*/
  @Override
  protected void init(VaadinRequest vaadinRequest) {
   // setContent(multibandview.getLayout());
    setContent(multibandpresenter.getViewLayout());
  }

  @WebServlet(urlPatterns = "/*", name = "MusicMainServlet", asyncSupported = true)
  @VaadinServletConfiguration(ui = MusicMain.class, productionMode = false)
  public static class MusicMainServlet extends VaadinServlet {
  }
}
