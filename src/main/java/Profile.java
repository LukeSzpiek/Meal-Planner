package src.main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.lang.*;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import java.util.*;
import java.io.*;
import java.lang.Object.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;

/**
 * Write a description of JavaFX class Profile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Profile
{
    /**
     * The start method is the main entry point for every JavaFX application.
     * It is called after the init() method has returned and after
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */

    private int fieldsFilled = 0;

    private HashMap hm = UserDataManager.loadUserStats();

    Collection test = hm.values();

    Object[] sh = test.toArray();

    int s = (int)sh[0];
    int h = (int)sh[1];
    int w = (int)sh[2];
    int a = (int)sh[3];
    int c = (int)sh[4];


    public void start(Scene sc, BorderPane mp, MainScreen mainScreen)
    {
        int widthOfWindow = 300;
        int heightOfWindow = 500;

        Label weightLabel = new Label("Weight (lbs):");
        TextField weightTextField = new TextField ();
        weightTextField.setText(""+w);
        HBox weightHBox = new HBox();
        weightHBox.getChildren().addAll(weightLabel, weightTextField);
        weightHBox.setSpacing(10);

        Label heightLabel = new Label("Height (Inches):");
        TextField heightTextField = new TextField ();
        heightTextField.setText(""+h);
        HBox heightHBox = new HBox();
        heightHBox.getChildren().addAll(heightLabel, heightTextField);
        heightHBox.setSpacing(10);

        Label ageLabel = new Label("Age (YEARS):");
        TextField ageTextField = new TextField ();
        ageTextField.setText(""+a);
        HBox ageHBox = new HBox();
        ageHBox.getChildren().addAll(ageLabel, ageTextField);
        ageHBox.setSpacing(10);

        Label sexLabel = new Label("Sex:");
        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll("Male","Female");

        if (s==0){
            cb.setValue("Male");
        }

        else if (s==1){
            cb.setValue("Female");
        }

        else{
        cb.setPromptText("-");
    }

        HBox sexHBox = new HBox();
        sexHBox.getChildren().addAll(sexLabel, cb);

        Label calorieLabel = new Label("");

        Button exitButton = new Button("Back");
        exitButton.setPrefHeight(50);
        exitButton.setPrefWidth(widthOfWindow);
        mp.setBottom(exitButton);
        exitButton.setOnAction(event -> {mainScreen.drawMainMenu();});

        calorieLabel.setText("Your caloric maintanence is: "+c);


        Button calculate = new Button("Calculate Calories");
        calculate.setOnAction(event -> {calculateCalories(weightTextField, heightTextField, ageTextField, cb, calorieLabel);
        });
        //calculate.setDisable(true);

        Image image;

        VBox topVBox = new VBox();
        topVBox.setPadding(new Insets(25));
        GridPane gp = new GridPane();

        try{
                image = new Image(new FileInputStream("ProfileLogo.png"));
                ImageView imageView = new ImageView(image);


                //gp.add(imageView,0,1);
                topVBox.getChildren().add(imageView);

                //mp.setTop(imageView);
                }

                catch(Exception e){
                Circle circle = new Circle();
                circle.setCenterX(100.0f);
                circle.setCenterY(100.0f);
                circle.setRadius(50.0f);

                topVBox.getChildren().add(circle);

                }



        topVBox.getChildren().add(gp);
        topVBox.getChildren().add(calculate);
        topVBox.getChildren().add(calorieLabel);

        //gp.add(profileLabel,0,1);



        gp.add(weightLabel,0,2);
        gp.add(weightTextField,1,2);

        gp.add(heightLabel,0,3);
        gp.add(heightTextField,1,3);

        gp.add(ageLabel,0,4);
        gp.add(ageTextField,1,4);

        gp.add(sexLabel,0,5);
        gp.add(cb,1,5);

        //gp.add(calculate,0,6);

        //gp.add(calorieLabel,0,7);


        //VBox vb = new VBox(gp, calculate, calorieLabel);

        //vb.setPadding(new Insets(10, 50, 50, 10));
        //vb.setSpacing(10);

        //gp.setHgap(100);
        gp.setVgap(10);

        topVBox.setPadding(new Insets(20));
        topVBox.setSpacing(10.00);

        mp.setCenter(topVBox);
        gp.setPadding(new Insets(20));

    }

    private double calculateCalories(TextField weightTextField, TextField heightTextField, TextField ageTextField, ComboBox cb, Label calorieLabel){

        double calories = 0;

        Integer weight = Integer.parseInt(weightTextField.getCharacters().toString());
        Integer height = Integer.parseInt(heightTextField.getCharacters().toString());
        Integer age = Integer.parseInt(ageTextField.getCharacters().toString());

        String sexStr = (String) cb.getValue();

        Integer sex = 0;

        if(sexStr=="Male"){
            sex = 0;
        }

        else if(sexStr=="Female"){
            sex = 1;
        }

        if(weight!=null && height!=null && age!=null && sex!=null){
            if(sex==0){
                //calories = (int) (66 + (6.3 * weight) + (12.9 * height) - (6.8 * age));
                System.out.println(weight);
                System.out.println(height);
                System.out.println(age);
                calories = (int) (66 + (6.3 * weight) + (12.9 * height) - (6.8 * age));
            }

            if(sex==1){
                calories = (int) (655 + (4.3 * weight) + (4.7 * height) - (4.7 * age));
            }
        }

        int cal = (int) calories;

        int adjustedCal = (int) (cal*1.2);

        calorieLabel.setText("Your caloric maintanence is: "+(adjustedCal));

        UserDataManager.changeValue("Sex",sex);
        UserDataManager.changeValue("Height",height);
        UserDataManager.changeValue("Weight",weight);
        UserDataManager.changeValue("Age",age);
        UserDataManager.changeValue("Calories",adjustedCal);

        UserDataManager.writeUserStats();

        return cal;
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
    }
}
