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
