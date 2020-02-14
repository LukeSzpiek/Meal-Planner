package src.main.java;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


/**
 * A controller class dealing with the user's profile.
 *
 * @author Luke.s
 * @version V2
 */
public class ProfileController
{

@FXML
private TextField ageLabel;

@FXML
private ComboBox<String> sexComboBox;

@FXML
private TextField heightLabel;

@FXML
private TextField weightLabel;

@FXML
private Button calculateCaloriesButton;

@FXML
private Label caloriesLabel;

@FXML
private Button backButton;


private Profile profile;


public ProfileController(Profile prof){
  profile = prof;

  try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/profile.fxml"));
      loader.setController(this);
      Main.mainScene.setRoot((Parent) loader.load());
    }
    catch(Exception e){
      System.out.println(e);
    }


  }

@FXML
void initialize(){
  weightLabel.setText(""+profile.getUserWeight());
  heightLabel.setText(""+profile.getUserHeight());
  ageLabel.setText(""+profile.getUserAge());
  sexComboBox.getItems().addAll("Male","Female");
  caloriesLabel.setText(""+profile.getUserCalories()+" calories.");

  // A value of 0 signals 'male', and 1 'female'.
  if (profile.getUserSex()==0){sexComboBox.setValue("Male");} else if (profile.getUserSex()==1){sexComboBox.setValue("Female");} else{sexComboBox.setPromptText("-");}

  calculateCaloriesButton.setOnAction(event -> {caloriePress();});
  backButton.setOnAction(event -> {goBack(event);});
  }

/**
 * Triggered when the calculate button is pressed. Triggers calculation and saving of calories, and updates the calorie label.
 */
private void caloriePress(){
  caloriesLabel.setText(calculateCalories()+" calories.");
}

private void goBack(ActionEvent event){
  MainMenu menu = new MainMenu(false);
}

/**
 * @return Returns profile model containing user data.
 */
private Profile getProfile() {
  return profile;
}

/**
 * Calculates and returns maintance calories.
 * @return The amount of calories the user should be consuming to maintain their body weight.
 *
 * Harris-Bennedict (Male): 66 + 13.7*Weight + 5*Height – 6.8*Age
 * Harris-Bennedict (Female): 655 + 9.6*Weight + 1.8*Height – 4.7*Age
 *
 */
private int calculateCalories(){

    double calories = 0;

    Integer weight = Integer.parseInt(weightLabel.getCharacters().toString());
    Integer height = Integer.parseInt(heightLabel.getCharacters().toString());
    Integer age = Integer.parseInt(ageLabel.getCharacters().toString());

    String sexStr = (String) sexComboBox.getValue();

    Integer sex = 0;

    if(sexStr=="Male"){sex = 0;} else if(sexStr=="Female"){sex = 1;}

    if(weight!=null && height!=null && age!=null && sex!=null){
        // Male
        if(sex==0){calories = (int) (66 + (13.7 * weight) + (5 * height) - (6.8 * age));}

        // Female
        if(sex==1){calories = (int) (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age));}
    }

    int cal = (int) calories;
    int adjustedCal = (int) (cal*1.2);

    updateCalories(sex, height, weight, age, adjustedCal);

    return (int) adjustedCal;

}

/**
 * Updates the value of each profile element and writes them to the profile csv file.
 */
private void updateCalories(Integer sex, Integer height, Integer weight, Integer age, int adjustedCal){
  UserDataManager.changeValue("Sex",sex);
  UserDataManager.changeValue("Height",height);
  UserDataManager.changeValue("Weight",weight);
  UserDataManager.changeValue("Age",age);
  UserDataManager.changeValue("Calories",adjustedCal);

  UserDataManager.writeUserStats();
}

}
