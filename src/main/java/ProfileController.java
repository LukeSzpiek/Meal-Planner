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

import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.control.Icon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
private ChoiceBox<?> sexComboBox;

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
  }

public Profile getProfile() {
      return profile;
    }

public FXMLLoader getLoader() {
      return loader;
    }

}
