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

    private int fieldsFilled = 0;

    private int sex;
    private int height;
    private int weight;
    private int age;
    private int calories;


    public Profile(){

      HashMap hm = UserDataManager.getUserStats();
      Object[] sh = hm.values().toArray();

      sex = (int)sh[0];
      height = (int)sh[1];
      weight = (int)sh[2];
      age = (int)sh[3];
      calories = (int)sh[4];

    }

    public int getUserSex(){
      return sex;
    }

    public int getUserHeight(){
      return height;
    }

    public int getUserWeight(){
      return weight;
    }

    public int getUserAge(){
      return age;
    }

    public int getUserCalories(){
      return calories;
    }

}
