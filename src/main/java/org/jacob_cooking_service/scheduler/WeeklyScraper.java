package org.jacob_cooking_service.scheduler;

import org.jacob_cooking_service.service.DishesService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import org.jacob_cooking_service.entity.Dishes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;



@Component
public class WeeklyScraper {


    @Autowired
    private DishesService dishesService;

    @Scheduled(cron = "0 0 13 * * WED")
    public void scrape() {
        String url = "https://www.hellofresh.co.uk/menus";
        Dishes dishes = new Dishes();

        try {
            // Fetch the HTML content of the page
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                    .get();

            // Select all recipe-card components
            Elements recipeCards = doc.select("div[data-test-id=recipe-card-component].web-26xi0f");
            String dishName;
            String cookingTime;
            for (Element recipeCard : recipeCards) {


                if (recipeCard.selectFirst(".web-1urjace") != null) {
                    dishName = recipeCard.selectFirst(".web-1urjace").text();

                }
                else {
                    dishName = recipeCard.selectFirst(".web-l7ncql").text();

                }

                cookingTime = recipeCard.selectFirst(".web-1u07yy9").text();

                dishes.setDishTime(cookingTime);
                dishes.setDish_name(dishName);
                dishes.setImgURL(imgUrl);
                dishesService.saveDishes(dishes);


                // Print the extracted information
                System.out.println("Dish: " + dishName);
                System.out.println("Cooking Time: " + cookingTime);
                System.out.println("---------------");
            }
        } catch (IOException e) {
            System.err.println("Error fetching or parsing the page: " + e.getMessage());
        }

    }



}