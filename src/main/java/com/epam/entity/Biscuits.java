package com.epam.entity;

public class Biscuits extends Sweets{
    private String typeOfDough;

    public String getTypeOfDough() {
        return typeOfDough;
    }

    public void setTypeOfDough(String typeOfDough) {
        this.typeOfDough = typeOfDough;
    }

    public Biscuits() {

    }

    public Biscuits(String name, double weight, int sugarContent, String flavor, int calorieContent, String typeOfDough) {
        super(name, weight, sugarContent, flavor, calorieContent);
        this.typeOfDough = typeOfDough;
    }

    @Override
    public String toString() {
        return "\nBiscuits: \nname: " + getName() + "\n" + "weight: " + getWeight() + "\n" +
                "sugar content: " + getSugarContent() + "\n" + "flavor: " + getFlavor() + "\n" +
                "calorie content: " + getCalorieContent() + "\n" + "type of dough: " + getTypeOfDough() + "\n";
    }
}