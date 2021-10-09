package com.epam;

import com.epam.dao.GiftDao;
import com.epam.entity.Biscuits;
import com.epam.entity.Candies;
import com.epam.entity.Gift;
import com.epam.entity.Sweets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GiftDaoTest {

    GiftDao giftDao = new GiftDao();
    Gift gift = new Gift();
    private static ArrayList<Sweets> sw = new ArrayList<>();

    @BeforeAll
    public static void init() {
        Candies candies1 = new Candies("candy", "Ferrero Rocher", 120, 40, "Nut", 580, "Chocolate");
        Biscuits biscuits1 = new Biscuits("biscuit", "Oreo", 200, 35, "Vanilla", 900, "Butter");
        sw.add(candies1);
        sw.add(biscuits1);
    }

    @Test
    public void testSweetsBySugarContent() {
        //GIVEN
        gift.setSweetsList(sw);
        //WHEN
        List<Sweets> sweets = giftDao.getSweetsBySugarContent(20, 45, gift);
        //THEN
        Assertions.assertEquals(sw, sweets);
    }

    @Test
    public void testSweetsBySugarContentSecondScenario() {
        //GIVEN
        gift.setSweetsList(sw);
        //WHEN
        List<Sweets> sweets = giftDao.getSweetsBySugarContent(70, 105, gift);
        //THEN
        Assertions.assertNotEquals(sw, sweets);
    }

    @Test
    public void testWeightOfGift(){
        //GIVEN
        gift.setSweetsList(sw);
        double sourceWeight = 320;
        //WHEN
        double weight = giftDao.getWeightOfGift(gift);
        //THEN
        Assertions.assertEquals(sourceWeight, weight);
    }
}
