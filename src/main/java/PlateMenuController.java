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
 * Controller class that deals with the plate menu, which displays foods you select you have eaten today.
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

  // Gets an observableList of meals of a certain category, and puts them into a new NutritialTableView.
  ObservableList<Meals> breakfastData = PlateHandler.getBreakfastMealsObservable();
  breakfastTableView = new NutritionTableView(breakfastTableView, breakfastData).getNutritionTableView();

  ObservableList<Meals> lunchData = PlateHandler.getLunchMealsObservable();
  lunchTableView = new NutritionTableView(lunchTableView, lunchData).getNutritionTableView();

  ObservableList<Meals> dinnerData = PlateHandler.getDinnerMealsObservable();
  dinnerTableView = new NutritionTableView(dinnerTableView, dinnerData).getNutritionTableView();

  ObservableList<Meals> snacksData = PlateHandler.getSnacksMealsObservable();
  snacksTableView = new NutritionTableView(snacksTableView, snacksData).getNutritionTableView();

  ObservableList<Meals> boostersData = PlateHandler.getBoostersMealsObservable();
  boostersTableView = new NutritionTableView(boostersTableView, boostersData).getNutritionTableView();

  backButton.setOnAction(event -> {goBack(event);});
  deleteButton.setOnAction(event -> {clearPlate(event);});
  statsButton.setOnAction(event -> {statsMenu(event);});
  }

/**
 * Moves the execution of the code into the stats menu.
 */
public void statsMenu(ActionEvent event){
  Statistics statistics = new Statistics();
  StatisticsController statsController = new StatisticsController(statistics);
}

/**
 * Clears all meals from the plate and triggers the generation of a new plate.csv file, then refreshes the page by creating a new PlateMenu.
 */
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
