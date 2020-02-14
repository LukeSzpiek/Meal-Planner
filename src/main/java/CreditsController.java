package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Controller class that deals with displaying the credits menu.
 *
 * @author Luke.s
 * @version V2
 */
public class CreditsController
{

   @FXML
   private Button backButton;

public CreditsController(){

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/creditsMenu.fxml"));
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
 * Creates a new mealMenu class. Triggers the program to enter back into the MainMenu.java controller.
 * @param event ActionEvent causing the method call.
 */
public void goBack(ActionEvent event){
  MainMenu menu = new MainMenu(false);
}

}
