package src.main.java;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * A controller class dealing with when the user is prompted to enter a quntity of food, when adding a food to their plate.
 *
 * @author Luke.s
 * @version V2
 */
public class QuantityMenuController
{

  @FXML
  private BorderPane root;

  @FXML
  private Button backButton;

  @FXML
  private TextField quantityInput;

  @FXML
  private Button addToPlateButton;

  String type;
  Meals data;

public QuantityMenuController(String type, Meals data){

  this.data = data;
  this.type = type;

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/quantityMenu.fxml"));
      loader.setController(this);
      Main.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }

  }

@FXML
void initialize() {
  backButton.setOnAction(event -> {goBack(event);});
  addToPlateButton.setOnAction(event -> {addToPlate(event);});
  }

public void addToPlate(ActionEvent event){

  AdjustDataQuantity(data, Double.parseDouble(quantityInput.getCharacters().toString()));

  goBack(event);
}

public void goBack(ActionEvent event){
  MealMenu mealMenu = new MealMenu(type);
}

/**
 * Creates a new meal item that has had its nutritional quantities adjusted.
 */
public void AdjustDataQuantity(Meals meals,  double quantity) {
    System.out.println(quantity);
    if (quantity != 1.0 || quantity != 1 || quantity != 1.00) {
        meals = new Meals(meals.getKey(), meals.getType(), meals.getName(), meals.getCalories() * quantity, meals.getCarbs() * quantity, meals.getProtein() * quantity, meals.getFat() * quantity, meals.getSaturates() * quantity, meals.getSugar() * quantity, meals.getSalt() * quantity, meals.getFibre() * quantity, meals.getB1() * quantity, meals.getB2() * quantity, meals.getB3() * quantity, meals.getB6() * quantity, meals.getB9() * quantity, meals.getB12() * quantity, meals.getD() * quantity, meals.getIron() * quantity);
    }
    AddMealToMealList(meals);
}

/**
 * Adds a new meal, that has perhaps had its quantity adjusted, to the 'plate.csv' file, which holds all of the meals currently on the user's plate, and adds it to the current meal list.
 */
private void AddMealToMealList(Meals meal) {
    PlateHandler.addCurrentMeals(meal);

    String type = meal.getType();

    if (type.equals("Breakfast")) {
        PlateHandler.addBreakfast(meal);
        MealLoader.addRow(meal, "plate.csv");
    }
    else if (type.equals("Lunch")) {
        PlateHandler.addLunch(meal);
        MealLoader.addRow(meal, "plate.csv");
    }
    else if (type.equals("Dinner")) {
        PlateHandler.addDinner(meal);
        MealLoader.addRow(meal, "plate.csv");
    }
    if (type.equals("Snacks")) {
        PlateHandler.addSnack(meal);
        MealLoader.addRow(meal, "plate.csv");
    }
    if (type.equals("Boosters")) {
        PlateHandler.addBoosters(meal);
        MealLoader.addRow(meal, "plate.csv");
    }
}

}
