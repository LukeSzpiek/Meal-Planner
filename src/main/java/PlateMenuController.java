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

import javafx.collections.ObservableList;

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlateMenuController
{

@FXML
private BorderPane root;

@FXML
private Button backButton;

@FXML
private Button statsButton;

@FXML
private Button deleteButton;

@FXML
private TableView<Meals> breakfastTableView;

@FXML
private TableView<Meals> lunchTableView;

@FXML
private TableView<Meals> dinnerTableView;

@FXML
private TableView<Meals> snacksTableView;

@FXML
private TableView<Meals> boostersTableView;

public PlateMenuController(){

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/plateMenu.fxml"));
      loader.setController(this);
      MainMenu.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

  }

@FXML
void initialize() {

  ObservableList<Meals> breakfastData = MealLoader.GenerateData("Breakfast", true,"plate.csv");
  breakfastTableView = new NutritionTableView(breakfastTableView, breakfastData).getNutritionTableView();

  ObservableList<Meals> lunchData = MealLoader.GenerateData("Lunch", true,"plate.csv");
  lunchTableView = new NutritionTableView(lunchTableView, lunchData).getNutritionTableView();

  ObservableList<Meals> dinnerData = MealLoader.GenerateData("Dinner", true,"plate.csv");
  dinnerTableView = new NutritionTableView(dinnerTableView, dinnerData).getNutritionTableView();

  ObservableList<Meals> snacksData = MealLoader.GenerateData("Snacks", true,"plate.csv");
  snacksTableView = new NutritionTableView(snacksTableView, snacksData).getNutritionTableView();

  ObservableList<Meals> boostersData = MealLoader.GenerateData("Boosters", true,"plate.csv");
  boostersTableView = new NutritionTableView(boostersTableView, boostersData).getNutritionTableView();

  backButton.setOnAction(event -> {goBack(event);});
  deleteButton.setOnAction(event -> {clearPlate(event);});
  statsButton.setOnAction(event -> {statsMenu(event);});
  }

public void statsMenu(ActionEvent event){
  StatisticsController statsController = new StatisticsController();
}

public void clearPlate(ActionEvent event){

PlateHandler.clearCurrentMeals();
PlateHandler.clearBreakfastMeals();
PlateHandler.clearLunchMeals();
PlateHandler.clearDinnerMeals();
PlateHandler.clearSnackMeals();
PlateHandler.clearBoosterMeals();
MealLoader.createNewPlate();

PlateMenuController plateMenuController = new PlateMenuController();

}

public void goBack(ActionEvent event){
  MainMenu menu = new MainMenu();
  menu.loadMenu();
}

}
