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

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AddItemController
{

  @FXML
    private BorderPane root;

    @FXML
    private Button backButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField caloriesInput;

    @FXML
    private TextField carbsInput;

    @FXML
    private TextField proteinInput;

    @FXML
    private TextField fatInput;

    @FXML
    private TextField saturatesInput;

    @FXML
    private TextField sugarInput;

    @FXML
    private TextField fibreInput;

    @FXML
    private TextField saltInput;

    private String type;

public AddItemController(String type){

  this.type = type;

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/addItemMenu.fxml"));
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
  }

public void goBack(ActionEvent event){
  MealMenu mealMenu = new MealMenu(type);
}

}
