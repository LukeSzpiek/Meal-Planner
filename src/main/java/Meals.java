package src.main.java;

/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Meals {

    private int key;

    private String type;
    private String name;

    private double calories;
    private double carbs;

    private double protein;
    private double fat;
    private double saturates;
    private double sugar;
    private double fibre;
    private double salt;

    private double b1;
    private double b2;
    private double b3;
    private double b6;
    private double b9;
    private double b12;

    private double d;
    private double iron;

    public Meals(int key, String type, String name, double calories, double carbs, double protein, double fat, double saturates, double sugar, double fibre, double salt, double b1, double b2, double b3, double b6, double b9, double b12, double d, double iron) {
        this.key = key;
        this.type = type;
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.saturates = saturates;
        this.sugar = sugar;
        this.fibre = fibre;
        this.salt = salt;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b6 = b6;
        this.b9 = b9;
        this.b12 = b12;
        this.d = d;
        this.iron = iron;


    }

    public int getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getSaturates() {
        return saturates;
    }

    public double getSugar() {
        return sugar;
    }

    public double getFibre() {
        return fibre;
    }

    public double getSalt() {
        return salt;
    }

    public double getB1() {
        return b1;
    }

    public double getB2() {
        return b2;
    }

    public double getB3() {
        return b3;
    }

    public double getB6() {
        return b6;
    }

    public double getB9() {
        return b9;
    }

    public double getB12() {
        return b12;
    }

    public double getD() {
        return d;
    }

    public double getIron() {
        return iron;
    }

    @Override
    public String toString() {
        return "AirbnbListing{" +
                "id='" + name + '\'' +
                ", name='" + calories + '\'' +
                ", host_id='" + carbs + '\'' +
                ", host_name='" + protein + '\'' +
                ", neighbourhood='" + saturates + '\'' +
                ", latitude=" + sugar +
                ", longitude=" + fibre +
                ", room_type='" + salt + '\'' +
                ", price=" + b1 +
                ", minimumNights=" + b2 +
                ", numberOfReviews=" + b3 +
                ", lastReview='" + b6 + '\'' +
                ", reviewsPerMonth=" + b9 +
                ", calculatedHostListingsCount=" + b12 +
                ", availability365=" + d +
                ", iron=" + iron +
                '}';
    }
}
