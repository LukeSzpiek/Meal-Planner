package src.main.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;

/**
 * Controller class that deals with the plate menu, where you can select the foods you have eaten today.
 *
 * @author Luke.s
 * @version V2
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
      Main.mainScene.setRoot((Parent) loader.load());
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
  Statistics statistics = new Statistics();
  StatisticsController statsController = new StatisticsController(statistics);
}

public void clearPlate(ActionEvent event){

PlateHandler.clearCurrentMeals();
PlateHandler.clearBreakfastMeals();
PlateHandler.clearLunchMeals();
PlateHandler.clearDinnerMeals();
PlateHandler.clearSnackMeals();
PlateHandler.clearBoosterMeals();
MealLoader.generateDefaultFile("plate.csv");

PlateMenuController plateMenuController = new PlateMenuController();

}

public void goBack(ActionEvent event){
  MainMenu menu = new MainMenu(false);
}

}
