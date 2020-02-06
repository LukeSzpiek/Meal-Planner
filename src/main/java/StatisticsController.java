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

//import com.gluonhq.charm.glisten.control.*;
//import com.gluonhq.charm.glisten.control.Icon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import javafx.scene.Node;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StatisticsController
{

  @FXML
  private BorderPane root;

  @FXML
  private Button backButton;

  @FXML
  private Label statsLabel;

public StatisticsController(){

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/statisticsMenu.fxml"));
      loader.setController(this);
      MainMenu.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

  }

@FXML
void initialize() {
  backButton.setOnAction(event -> {goBack(event);});

  HashMap hm = UserDataManager.loadUserStats();

  Collection test = hm.values();

  Object[] sh = test.toArray();

  int s = (int)sh[0];
  int h = (int)sh[1];
  int w = (int)sh[2];
  int a = (int)sh[3];
  int c = (int)sh[4];

  double shouldEatCarbs = (0.50*c)/4;
  double shouldEatProtein = (0.75*w);
  double shouldEatFat = ((0.275*c)/9);
  double maximumSugar = ((c*0.1)/4);

  statsLabel.setText("YOUR TOTAL CONSUMPTION:"+
  "\n"+"Calories: "+PlateHandler.getTotalCalories()+
  "\n"+"Carbs: "+PlateHandler.getTotalCarbs()+
  "\n"+"Protein: "+PlateHandler.getTotalProtein()+
  "\n"+"Fat: "+PlateHandler.getTotalFats()+
  "\n"+"Saturates: "+PlateHandler.getTotalSaturates()+
  "\n"+"Sugar: "+PlateHandler.getTotalSugar()+
  "\n"+"\n"+
  "YOU SHOULD BE CONSUMING: "+
  "\n"+"Calories: "+c+" ("+Math.round((PlateHandler.getTotalCalories()/c)*100)+"%"+")"+
  "\n"+"Carbs: "+(shouldEatCarbs)+" ("+Math.round((PlateHandler.getTotalCarbs()/shouldEatCarbs)*100)+"%"+")"+
  "\n"+"Protein: "+(shouldEatProtein)+" ("+Math.round((PlateHandler.getTotalProtein()/shouldEatProtein)*100)+"%"+")"+
  "\n"+"Fat: "+(shouldEatFat)+" ("+Math.round((PlateHandler.getTotalFats()/shouldEatFat)*100)+"%"+")"+
  "\n"+"Sugar: "+(maximumSugar));

  }

public void goBack(ActionEvent event){
  PlateMenuController plateMenuController = new PlateMenuController();
}

}
