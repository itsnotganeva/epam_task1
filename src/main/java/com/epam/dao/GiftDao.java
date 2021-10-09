package com.epam.dao;

import com.epam.entity.Gift;
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

public class GiftDaoImpl implements GiftDao {

    private final String FILE_PATH = "D:\\JavaProjects\\EPAM\\epam_task1\\presents.json";

    @Override
    public void writeGift(Gift gift) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try
        {
            writer.writeValue(Paths.get(FILE_PATH).toFile(), gift.getSweetsList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Gift readGift() {

        Gift gift = new Gift();
        List<Sweets> sweetsList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try
        {
            // convert JSON array to list
            sweetsList = mapper.readValue(Paths.get(FILE_PATH).toFile(), new TypeReference<ArrayList<Sweets>>() {});
            gift.setSweetsList(sweetsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gift;
    }

    public double getWeightOfGift(Gift gift) {
        double weight = 0;
        for (Sweets sweets : gift.getSweetsList()) {
            weight+=sweets.getWeight();
        }
        return weight;
    }

    public List<Sweets> sortSweetsByCalorie(Gift gift) {
        Collections.sort(gift.getSweetsList(), ((o1, o2) -> o1.getCalorieContent() - o2.getCalorieContent()));
        return gift.getSweetsList();
    }

    public List<Sweets> findSweetsBySugarContent(int startPosition, int finalPosition, Gift gift) {
        List<Sweets> foundSweets = new ArrayList<>();
        for (Sweets sweets : gift.getSweetsList()) {
            if (sweets.getSugarContent() >= startPosition && sweets.getSugarContent() <= finalPosition) {
                foundSweets.add(sweets);
            }
        }
        return foundSweets;
    }
}
