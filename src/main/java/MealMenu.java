package src.main.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import java.lang.*;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.collections.ObservableList;

/**
 * Controller that deals with when you click into a specific foods category, such as 'Breakfast'.
 *
 * @author Luke.s
 * @version V2
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
      Main.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

  }

@FXML
void initialize() {

  ObservableList<Meals> data = MealLoader.GenerateData(type, true,"meals.csv");
  tableView = new NutritionTableView(tableView, data).getNutritionTableView(); //Creates a new nutrition table and fills it in with data. Then it retrieves it.

  enableTableFunctions();

  backButton.setOnAction(event -> {goBack(event);});
  addNewItemButton.setOnAction(event -> {addItem(event);});
  }

/**
* Sets the behaviour that the tableView has.
* When a row is clicked, two buttons are then activated that don't make sense without a meal selection.
* You can either call a selected meal to be added to your plate, or removed as an item.
*/
private void enableTableFunctions(){

  tableView.setRowFactory(tv -> {

  TableRow<Meals> row = (TableRow<Meals>)new TableRow();

  // When a row is clicked, then enable the following code.
  row.setOnMouseClicked(event -> {
      if (!row.isEmpty()) {
          Meals rowData = (Meals)row.getItem();
          addItemToPlateButton.setOnAction(ev -> addItemToPlate(ev, rowData));
          deleteItemButton.setOnAction(ev -> removeItem(ev, rowData));
      }
  });
  return row;
  });

}

/**
* Called when the user presses 'addNewFoodItem', and triggers the program to enter onto the add item page.
*/
public void addItem(ActionEvent event){
  AddItemController addItemController = new AddItemController(type);
}

/**
* Called when the user presses 'addItemToPlate', and triggers the program to enter onto the quantity page.
* The user must have selected a meal from the tableview.
* @param mealToAdd The meal to add as selected from the table.
*/
public void addItemToPlate(ActionEvent event, Meals mealToAdd){
  QuantityMenuController quantityMenu = new QuantityMenuController(type, mealToAdd);
}

/**
* Called when the user presses 'deleteItem'.
* The user must have selected a meal from the tableview.
* @param mealToRemove The meal to remove as selected from the table.
*/
public void removeItem(ActionEvent event, Meals mealToRemove){
  MealLoader.deleteRow(mealToRemove, "meals.csv");
  MealMenu mealMenu = new MealMenu(type);
}

public void goBack(ActionEvent event){
  MealSelectionController menu = new MealSelectionController();
}

}
