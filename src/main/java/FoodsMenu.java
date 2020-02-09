package src.main.java;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Controller class that deals with the navigation menu leading to the different meal categories.
 *
 * @author Luke.s
 * @version V2
 */
public class FoodsMenu
{

  @FXML
  private BorderPane root;

  @FXML
  private Button backButton;

  @FXML
  private Button breakfastButton;

  @FXML
  private Button lunchButton;

  @FXML
  private Button dinnerButton;

  @FXML
  private Button snacksButton;

  @FXML
  private Button boostersButton;


public FoodsMenu(){

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/mealTypeMenu.fxml"));
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
  }

/**
 * Moves the execution into the mealMenu controller.
 * The button pressed is probed and fed to the mealMenu to determine which version of the page is to be displayed.
 * @param event ActionEvent causing the method call. Used when determining what page to go to next.
 */
public void buttonEventHandler(ActionEvent event){
  Button button = (Button)event.getSource();
  MealMenu mealMenu = new MealMenu(button.getText());
}

/**
 * Creates a new mealMenu class. Triggers the program to enter back into the MainMenu.java controller.
 * @param event ActionEvent causing the method call.
 */
public void goBack(ActionEvent event){
  MainMenu menu = new MainMenu(false);
}

}
