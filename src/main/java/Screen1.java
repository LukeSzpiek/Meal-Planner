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
public class Screen1
{

   private FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/screen1.fxml"));

   /**
    * Constructor for the main menu.
    * @param first Boolean to check if it is the first time it is being called. If it is, then don't set the mainScene.
    */
   public Screen1(boolean first){
          try {
              loader.setController(this);

              if(!first)
                Main.mainScene.setRoot((Parent) loader.load());

            }
            catch(Exception e){
              System.out.println(e);
            }
       }

   @FXML
   void initialize() {}

  public FXMLLoader getLoader(){
    return loader;
  }

  public void page2Click(ActionEvent event) throws IOException {
    Screen2 screen2 = new Screen2();
  }

  public void exitClick(ActionEvent event) throws IOException {
     Platform.exit();
     System.exit(0);
   }

}
