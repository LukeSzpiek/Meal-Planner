package src.main.java;

import java.util.ArrayList;

/**
 * A generic, empty, TableView that can be used throughout the application to display nuturitional information about a meal.
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
     *
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
     *
     */
    public static ArrayList<Meals> getBreakfastMeals()
    {
        return breakfastMeals;
    }

    public static void addBreakfast(Meals meal){
        breakfastMeals.add(meal);
    }

    public static void clearBreakfastMeals(){
        breakfastMeals.clear();
    }

    /**
     *
     */
    public static ArrayList<Meals> getLunchMeals()
    {
        return lunchMeals;
    }

    public static void addLunch(Meals meal){
        lunchMeals.add(meal);
    }

    public static void clearLunchMeals(){
        lunchMeals.clear();
    }

    /**
     *
     */
    public static ArrayList<Meals> getDinnerMeals()
    {
        return dinnerMeals;
    }

    public static void addDinner(Meals meal){
        dinnerMeals.add(meal);
    }

    public static void clearDinnerMeals(){
        dinnerMeals.clear();
    }

    /**
     *
     */
    public static ArrayList<Meals> getSnacksMeals()
    {
        return snacksMeals;
    }

    public static void addSnack(Meals meal){
        snacksMeals.add(meal);
    }

    public static void clearSnackMeals(){
        snacksMeals.clear();
    }

    /**
     *
     */
    public static ArrayList<Meals> getBoostersMeals()
    {
        return boostersMeals;
    }

    public static void addBoosters(Meals meal){
        boostersMeals.add(meal);
    }

    public static void clearBoosterMeals(){
        boostersMeals.clear();
    }

    /**
     *
     * Loads in all of the meals currently on the late, and adds them to their respective ArrayList.
     *
     */
    public static void loadMealLists(){

        ArrayList<Meals> ArrayOfMeals = (ArrayList<Meals>)MealLoader.load("plate.csv");

        for(Meals meal:ArrayOfMeals){
            if(meal.getType().equals("Breakfast")){
                    addBreakfast(meal);
                }

            else if(meal.getType().equals("Lunch")){
                    addLunch(meal);
                }

            else if(meal.getType().equals("Dinner")){
                    addDinner(meal);
                }

            else if(meal.getType().equals("Snacks")){
                    addSnack(meal);
                }

            else if(meal.getType().equals("Boosters")){
                    addBoosters(meal);
                }

            addCurrentMeals(meal);

            }
    }

    public static double getTotalCalories(){

        double calTotal = 0;

        for(Meals meal:currentMeals){
            calTotal += meal.getCalories();
        }

        return calTotal;

    }

    public static double getTotalCarbs(){

        double carbTotal = 0;

        for(Meals meal:currentMeals){
            carbTotal += meal.getCarbs();
        }

        return carbTotal;

    }

    public static double getTotalProtein(){

        double proteinTotal = 0;

        for(Meals meal:currentMeals){
            proteinTotal += meal.getProtein();
        }

        return proteinTotal;


    }

    public static double getTotalFats(){

        double fatsTotal = 0;

        for(Meals meal:currentMeals){
            fatsTotal += meal.getFat();
        }

        return fatsTotal;


    }

    public static double getTotalSaturates(){

        double satTotal = 0;

        for(Meals meal:currentMeals){
            satTotal += meal.getSaturates();
        }

        return satTotal;


    }

    public static double getTotalSugar(){

        double sugarTotal = 0;

        for(Meals meal:currentMeals){
            sugarTotal += meal.getSugar();
        }

        return sugarTotal;


    }

}
