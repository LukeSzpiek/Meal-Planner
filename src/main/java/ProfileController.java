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

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProfileController
{

@FXML
private TextField ageLabel;

@FXML
private ComboBox sexComboBox;

@FXML
private TextField heightLabel;

@FXML
private TextField weightLabel;

@FXML
private Button calculateCaloriesButton;

@FXML
private Label caloriesLabel;

@FXML
private Button backButton;


private Profile profile;


public ProfileController(Profile prof){
  profile = prof;

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/profile.fxml"));
      loader.setController(this);
      MainMenu.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }


  }

@FXML
void initialize() {
  weightLabel.setText(""+profile.getUserWeight());
  heightLabel.setText(""+profile.getUserHeight());
  ageLabel.setText(""+profile.getUserAge());
  sexComboBox.getItems().addAll("Male","Female");
  caloriesLabel.setText(""+profile.getUserCalories()+" calories.");

  if (profile.getUserSex()==0){
      sexComboBox.setValue("Male");
  }

  else if (profile.getUserSex()==1){
      sexComboBox.setValue("Female");
  }

  else{
      sexComboBox.setPromptText("-");
  }


  calculateCaloriesButton.setOnAction(event -> {caloriePress();});
  backButton.setOnAction(event -> {goBack(event);});

  }

public void goBack(ActionEvent event){
  MainMenu menu = new MainMenu();
  menu.loadMenu();
}

public Profile getProfile() {
      return profile;
    }

private void caloriePress(){

caloriesLabel.setText(calculateCalories()+" calories.");

}

// Harris-Bennedict (Male): 66 + 13.7*Weight + 5*Height – 6.8*Age
// Harris-Bennedict (Female): 655 + 9.6*Weight + 1.8*Height – 4.7*Age
private int calculateCalories(){

    double calories = 0;

    Integer weight = Integer.parseInt(weightLabel.getCharacters().toString());
    Integer height = Integer.parseInt(heightLabel.getCharacters().toString());
    Integer age = Integer.parseInt(ageLabel.getCharacters().toString());

    String sexStr = (String) sexComboBox.getValue();

    Integer sex = 0;

    if(sexStr=="Male"){
        sex = 0;
    }

    else if(sexStr=="Female"){
        sex = 1;
    }

    if(weight!=null && height!=null && age!=null && sex!=null){
        // Male
        if(sex==0){
            calories = (int) (66 + (13.7 * weight) + (5 * height) - (6.8 * age));
        }

        // Female
        if(sex==1){
            calories = (int) (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age));
        }
    }

    int cal = (int) calories;

    int adjustedCal = (int) (cal*1.2);

    //caloriesLabel.setText(""+(adjustedCal)+" calories.");

    UserDataManager.changeValue("Sex",sex);
    UserDataManager.changeValue("Height",height);
    UserDataManager.changeValue("Weight",weight);
    UserDataManager.changeValue("Age",age);
    UserDataManager.changeValue("Calories",adjustedCal);

    UserDataManager.writeUserStats();

    return (int) adjustedCal;

}

}
