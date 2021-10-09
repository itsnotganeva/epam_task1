package com.epam.dao;

import com.epam.entity.Gift;
import com.epam.entity.Sweets;

import java.util.List;

public interface IGiftDao {
    Gift present = new Gift();

    void writeGift(Gift present);
    Gift readGift();
    double getWeightOfGift(Gift gift);
    List<Sweets> sortSweetsByCalorie(Gift gift);
    List<Sweets> getSweetsBySugarContent(int startPosition, int finalPosition, Gift gift);
}
