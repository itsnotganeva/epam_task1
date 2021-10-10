package com.epam.entity;

public class Biscuits extends Sweets{
    private String typeOfDough;

    public Biscuits() {

    }

    public Biscuits(String category, String name, double weight, int sugarContent, String flavor, int calorieContent, String typeOfDough) {
        super(category, name, weight, sugarContent, flavor, calorieContent);
        this.typeOfDough = typeOfDough;
    }

    public String getTypeOfDough() {
        return typeOfDough;
    }

    public void setTypeOfDough(String typeOfDough) {
        this.typeOfDough = typeOfDough;
    }

    @Override
    public String toString() {
        return "\nBiscuit: \nname: " + getName() + "\n" + "weight: " + getWeight() + "\n" +
                "sugar content: " + getSugarContent() + "\n" + "flavor: " + getFlavor() + "\n" +
                "calorie content: " + getCalorieContent() + "\n" + "type of dough: " + getTypeOfDough() + "\n";
    }
}