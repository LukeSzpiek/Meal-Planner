package src.main.java;

import javafx.scene.Parent;
import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Controller class that deals with the main menu of the program.
 *
 * @author Luke.s
 */
public class Screen2
{

   private FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/screen2.fxml"));

   public Screen2(){
          try {
              loader.setController(this);
              Main.mainScene.setRoot((Parent) loader.load());
            }
            catch(Exception e){
              System.out.println(e);
            }
       }

   @FXML
   void initialize() {}

  public void page1Click(ActionEvent event) throws IOException {
     Screen1 screen1 = new Screen1(false);
  }

  public FXMLLoader getLoader(){
    return loader;
  }

}
