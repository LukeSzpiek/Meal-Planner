package src.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import com.opencsv.CSVReader;
import java.net.URISyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class MealLoader {

    public MealLoader(){
    }

    /**
     * Return an ArrayList containing the rows in the AirBnB London data set csv file.
     */
    public static ArrayList<Meals> load(String fileName) {
        ArrayList<Meals> listings = new ArrayList<Meals>();
        try{
            URL url = MealLoader.class.getResource("/"+fileName);
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));
            String [] line;
            //skip the first row (column headers)
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                int key = convertInt(line[0]);
                String type = line[1];
                String name = line[2];
                double calories = convertDouble(line[3]);
                double carbs = convertDouble(line[4]);
                double protein = convertDouble(line[5]);
                double fat = convertDouble(line[6]);
                double saturates = convertDouble(line[7]);
                double sugar = convertDouble(line[8]);
                double fibre = convertDouble(line[9]);
                double salt = convertDouble(line[10]);
                double b1 = convertDouble(line[11]);
                double b2 = convertDouble(line[12]);
                double b3 = convertDouble(line[13]);
                double b6 = convertDouble(line[14]);
                double b9 = convertDouble(line[15]);
                double b12 = convertDouble(line[16]);
                double d = convertDouble(line[17]);
                double iron = convertDouble(line[18]);

                Meals listing = new Meals(key, type, name, calories, carbs, protein, fat, saturates, sugar, fibre, salt, b1, b2, b3, b6, b9, b12, d, iron);
                //System.out.println("Created meal");
                listings.add(listing);
            }
        } catch(IOException | URISyntaxException e){
            System.out.println("Failure! Something went wrong");
            e.printStackTrace();
        }
        //System.out.println("Success! Number of loaded records: " + listings.size());
        return listings;
    }

    public static void addMeal(String type, TextField nameTextField, TextField calorieTextField, TextField carbsTextField, TextField proteinTextField, TextField fatTextField, TextField saturatesTextField,
    TextField sugarTextField, TextField fibreTextField, TextField saltTextField, TextField b1TextField, TextField b2TextField, TextField b3TextField,
    TextField b6TextField, TextField b9TextField, TextField b12TextField, TextField dTextField, TextField ironTextField){
        int key = MealLoader.getRows() + 1;

             String name = nameTextField.getCharacters().toString();

             if(name.equals("")){
                 name = ""+key;
                 System.out.println("No name");
                }

             ArrayList<String> doubleList = new ArrayList();

             doubleList.add(calorieTextField.getCharacters().toString());
             doubleList.add(carbsTextField.getCharacters().toString());
             doubleList.add(proteinTextField.getCharacters().toString());
             doubleList.add(fatTextField.getCharacters().toString());
             doubleList.add(saturatesTextField.getCharacters().toString());
             doubleList.add(sugarTextField.getCharacters().toString());
             doubleList.add(fibreTextField.getCharacters().toString());
             doubleList.add(saltTextField.getCharacters().toString());
             doubleList.add(b1TextField.getCharacters().toString());
             doubleList.add(b2TextField.getCharacters().toString());
             doubleList.add(b3TextField.getCharacters().toString());
             doubleList.add(b6TextField.getCharacters().toString());
             doubleList.add(b9TextField.getCharacters().toString());
             doubleList.add(b12TextField.getCharacters().toString());
             doubleList.add(dTextField.getCharacters().toString());
             doubleList.add(ironTextField.getCharacters().toString());

             Iterator doubleIt = doubleList.iterator();

             int counter = 0;

             while(doubleIt.hasNext()){
                 Object next = doubleIt.next();

                 if(next.equals("")){
                     doubleList.set(counter,"0");
                    }

                 counter++;
                }

             double calorie = Double.parseDouble(doubleList.get(0));
             double carbs = Double.parseDouble(doubleList.get(1));
             double protein = Double.parseDouble(doubleList.get(2));
             double fat = Double.parseDouble(doubleList.get(3));
             double saturates = Double.parseDouble(doubleList.get(4));
             double sugar = Double.parseDouble(doubleList.get(5));
             double fibre = Double.parseDouble(doubleList.get(6));
             double salt = Double.parseDouble(doubleList.get(7));
             double b1 = Double.parseDouble(doubleList.get(8));
             double b2 = Double.parseDouble(doubleList.get(9));
             double b3 = Double.parseDouble(doubleList.get(10));
             double b6 = Double.parseDouble(doubleList.get(11));
             double b9 = Double.parseDouble(doubleList.get(12));
             double b12 = Double.parseDouble(doubleList.get(13));
             double d = Double.parseDouble(doubleList.get(14));
             double iron = Double.parseDouble(doubleList.get(15));

            MealLoader.addRow(new Meals(key, type, name, calorie, carbs, protein, fat, saturates, sugar, fibre, salt, b1, b2, b3, b6, b9, b12, d, iron), false, "meals.csv");
    }

    public static void addRow(Meals newMeal, boolean deleteRow, String file) {

    ArrayList<Meals> currentData = load(file);

    System.out.println("Done");

    if(deleteRow == false)
    currentData.add(newMeal);

    if(deleteRow == true){

        Iterator dataIterator = currentData.iterator();
        Meals currentMeal;

        while(dataIterator.hasNext()){
            currentMeal = (Meals) dataIterator.next();
            if(currentMeal.getKey() == newMeal.getKey()){
                dataIterator.remove();
                System.out.println("got here");
            }
        }
    }

    try (PrintWriter writer = new PrintWriter(new File(file))) {

      StringBuilder sb = new StringBuilder();

      sb.append("Key"); sb.append(',');
      sb.append("Type"); sb.append(','); sb.append("Name"); sb.append(','); sb.append("Calories"); sb.append(','); sb.append("Carbs"); sb.append(','); sb.append("Protein"); sb.append(',');
      sb.append("Fat"); sb.append(','); sb.append("Saturates"); sb.append(','); sb.append("Sugar"); sb.append(','); sb.append("Fibre"); sb.append(','); sb.append("Salt"); sb.append(',');
      sb.append("B1"); sb.append(','); sb.append("B2"); sb.append(','); sb.append("B3"); sb.append(','); sb.append("B6"); sb.append(','); sb.append("B9"); sb.append(','); sb.append("B12");
      sb.append(','); sb.append("D"); sb.append(','); sb.append("Iron"); sb.append(','); sb.append("\n");

      for(Meals meal : currentData){

      sb.append(meal.getKey());
      sb.append(',');
      sb.append(meal.getType());
      sb.append(',');
      sb.append(meal.getName());
      sb.append(',');
      sb.append(meal.getCalories());
      sb.append(',');
      sb.append(meal.getCarbs());
      sb.append(',');
      sb.append(meal.getProtein());
      sb.append(',');
      sb.append(meal.getFat());
      sb.append(',');
      sb.append(meal.getSaturates());
      sb.append(',');
      sb.append(meal.getSugar());
      sb.append(',');
      sb.append(meal.getFibre());
      sb.append(',');
      sb.append(meal.getSalt());
      sb.append(',');
      sb.append(meal.getB1());
      sb.append(',');
      sb.append(meal.getB2());
      sb.append(',');
      sb.append(meal.getB3());
      sb.append(',');
      sb.append(meal.getB6());
      sb.append(',');
      sb.append(meal.getB9());
      sb.append(',');
      sb.append(meal.getB12());
      sb.append(',');
      sb.append(meal.getD());
      sb.append(',');
      sb.append(meal.getIron());
      sb.append("\n");

    }

    writer.write(sb.toString());


    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

  }

    public static void createNewPlate(){

        try (PrintWriter writer = new PrintWriter(new File("plate.csv"))) {
      StringBuilder sb = new StringBuilder();

      sb.append("Key"); sb.append(',');
      sb.append("Type"); sb.append(','); sb.append("Name"); sb.append(','); sb.append("Calories"); sb.append(','); sb.append("Carbs"); sb.append(','); sb.append("Protein"); sb.append(',');
      sb.append("Fat"); sb.append(','); sb.append("Saturates"); sb.append(','); sb.append("Sugar"); sb.append(','); sb.append("Fibre"); sb.append(','); sb.append("Salt"); sb.append(',');
      sb.append("B1"); sb.append(','); sb.append("B2"); sb.append(','); sb.append("B3"); sb.append(','); sb.append("B6"); sb.append(','); sb.append("B9"); sb.append(','); sb.append("B12");
      sb.append(','); sb.append("D"); sb.append(','); sb.append("Iron"); sb.append(','); sb.append("\n");

      writer.write(sb.toString());
    }

    catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

    }

    /**
     *
     * @param doubleString the string to be converted to Double type
     * @return the Double value of the string, or -1.0 if the string is
     * either empty or just whitespace
     */
    private static Double convertDouble(String doubleString){
        if(doubleString != null && !doubleString.trim().equals("")){
            return Double.parseDouble(doubleString);
        }
        return -1.0;
    }

    /**
     *
     * @param intString the string to be converted to Integer type
     * @return the Integer value of the string, or -1 if the string is
     * either empty or just whitespace
     */
    private static Integer convertInt(String intString){
        if(intString != null && !intString.trim().equals("")){
            return Integer.parseInt(intString);
        }
        return -1;
    }

    public static int getRows(){
        ArrayList<Meals> currentData = load("meals.csv");

        return currentData.size();
    }

    /**
    * Fetches data to be displayed in a table.
    */
    public static ObservableList<Meals> GenerateData( String type,  boolean full, String file) {

        ArrayList<Meals> ArrayOfMeals = splitList(type, file);

        System.out.println(ArrayOfMeals.size());

        if (!full) {
            if (type.equals("Breakfast")) {
                ArrayOfMeals = PlateHandler.getBreakfastMeals();
            }
            else if (type.equals("Lunch")) {
                ArrayOfMeals = PlateHandler.getLunchMeals();
            }
            else if (type.equals("Dinner")) {
                ArrayOfMeals = PlateHandler.getDinnerMeals();
            }
            else if (type.equals("Snacks")) {
                ArrayOfMeals = PlateHandler.getSnacksMeals();
            }
            else if (type.equals("Boosters")) {
                ArrayOfMeals = PlateHandler.getBoostersMeals();
            }
        }


         ObservableList<Meals> generatedData = FXCollections.observableArrayList();
         Iterator itr = ArrayOfMeals.iterator();
        while (itr.hasNext()) {
            generatedData.add((Meals)itr.next());
        }
        return generatedData;
    }

    private static ArrayList<Meals> splitList(String type, String file) {
         ArrayList<Meals> airbnblistings = (ArrayList<Meals>)MealLoader.load(file);
         ArrayList<Meals> splitList = new ArrayList<Meals>();
        for ( Meals meal : airbnblistings) {
            if (meal.getType().equals(type)) {
                splitList.add(meal);
            }
        }
        return splitList;
    }

}
