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

public void buttonEventHandler(ActionEvent event){
  Button button = (Button)event.getSource();
  MealMenu mealMenu = new MealMenu(button.getText());
}

@FXML
void initialize() {
  backButton.setOnAction(event -> {goBack(event);});
  }

public void goBack(ActionEvent event){
  MainMenu menu = new MainMenu(false);
}



}
