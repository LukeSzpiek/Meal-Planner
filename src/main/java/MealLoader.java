  package src.main.java;

  import java.io.IOException;
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
  import java.io.FileReader;

  /**
  * Class that deals with the activities of loading, saving and altering meals.csv and plate.csv.
  *
  * @author Luke.s
  * @version V2
  */
  public class MealLoader {

  private static ArrayList<Meals> loadedMeals = load("meals.csv");

  public MealLoader(){
  }

  /**
  * @return The amount of meals in "meals.csv".
  */
  public static int getRowCount(){
  return loadedMeals.size();
  }

  /**
  * Takes in an array of data about a meal and returns a new meal object.
  * @param line An array which models a meal record.
  */
  public static Meals createMeal(String[] line){
    Meals meal = new Meals(convertInt(line[0]), line[1], line[2], convertDouble(line[3]), convertDouble(line[4]), convertDouble(line[5]), convertDouble(line[6]), convertDouble(line[7]), convertDouble(line[8]), convertDouble(line[9]), convertDouble(line[10]), convertDouble(line[11]), convertDouble(line[12]), convertDouble(line[13]), convertDouble(line[14]), convertDouble(line[15]), convertDouble(line[16]), convertDouble(line[17]), convertDouble(line[18]));
    return meal;
  }

  /**
  * Loads the content of a given meal related file, and returns an ArrayList of meals containing all the meals in the designated file.
  * @param fileName contains a String of either 'meals.csv', or 'plate.csv' depending on which is to be loaded.
  */
  public static ArrayList<Meals> load(String fileName) {
  ArrayList<Meals> loadedMeals = new ArrayList<Meals>();

  try{
    CSVReader reader = new CSVReader(new FileReader("./src/main/resources/raw/"+fileName));
    String [] record;
    // Skips the first row, the column headers.
    reader.readNext();
    while ((record = reader.readNext()) != null) {
        Meals currentMeal = createMeal(record);
        loadedMeals.add(currentMeal);
    }
  }
  catch(IOException e){
  }
  return loadedMeals;
  }

  /**
  * Orchistrates the adding of a new meal to meals.csv.
  * TextField objects are probed for their input and split into a record.
  * addRow then called to append the newly created 'Meals' object.
  * @param TextFields containing meal data inputted by the user.
  */
  public static void createNewMeal(String type, TextField nameTextField, TextField calorieTextField, TextField carbsTextField, TextField proteinTextField, TextField fatTextField, TextField saturatesTextField,
  TextField sugarTextField, TextField fibreTextField, TextField saltTextField, TextField b1TextField, TextField b2TextField, TextField b3TextField,
  TextField b6TextField, TextField b9TextField, TextField b12TextField, TextField dTextField, TextField ironTextField){

  int key = MealLoader.getRowCount() + 1;
  String name = nameTextField.getCharacters().toString();

  if(name.equals("")){
     name = ""+key;
    }

  String[] record = new String[19];

  record[0] = ""+key;
  record[1] = type;
  record[2] = name;
  record[3] = (calorieTextField.getCharacters().toString());
  record[4] = (carbsTextField.getCharacters().toString());
  record[5] = (proteinTextField.getCharacters().toString());
  record[6] = (fatTextField.getCharacters().toString());
  record[7] = (saturatesTextField.getCharacters().toString());
  record[8] = (sugarTextField.getCharacters().toString());
  record[9] = (fibreTextField.getCharacters().toString());
  record[10] = (saltTextField.getCharacters().toString());
  record[11] = (b1TextField.getCharacters().toString());
  record[12] = (b2TextField.getCharacters().toString());
  record[13] = (b3TextField.getCharacters().toString());
  record[14] = (b6TextField.getCharacters().toString());
  record[15] = (b9TextField.getCharacters().toString());
  record[16] = (b12TextField.getCharacters().toString());
  record[17] = (dTextField.getCharacters().toString());
  record[18] = (ironTextField.getCharacters().toString());

  addRow(createMeal(record), "meals.csv");

  }

  /**
  * Loads the current data in, adds the new meal to it, and saves it.
  * @param newMeal The Meals object to be added.
  * @param file The name of the file that the row should be added to.
  */
  public static void addRow(Meals newMeal, String file) {

  ArrayList<Meals> currentData = load(file);

  currentData.add(newMeal);
  saveFile(file, currentData);

  }

  /**
  * Loads the current data in, removes the selected meal from it, and saves it.
  * @param newMeal The Meals object to be removed.
  * @param file The name of the file that the row should be deleted from.
  */
  public static void deleteRow(Meals mealToRemove, String file){

  ArrayList<Meals> currentData = load(file);
  Iterator dataIterator = currentData.iterator();
  Meals currentMeal;

  while(dataIterator.hasNext()){
    currentMeal = (Meals) dataIterator.next();
    if(currentMeal.getKey() == mealToRemove.getKey()){
        dataIterator.remove();
    }
  }

  saveFile(file, currentData);
  }

  /**
  * Creates a new version of a designated file with updated data.
  * @param updatedData
  * @param file The name of the file the data should be saved to.
  */
  public static void saveFile(String file, ArrayList<Meals> updatedData) {

  try (PrintWriter writer = new PrintWriter(new File("./src/main/resources/raw/"+file))) {

  StringBuilder sb = new StringBuilder();

  sb.append("Key,Type,Name,Calories,Carbs,Protein,Fat,Saturates,Sugar,Fibre,Salt,B1,B2,B3,B6,B9,B12,D,Iron,\n");

  for(Meals meal : updatedData){
  sb.append(""+meal.getKey()+","+meal.getType()+","+meal.getName()+","+meal.getCalories()+","+meal.getCarbs()+","+meal.getProtein()+","+meal.getFat()+","+meal.getSaturates()+","+meal.getSugar()+","+meal.getFibre()+",");
  sb.append(""+meal.getSalt()+","+meal.getB1()+","+meal.getB2()+","+meal.getB3()+","+meal.getB6()+","+meal.getB9()+","+meal.getB12()+","+meal.getD()+","+meal.getIron()+"\n");
  }

  writer.write(sb.toString());

  }

  catch (FileNotFoundException e) {
  }

  }


  /**
  * Used in the event that a fresh file needs to be generated.
  * @param file The file that is to be regenerated.
  */
  public static void generateDefaultFile(String file){
  saveFile(file,new ArrayList<Meals>());
  }

  /**
  * @param doubleString The string to be converted to Double type.
  * @return the Double value of the string.
  */
  private static Double convertDouble(String doubleString){
    return Double.parseDouble(doubleString);
  }

  /**
  * @param intString The string to be converted to Integer type.
  * @return the Integer value of the string.
  */
  private static Integer convertInt(String intString){
    return Integer.parseInt(intString);
  }

  /**
  * Fetches data from a respective category to be displayed in a table.
  * @param type The food type to be fetched.
  * @return An ObservableList of "Meals" to be displayed in a TableView.
  */
  public static ObservableList<Meals> GenerateData(String type,  boolean full, String file) {

  ArrayList<Meals> ArrayOfMeals = splitList(type, file);

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


  /**
  * Splits the content of a file up into a respective category, and returns only the meals in that categoy.
  * @param type The category of meal to be loaded, such as "Breakfast".
  * @param file The file to split.
  * @return An arrayList of only meals in the chosen category.
  */
  private static ArrayList<Meals> splitList(String type, String file) {
  ArrayList<Meals> meals = (ArrayList<Meals>)MealLoader.load(file);
  ArrayList<Meals> splitList = new ArrayList<Meals>();
  for (Meals meal : meals) {
    if (meal.getType().equals(type)) {
        splitList.add(meal);
    }
  }
  return splitList;
  }

  }
