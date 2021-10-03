package com.epam;

import com.epam.dao.PresentDao;
import com.epam.entity.Biscuits;
import com.epam.entity.Candies;
import com.epam.entity.Present;
import com.epam.entity.Sweets;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        PresentDao presentDao = new PresentDao();
        //Present present = presentDao.readPresent();

//        Candies candies1 = new Candies("Ferrero Rocher", 120, 40, "Nut", 580, "Chocolate");
//        Candies candies2 = new Candies("Raffaello", 150, 65, "Coconut", 675, "Coconut");
//        Biscuits biscuits1 = new Biscuits("Oreo", 200, 35, "Vanilla", 900, "Butter");
//        Biscuits biscuits2 = new Biscuits("Wagon Wheels", 220, 62, "Chocolate", 920, "Biscuit");
//
//        Present present = new Present();
//
//        ArrayList<Sweets> sw = new ArrayList<>();
//
//        sw.add(candies1);
//        sw.add(candies2);
//        sw.add(biscuits1);
//        sw.add(biscuits2);
//
//        present.setSweetsList(sw);
//
//        presentDao.writePresent(present);

    }
}
