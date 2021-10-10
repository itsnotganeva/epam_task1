package com.epam;

import com.epam.dao.GiftDao;
import com.epam.entity.Biscuits;
import com.epam.entity.Candies;
import com.epam.entity.Gift;
import com.epam.entity.Sweets;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        GiftDao giftDao = new GiftDao();
        Gift gift = giftDao.readGift();
        Scanner in = new Scanner(System.in);
        int num = 0;
        String input = "";

        do {
            System.out.println("\nShow all sweets of gift - 1");
            System.out.println("Determine the weight of the gift - 2");
            System.out.println("Show sweets by calorie content - 3");
            System.out.println("Find sweets by range of sugar content - 4");
            System.out.println("Add new sweets to gift - 5");
            System.out.println("Exit - 6");
            input = in.next();
            try {
                num = Integer.parseInt(input);
            } catch (Exception ex) {
                System.out.println("Wrong input! Please try again!");
            }

            switch (num) {
                case 1:
                    giftDao.getSweets(gift);
                    break;
                case 2:
                    giftDao.getWeightOfGift(gift);
                    break;
                case 3:
                    giftDao.sortSweetsByCalorie(gift);
                    break;
                case 4:
                    System.out.println("Enter the minimum of sugar content: ");
                    int min = in.nextInt();
                    System.out.println("Enter the maximum of sugar content: ");
                    int max = in.nextInt();
                    giftDao.getSweetsBySugarContent(min, max, gift);
                    break;
                case 5:
                    System.out.println("Choose the category of sweets you want to add: \n" +
                            "Candy - 1 \nBiscuit - 2");
                    int category = in.nextInt();
                    System.out.println("Enter the name of sweetness: ");
                    in.nextLine();
                    String name = in.nextLine();
                    System.out.println("Enter the weight of sweetness: ");
                    double weight = in.nextDouble();
                    System.out.println("Enter the sugar content of sweetness: ");
                    int sugarContent = in.nextInt();
                    System.out.println("Enter the flavor of sweetness: ");
                    in.nextLine();
                    String flavor = in.nextLine();
                    System.out.println("Enter the calorie content of sweetness: ");
                    int calorieContent = in.nextInt();

                    if (category == 1) {
                        System.out.println("Enter the type of candy mass: ");
                        in.nextLine();
                        String candyMass = in.nextLine();
                        Sweets candy = new Candies("candy", name, weight, sugarContent, flavor, calorieContent, candyMass);
                        gift.getSweetsList().add(candy);
                    }
                    else if (category == 2) {
                        System.out.println("Enter the type of dough: ");
                        in.nextLine();
                        String doughType = in.nextLine();
                        Sweets biscuit = new Biscuits("biscuit", name, weight, sugarContent, flavor, calorieContent, doughType);
                        gift.getSweetsList().add(biscuit);
                        giftDao.writeGift(gift);
                    }
                    giftDao.writeGift(gift);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Wrong input! Please try again!");
                    break;
            }

        } while (!input.equals("6"));

    }
}
