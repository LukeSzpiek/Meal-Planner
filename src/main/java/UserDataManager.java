package src.main.java;

import java.util.*;
import java.io.*;
import com.opencsv.CSVReader;
import java.net.URL;

/**
 * Contains methods to load in and write to text files.
 * Enables the application to save user use of the applicaiton.
 *
 * @author Luke
 * @version V2
 */
public abstract class UserDataManager
{

  // Loads user stats from the CSV file.
  private static HashMap<String,Integer> userStats = UserDataManager.loadUserStats();
  private static int userActions = 0;

  /**
  * Loads user stats from 'userStats.csv'.
  * @return Hashmap in the form (Statistic Type, Value)
  */
  public static HashMap<String,Integer> loadUserStats(){

    String current = "";
    HashMap<String,Integer> userUseage = new HashMap<>();
    boolean first = true;

    URL url = MealLoader.class.getResource("/raw/userStats.csv");

    try{
    CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));

    String [] line;

    reader.readNext();
    while ((line = reader.readNext()) != null) {
        userUseage.put("Sex", Integer.parseInt(line[0]));
        userUseage.put("Height", Integer.parseInt(line[1]));
        userUseage.put("Weight", Integer.parseInt(line[2]));
        userUseage.put("Age", Integer.parseInt(line[3]));
        userUseage.put("Calories", Integer.parseInt(line[4]));
      }
    }

    catch(Exception e){ // If there is an error, then it generates fresh stats of the target file and loads them in again.
        generateFreshStats();
        loadUserStats();
    }

    finally{
        if(!(userUseage.keySet().equals(getFreshStatsKeySet()))){ // If it loads in a file and it does not have the same keyset that the file is expecting, then it generates fresh stats.
            generateFreshStats();
            return getUserStats();
        }
        return userUseage;
    }

  }

  /**
  * @return Returns a hash map of the stats that the programmer requests.
  */
  public static HashMap<String,Integer> getUserStats(){
    return userStats;
  }

  /**
  * Attempts to write the user's current stats to a file. They may be different to the ones that are currently saved.
  */
  public static void writeUserStats(){

    Object nextPair = 0;

    // Creates an iterator of the hashmap depending on the file the user wants to write to.
    Iterator keyIterator = userStats.keySet().iterator();
    Iterator valueIterator = userStats.values().iterator();

    keyIterator = userStats.keySet().iterator();
    valueIterator = userStats.values().iterator();

    try(BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/raw/userStats.csv"))){

        writer.write(""); // Cleans the file.
        writer.write("Sex,Height,Weight,Age,Calories\n");
        while (keyIterator.hasNext() && valueIterator.hasNext()){ // While the iterators have items in them, write to the file the items currently selected in the iterators.
        writer.write(""+valueIterator.next()+",");
    }

    }

    catch(Exception exception){
        generateFreshStats(); // If an error occurs, then generate a fresh set of stats of the target file.
    }
  }

  /**
  * Triggers the generation of fresh user statistics if there is a problem with the file.
  */
  public static void generateFreshStats(){
    File newFile = new File("userStats.txt");

    HashMap<String,Integer> userStats = freshStats(); // Try to generate fresh stats.

    Object nextPair = 0;
    Iterator keyIterator = userStats.keySet().iterator();
    Iterator valueIterator = userStats.values().iterator();

    try(BufferedWriter writer = new BufferedWriter(new FileWriter("userStats.csv"))){ // We try to create a new writer with the designated file.

        writer.write("");

        while (keyIterator.hasNext() && valueIterator.hasNext()){ // We iterate through the stats that were generated and write them to the file.
        writer.write(""+keyIterator.next()+" "+valueIterator.next()+" ");
        writer.newLine();
    }
    }

    catch(Exception exception){}

  }

  /**
  * Increments the use of a specific attribute.
  */
  public static void changeValue(String attribute, int value){
    userStats.put(attribute, value); // Increments the number of uses for the attribute by one.
  }

  /**
  * Contains the values for fresh statistics of certain files.
  * @return HashMap of newly generated, default statistic pairs.
  */
  public static HashMap<String,Integer> freshStats(){

    HashMap<String,Integer> defaultStats = new HashMap<>();

    defaultStats.put("Weight",0);
    defaultStats.put("Height",0);
    defaultStats.put("Age",0);
    defaultStats.put("Sex",0);
    defaultStats.put("Calories",0);

    return defaultStats;
  }

  /**
  * @return The key set of the target file.
  */
  private static Set getFreshStatsKeySet(){
    return(freshStats().keySet());
  }

  /**
  * Prints the content of the filename designated. To be used for testing purposes.
  */
  public static void printUserStats(){
    System.out.println(getUserStats());
  }

}
