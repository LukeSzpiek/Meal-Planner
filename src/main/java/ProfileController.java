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
private FXMLLoader loader;

public ProfileController(Profile prof){
  profile = prof;

  loader = new FXMLLoader(getClass().getResource("/scenes/profile.fxml"));
  loader.setController(this);
  }

@FXML
void initialize() {
  weightLabel.setText(""+profile.getUserWeight());
  heightLabel.setText(""+profile.getUserHeight());
  ageLabel.setText(""+profile.getUserAge());
  sexComboBox.getItems().addAll("Male","Female");

  if (profile.getUserSex()==0){
      sexComboBox.setValue("Male");
  }

  else if (profile.getUserSex()==1){
      sexComboBox.setValue("Female");
  }

  else{
      sexComboBox.setPromptText("-");
  }

  calculateCaloriesButton.setOnAction(event -> {calculateCalories();});

  }

public Profile getProfile() {
      return profile;
    }

public FXMLLoader getLoader() {
      return loader;
    }

private double calculateCalories(){

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
        if(sex==0){
            //calories = (int) (66 + (6.3 * weight) + (12.9 * height) - (6.8 * age));
            System.out.println(weight);
            System.out.println(height);
            System.out.println(age);
            calories = (int) (66 + (6.3 * weight) + (12.9 * height) - (6.8 * age));
        }

        if(sex==1){
            calories = (int) (655 + (4.3 * weight) + (4.7 * height) - (4.7 * age));
        }
    }

    int cal = (int) calories;

    int adjustedCal = (int) (cal*1.2);

    caloriesLabel.setText("Your caloric maintanence is: "+(adjustedCal));

    UserDataManager.changeValue("Sex",sex);
    UserDataManager.changeValue("Height",height);
    UserDataManager.changeValue("Weight",weight);
    UserDataManager.changeValue("Age",age);
    UserDataManager.changeValue("Calories",adjustedCal);

    UserDataManager.writeUserStats();

    return calories;

}

}
