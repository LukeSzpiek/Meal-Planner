package src.main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.lang.*;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import java.util.*;
import java.io.*;
import java.lang.Object.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Node;

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainMenu extends Application
{

   @FXML
   private Button profileButton;

   @FXML
   private Button foodsButton;

   @FXML
   private Button plateButton;

   @FXML
   private Button creditsButton;

   @FXML
   private Button exitButton;

   private Stage stage;
   private Parent root;
   public static Scene mainScene;

   private Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
   public double widthOfWindow = visualBounds.getWidth();
   public double heightOfWindow = visualBounds.getHeight();
   public Style STYLE = Style.LIGHT;

   private FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/main.fxml"));

   @Override
   public void start(Stage stage) throws IOException {
          this.stage = stage;

          loader.setController(this);
          mainScene = new Scene(loader.load(), widthOfWindow, heightOfWindow);
          JMetro jm = new JMetro(mainScene, STYLE);

          stage.setTitle("Luke's Meal Planner");
          stage.setScene(mainScene);
          stage.show();
       }


   @FXML
   void initialize() {}

   public FXMLLoader getLoader() {
          return loader;
        }

   public void profileClick(ActionEvent event) throws IOException {
      Profile prof = new Profile();
      ProfileController profController = new ProfileController(prof);
    }

    public void foodsClick(ActionEvent event) throws IOException {
       FoodsMenu foodsMenu = new FoodsMenu();
     }

   public void exitClick(ActionEvent event) throws IOException {
     stage.close();
     }

   public void loadMenu(){
      try{
      loader.setController(this);
      MainMenu.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

    }

}
