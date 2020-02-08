package src.main.java;

import java.util.*;

/**
 * Model class for the user's nutritional statistics which saves their details, and can return them.
 *
 * @author Luke.s
 * @version V2
 */
public class Statistics
{

    private double shouldEatCarbs;
    private double shouldEatProtein;
    private double shouldEatFat;
    private double maximumSugar;

    private double calories;

    public Statistics(){

      HashMap hm = UserDataManager.getUserStats();
      Object[] sh = hm.values().toArray();

      double weight = (int)sh[2];
      this.calories = (int)sh[4];

      shouldEatCarbs = (0.50*calories)/4;
      shouldEatProtein = (0.75*weight);
      shouldEatFat = ((0.275*calories)/9);
      maximumSugar = ((calories*0.1)/4);

    }

    public String getStatisticsText(){

      return ("YOUR TOTAL CONSUMPTION:"+
      "\n"+"Calories: "+PlateHandler.getTotalCalories()+
      "\n"+"Carbs: "+PlateHandler.getTotalCarbs()+
      "\n"+"Protein: "+PlateHandler.getTotalProtein()+
      "\n"+"Fat: "+PlateHandler.getTotalFats()+
      "\n"+"Saturates: "+PlateHandler.getTotalSaturates()+
      "\n"+"Sugar: "+PlateHandler.getTotalSugar()+
      "\n"+"\n"+
      "YOU SHOULD BE CONSUMING: "+
      "\n"+"Calories: "+calories+" ("+Math.round((PlateHandler.getTotalCalories()/calories)*100)+"%"+")"+
      "\n"+"Carbs: "+(shouldEatCarbs)+" ("+Math.round((PlateHandler.getTotalCarbs()/shouldEatCarbs)*100)+"%"+")"+
      "\n"+"Protein: "+(shouldEatProtein)+" ("+Math.round((PlateHandler.getTotalProtein()/shouldEatProtein)*100)+"%"+")"+
      "\n"+"Fat: "+(shouldEatFat)+" ("+Math.round((PlateHandler.getTotalFats()/shouldEatFat)*100)+"%"+")"+
      "\n"+"Sugar: "+(maximumSugar));

    }

}
