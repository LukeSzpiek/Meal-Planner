package src.main.java;

import java.util.*;

/**
 * Model class for the user profile which saves their details, and can return them.
 *
 * @author Luke.s
 * @version V2
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

    /**
     * @return The saved sex of the user. 0 for male, and 1 for Female. Is not boolean as gives opportunity to expand to non-binary in the future.
     */
    public int getUserSex(){
      return sex;
    }

    /**
     * @return The saved height of the user in CM.
     */
    public int getUserHeight(){
      return height;
    }

    /**
     * @return The saved weight of the user in KG.
     */
    public int getUserWeight(){
      return weight;
    }

    /**
     * @return The saved age of the user in years.
     */
    public int getUserAge(){
      return age;
    }

    /**
     * @return Assuming complete idleness, the amount of calories the user must eat in one day to keep their body weight.
     */
    public int getUserCalories(){
      return calories;
    }

}
