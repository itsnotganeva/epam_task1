package com.epam.dao;

import com.epam.entity.Gift;
import com.epam.entity.Sweets;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GiftDao implements IGiftDao {

    private final String FILE_PATH = "D:\\JavaProjects\\EPAM\\epam_task1\\gift.json";

    private static final Logger LOGGER = LoggerFactory.getLogger(GiftDao.class);


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
        
        try
        {
            // convert JSON array to list
            sweetsList = mapper.readValue(Paths.get(FILE_PATH).toFile(), new TypeReference<ArrayList<Sweets>>() {});
            gift.setSweetsList(sweetsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("The sweets of gift: {}", gift.getSweetsList());
        return gift;
    }

    @Override
    public double getWeightOfGift(Gift gift) {
        double weight = 0;
        for (Sweets sweets : gift.getSweetsList()) {
            weight+=sweets.getWeight();
        }
        LOGGER.info("The weigth of gift is {}", weight);
        return weight;
    }

    @Override
    public List<Sweets> sortSweetsByCalorie(Gift gift) {
        Collections.sort(gift.getSweetsList(), ((o1, o2) -> o1.getCalorieContent() - o2.getCalorieContent()));
        LOGGER.info("The sorted list of sweets in gift: {}",gift.getSweetsList());
        return gift.getSweetsList();
    }

    @Override
    public List<Sweets> getSweetsBySugarContent(int startPosition, int finalPosition, Gift gift) {
        List<Sweets> foundSweets = new ArrayList<>();
        for (Sweets sweets : gift.getSweetsList()) {
            if (sweets.getSugarContent() >= startPosition && sweets.getSugarContent() <= finalPosition) {
                foundSweets.add(sweets);
                LOGGER.debug("Sweet with sugar content ({}) getOperation", sweets.getSugarContent());
                LOGGER.info("Sweet with sugar content ({}): {}", sweets.getSugarContent(), sweets);
            }
        }
        if (foundSweets.size() == 0) {
            LOGGER.warn("Sweets with sugar content range ({} - {}) not found", startPosition, finalPosition);
        }
        return foundSweets;
    }
}
