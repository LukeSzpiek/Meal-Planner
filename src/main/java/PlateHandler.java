package src.main.java;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * Deals with providing information to the PlateMenuController and StatisticsController on information regarding the user's plate (selected food choices).
 *
 * @author Luke.s
 * @version V2
 */
public abstract class PlateHandler
{
    private static ArrayList<Meals> currentMeals = new ArrayList<Meals>();
    private static ArrayList<Meals> breakfastMeals = new ArrayList<Meals>();
    private static ArrayList<Meals> lunchMeals = new ArrayList<Meals>();
    private static ArrayList<Meals> dinnerMeals = new ArrayList<Meals>();
    private static ArrayList<Meals> snacksMeals = new ArrayList<Meals>();
    private static ArrayList<Meals> boostersMeals = new ArrayList<Meals>();

    /**
     * @return An arraylist of ALL current meals.
     */
    public static ArrayList<Meals> getCurrentMeals()
    {
        return currentMeals;
    }

    public static void addCurrentMeals(Meals meal){
        currentMeals.add(meal);
    }

    public static void clearCurrentMeals(){
        currentMeals.clear();
    }

    /**
     * @return An arraylist of ALL breakfast meals.
     */
    public static ArrayList<Meals> getBreakfastMeals()
    {
        return breakfastMeals;
    }

    public static ObservableList<Meals> getBreakfastMealsObservable()
    {
        return makeObservable(breakfastMeals);
    }

    public static void addBreakfast(Meals meal){
        breakfastMeals.add(meal);
    }

    public static void clearBreakfastMeals(){
        breakfastMeals.clear();
    }

    /**
     * @return An arraylist of ALL lunch meals.
     */
    public static ArrayList<Meals> getLunchMeals()
    {
        return lunchMeals;
    }

    public static ObservableList<Meals> getLunchMealsObservable()
    {
        return makeObservable(lunchMeals);
    }

    public static void addLunch(Meals meal){
        lunchMeals.add(meal);
    }

    public static void clearLunchMeals(){
        lunchMeals.clear();
    }

    /**
     * @return An arraylist of ALL dinner meals.
     */
    public static ArrayList<Meals> getDinnerMeals()
    {
        return dinnerMeals;
    }

    public static ObservableList<Meals> getDinnerMealsObservable()
    {
        return makeObservable(dinnerMeals);
    }

    public static void addDinner(Meals meal){
        dinnerMeals.add(meal);
    }

    public static void clearDinnerMeals(){
        dinnerMeals.clear();
    }

    /**
     * @return An arraylist of ALL snacks.
     */
    public static ArrayList<Meals> getSnacksMeals()
    {
        return snacksMeals;
    }

    public static ObservableList<Meals> getSnacksMealsObservable()
    {
        return makeObservable(snacksMeals);
    }

    public static void addSnack(Meals meal){
        snacksMeals.add(meal);
    }

    public static void clearSnackMeals(){
        snacksMeals.clear();
    }

    /**
     * @return An arraylist of ALL boosters.
     */
    public static ArrayList<Meals> getBoostersMeals()
    {
        return boostersMeals;
    }

    public static ObservableList<Meals> getBoostersMealsObservable()
    {
        return makeObservable(boostersMeals);
    }

    public static void addBoosters(Meals meal){
        boostersMeals.add(meal);
    }

    public static void clearBoosterMeals(){
        boostersMeals.clear();
    }

    /**
     * @param asset The nutritional element you want to retrieve.
     * @return Double of the total amount of a certain nutritinal element.
     */
    public static double getTotalAsset(String asset){
      double total = 0;
      for(Meals meal:currentMeals){
          total += returnAsset(meal, asset);
      }
      return total;
    }

    /**
     * @param meal A meal.
     * @param asset A certain asset you want to retrieve from that meal.
     * @return The asset from that meal.
     */
    public static double returnAsset(Meals meal, String asset){
      if(asset=="calories") return meal.getCalories();
      else if(asset=="carbs") return meal.getCarbs();
      else if(asset=="protein") return meal.getProtein();
      else if(asset=="fat") return meal.getFat();
      else if(asset=="saturates") return meal.getSaturates();
      else return meal.getSugar();
    }

    /**
     * @return Makes an ordinary ArrayList into an ObservableList and returns it.
     */
    private static ObservableList<Meals> makeObservable(ArrayList<Meals> arrayOfMeals){
      ObservableList<Meals> generatedData = FXCollections.observableArrayList();
      Iterator itr = arrayOfMeals.iterator();
      while (itr.hasNext()) {
        generatedData.add((Meals)itr.next());
      }
      return generatedData;
    }

    /**
     * Very similar to 'generateData' in MealLoader.java.
     * Will be updated in the future so that this method is the only one used for this function.
     * @param meal A meal type.
     * @return An observable list of meals in a selected category to be put into a TableView.
     */
    public static ObservableList<Meals> getObservableData(String meal){
      if(meal=="Breakfast") return getBreakfastMealsObservable();
      else if(meal=="Lunch") return getLunchMealsObservable();
      else if(meal=="Dinner") return getDinnerMealsObservable();
      else if(meal=="Snacks") return getSnacksMealsObservable();
      else return getBoostersMealsObservable();
    }

}
