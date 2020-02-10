package src.main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * Controller class that deals with adding a food item.
 *
 * @author Luke.s
 * @version V2
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
      Main.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

  }

@FXML
private void initialize() {
  createButton.setOnAction(event -> {createItem(event);});
  backButton.setOnAction(event -> {goBack(event);});
  }

/**
 * Called when the 'createButton' is pressed. Calls the creation of a new meal.
 * @param event ActionEvent causing the method call.
 */
private void createItem(ActionEvent event){

  MealLoader.createNewMeal(type, nameInput, caloriesInput, carbsInput, proteinInput, fatInput, saturatesInput, sugarInput, fibreInput, saltInput, saltInput, saltInput, saltInput, saltInput, saltInput,
   saltInput, saltInput, saltInput);

  goBack(event);
}

/**
 * Creates a new mealMenu class. Triggers the program to enter back into the MainMenu.java controller.
 * @param event ActionEvent causing the method call.
 */
private void goBack(ActionEvent event){
  MealMenu mealMenu = new MealMenu(type);
}

}
