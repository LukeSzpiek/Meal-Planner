package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.application.Platform;

/**
 * Main launching class. Sets up the stage, root, and scene of the project.
 *
 * @author Luke.s
 * @version V2
 */
public class Main extends Application
{

   public static Scene mainScene; // Global variable making it easy to switch the scene from the rest of the program.

   private Stage stage;
   private Parent root;
   private Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
   private double widthOfWindow = visualBounds.getWidth();
   private double heightOfWindow = visualBounds.getHeight();
   private Style STYLE = Style.LIGHT;

   @Override
   public void start(Stage stage) throws IOException {
          this.stage = stage;

          // The 'true' boolean in the MainMenu call states that the constructor is being called from the application start method.
          //This stops it from overwriting the mainScene in construction and causing a stackOverflow error.
          Screen1 screen1 = new Screen1(true);

          this.mainScene = new Scene(screen1.getLoader().load(), widthOfWindow, heightOfWindow);
          JMetro jm = new JMetro(mainScene, STYLE);

          this.stage.setTitle("Minimal FX Application");
          this.stage.setScene(mainScene);
          this.stage.show();
       }

}
