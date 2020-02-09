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
 * @version V2
 */
public class MainMenu
{

   @FXML
   private Button profileButton;

   @FXML
   private Button foodsButton;

   @FXML
   private Button plateButton;

   @FXML
   private Button creditsButton;

   @FXML
   private Button exitButton;

   private FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/main.fxml"));

   /**
    * Constructor for the main menu.
    * @param first Boolean to check if it is the first time it is being called. If it is, then don't set the mainScene.
    */
   public MainMenu(boolean first){
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


     public void profileClick(ActionEvent event) throws IOException {
        Profile prof = new Profile();
        ProfileController profController = new ProfileController(prof);
      }

      public void foodsClick(ActionEvent event) throws IOException {
         FoodsMenu foodsMenu = new FoodsMenu();
       }

      public void plateClick(ActionEvent event) throws IOException {
        PlateMenuController plateMenu = new PlateMenuController();
        }

      public void creditsClick(ActionEvent event) throws IOException {
        CreditsController creditsMenu = new CreditsController();
        }

     public void exitClick(ActionEvent event) throws IOException {
         Platform.exit();
         System.exit(0);
       }

}
