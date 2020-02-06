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
import javafx.collections.ObservableList;

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MealMenu
{

   @FXML
   private BorderPane root;

   @FXML
   private Button backButton;

   @FXML
   private TableView<Meals> tableView;

   @FXML
   private Button addNewItemButton;

   @FXML
   private Button deleteItemButton;

   @FXML
   private Button addItemToPlateButton;

  private String type;


public MealMenu(String type){

  this.type = type;

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/mealMenu.fxml"));
      loader.setController(this);
      MainMenu.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

  }

@FXML
void initialize() {

  ObservableList<Meals> data = MealLoader.GenerateData(type, true,"meals.csv");
  tableView = new NutritionTableView(tableView, data).getNutritionTableView();

  tableView.setRowFactory(tv -> {

      TableRow<Meals> row = (TableRow<Meals>)new TableRow();

      row.setOnMouseClicked(event -> {
          if (!row.isEmpty()) {
              Meals rowData = (Meals)row.getItem();
              addItemToPlateButton.setOnAction(ev -> addItemToPlate(ev, rowData));
              deleteItemButton.setOnAction(ev -> {removeItem(ev, rowData);});
          }

      });

      return row;

  });

  backButton.setOnAction(event -> {goBack(event);});
  addNewItemButton.setOnAction(event -> {addItem(event);});
  }


public void addItem(ActionEvent event){
  AddItemController addItemController = new AddItemController(type);
}

public void addItemToPlate(ActionEvent event, Meals rowData){
  QuantityMenuController quantityMenu = new QuantityMenuController(type, rowData);
}

public void removeItem(ActionEvent event, Meals rowData){

  MealLoader.addRow(rowData, true, "meals.csv");
  MealMenu mealMenu = new MealMenu(type);

}

public void goBack(ActionEvent event){
  FoodsMenu menu = new FoodsMenu();
  //menu.loadMenu();
}

}
