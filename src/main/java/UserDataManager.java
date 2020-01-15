import java.util.*;
import java.io.*;
/**
 * Contains methods to load in and write to text files.
 * Enables the application to save user use of the applicaiton.
 *
 * @author Luke
 * @version V1
 */
public abstract class UserDataManager
{
    // Initially loads in the user's borough use and search uses.
    private static HashMap userStats = UserDataManager.loadUserStats();
    private static int userActions = 0;
    
    /**
     * Loads user stats from a specified file.
     * @param The name of a text file that is to be loaded from.
     */
    public static HashMap loadUserStats(){

        String current = "";
        HashMap userUseage = new HashMap();
        boolean first = true;
        System.out.println("Attempting to load");
        
        try(Scanner reader = new Scanner(new File("userStats.txt"))){ // It scans the file, and if it has something next, then collects the string and adds it to current.
         while (reader.hasNext()) {
         if(first){
             current += reader.next();  
            }
            else{
               current += " "+reader.next(); 
            }
         
         first = false;   
            
         if (reader.hasNextInt()) { // If the next item is an int, then it puts current and the next int into a hashmap. The current stored the whole name of what the number was associated with.
            userUseage.put(current,reader.nextInt());
            current = "";
            first = true;
         }

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
    public static HashMap getUserStats(){
        return userStats;
    }
    
    /**
     * Attempts to write stats to a file.
     */
    public static void writeUserStats(){
        
        Object nextPair = 0;
        
        // Creates an iterator of the hashmap depending on the file the user wants to write to.
        Iterator keyIterator = userStats.keySet().iterator(); 
        Iterator valueIterator = userStats.values().iterator();
    
        keyIterator = userStats.keySet().iterator();
        valueIterator = userStats.values().iterator();
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("userStats.txt"))){
                
            writer.write(""); // Cleans the file.
            
            while (keyIterator.hasNext() && valueIterator.hasNext()){ // While the iterators have items in them, write to the file the items currently selected in the iterators.
            writer.write(""+keyIterator.next()+" "+valueIterator.next()+" ");
            writer.newLine();
        }
        }
    
        catch(Exception exception){
            generateFreshStats(); // If an error occurs, then generate a fresh set of stats of the target file.
        }
        
        finally{
        }
        
    }  
    
    /**
     * Prints the content of the filename designated. To be used for testing purposes.
     */
    public static void printUserStats(){
        System.out.println(getUserStats());
    }
 
    /**
     * Triggers the generation of fresh statistics if there is a problem with the file.
     */
    public static void generateFreshStats(){
        
        System.out.println("Generating fresh stats");
        
        File newFile = new File("userStats.txt"); 
        
        HashMap userStats = freshStats(); // Try to generate fresh stats.
        
        Object nextPair = 0;
        Iterator keyIterator = userStats.keySet().iterator(); 
        Iterator valueIterator = userStats.values().iterator();
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("userStats.txt"))){ // We try to create a new writer with the designated file.
                
            writer.write("");
            
            while (keyIterator.hasNext() && valueIterator.hasNext()){ // We iterate through the stats that were generated and write them to the file.
            writer.write(""+keyIterator.next()+" "+valueIterator.next()+" ");
            writer.newLine();
        }
        }
    
        catch(Exception exception){ // If it can't, it will have avoided all the prior safe guards, so an error will be printed.
            System.err.println("Something unexpected happened when writing to the data file!");
            System.err.println(exception);
        }
        
    }
    
    /**
     * Increments the use of a specific attribute.
     */
    public static void changeValue(String attribute, int value){
        
        userStats.put(attribute, value); // Increments the number of uses for the attribute by one.
        
    }
    
    /**
     * Contains the values for fresh statistics of certain files.
     * @returns Returns a HashMap of new stat pairs.
     */
    public static HashMap freshStats(){
        
        HashMap defaultStats = new HashMap();
        
        defaultStats.put("Weight",0);
        defaultStats.put("Height",0);
        defaultStats.put("Age",0);
        defaultStats.put("Sex",0);
        defaultStats.put("Calories",0);
        
        return defaultStats;
    }
     
    /**
     * @return Returs the key set of the target file.
     */
    private static Set getFreshStatsKeySet(){ 
        return(freshStats().keySet());
    }

}     