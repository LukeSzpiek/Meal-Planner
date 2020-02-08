package src.main.java;

import java.util.*;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

/**
 * Controller class dealing with when the user is viewing the statistics of their plate.
 *
 * @author Luke.s
 * @version V2
 */
public class StatisticsController
{

  @FXML
  private BorderPane root;

  @FXML
  private Button backButton;

  @FXML
  private Label statsLabel;

  Statistics statistics;

public StatisticsController(Statistics statistics){

  this.statistics = statistics;

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/statisticsMenu.fxml"));
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
  statsLabel.setText(statistics.getStatisticsText());
  }

public void goBack(ActionEvent event){
  PlateMenuController plateMenuController = new PlateMenuController();
}

}
