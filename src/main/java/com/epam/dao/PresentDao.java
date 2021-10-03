package com.epam.dao;

import com.epam.entity.Present;
import com.epam.entity.Sweets;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PresentDao implements IPresentDao{

    @Override
    public void writePresent(Present present) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try
        {
            writer.writeValue(Paths.get("presents.json").toFile(), present.getSweetsList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Present readPresent() {

        Present present = new Present();
        List<Sweets> sweetsList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try
        {
            // convert JSON array to list
            sweetsList = mapper.readValue(Paths.get("presents.json").toFile(), new TypeReference<ArrayList<Sweets>>() {});
            present.setSweetsList(sweetsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return present;
    }

    public double getWeightOfPresent(Present present) {
        double weight = 0;
        for (Sweets sweets : present.getSweetsList()) {
            weight+=sweets.getWeight();
        }
        return weight;
    }

    public List<Sweets> sortSweets(Present present) {
        Collections.sort(present.getSweetsList(), ((o1, o2) -> o1.getCalorieContent() - o2.getCalorieContent()));
        return present.getSweetsList();
    }

    public List<Sweets> findSweets(int startPosition, int finalPosition, Present present) {
        List<Sweets> foundSweets = new ArrayList<>();
        for (Sweets sweets : present.getSweetsList()) {
            if (sweets.getSugarContent() >= startPosition && sweets.getSugarContent() <= finalPosition) {
                foundSweets.add(sweets);
            }
        }
        return foundSweets;
    }
}
