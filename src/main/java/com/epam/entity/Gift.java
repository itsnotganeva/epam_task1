package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Gift {

    private List<Sweets> sweetsList = new ArrayList<>();

    public List<Sweets> getSweetsList() {
        return sweetsList;
    }

    public void setSweetsList(List<Sweets> sweetsList) {
        this.sweetsList = sweetsList;
    }

    public Gift() {

    }

    public Gift(List<Sweets> sweets) {
        this.sweetsList = sweets;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "sweetsList=" + sweetsList +
                '}';
    }
}