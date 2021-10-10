package com.epam.entity;

public class Candies extends Sweets{
    private String candyMass;

    public Candies() {
    }

    public Candies(String category, String name, double weight, int sugarContent, String flavor, int calorieContent, String candyMass) {
        super(category, name, weight, sugarContent, flavor, calorieContent);
        this.candyMass = candyMass;
    }

    public String getCandyMass() {
        return candyMass;
    }

    public void setCandyMass(String candyMass) {
        this.candyMass = candyMass;
    }

    @Override
    public String toString() {
        return "\nCandy: \nname: " + getName() + "\n" + "weight: " + getWeight() + "\n" +
                "sugar content: " + getSugarContent() + "\n" + "flavor: " + getFlavor() + "\n" +
                "calorie content: " + getCalorieContent() + "\n" + "candy mass: " + getCandyMass() + "\n";
    }
}
