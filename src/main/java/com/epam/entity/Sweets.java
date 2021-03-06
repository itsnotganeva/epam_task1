package com.epam.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "category",
        visible = true
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = Candies.class, name = "candy"),
        @JsonSubTypes.Type(value = Biscuits.class, name = "biscuit")
}
)

public abstract class Sweets {
    private String category;
    private String name;
    private double weight;
    private int sugarContent;
    private String flavor;
    private int calorieContent;

    public Sweets() {

    }

    public Sweets(String category, String name, double weight, int sugarContent, String flavor, int calorieContent) {
        this.category = category;
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.flavor = flavor;
        this.calorieContent = calorieContent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getCalorieContent() {
        return calorieContent;
    }

    public void setCalorieContent(int calorieContent) {
        this.calorieContent = calorieContent;
    }

}
