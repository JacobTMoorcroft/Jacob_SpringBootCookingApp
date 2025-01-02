package org.jacob_cooking_service.scheduledServices;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jacob_cooking_service.entity.Dishes;
import org.jacob_cooking_service.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.zip.GZIPInputStream;


@Component
public class WeeklyScraperGousto {

@Autowired
private DishesService dishesService;

    @Scheduled(cron = "0 14 10 * * THU")
    public void scrape() {
        try {

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String currentWeek =  currentDate.format(formatter);
            String apiUrl = "https://production-api.gousto.co.uk/menu/v2/menus?addAlternatives=true&delivery_date=" + currentWeek;


            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() == 200) {

                    InputStream inputStream = connection.getInputStream();

                    String encoding = connection.getContentEncoding();

                    if ("gzip".equalsIgnoreCase(encoding)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }

                    ObjectMapper objectMapper = new ObjectMapper();

                    JsonNode rootNode = objectMapper.readTree(inputStream);
                    JsonNode recipeOptions = rootNode.get("included");


                    for (JsonNode recipe : recipeOptions) {
                        System.out.println(recipe);

                        JsonNode recipeNode = recipe.get("type");

                        if (recipeNode != null && "recipe".equals(recipeNode.asText())){

                            System.out.println(recipe);

                            JsonNode recipeAttributesJson = recipe.get("attributes");
                            String dishName = recipeAttributesJson.get("name").asText();

                            JsonNode prepTimes = recipeAttributesJson.get("prep_times");
                            String dishTime = prepTimes.get("for5").asText();

                            JsonNode dishImageUrls = recipeAttributesJson.get("images");
                            JsonNode dishImageUrlsCrops = dishImageUrls.get(0).get("crops");
                            JsonNode largestImgUrl = null;
                            System.out.println(dishImageUrlsCrops);


                            int maxWidth = 0;

                            for (JsonNode crop : dishImageUrlsCrops) {
                                int width = crop.get("width").asInt();

                                if (width > maxWidth) {
                                    maxWidth = width;
                                    largestImgUrl = crop;
                                }
                            }
                            String dishImg = null;

                            if(largestImgUrl != null) {
                                dishImg = largestImgUrl.get("url").asText();
                            }


                            Dishes dish = new Dishes();
                            dish.setDish_name(dishName);
                            dish.setDishTime(dishTime);
                            dish.setImgURL(dishImg);

                            dishesService.saveDishes(dish);
                        }






                    }

            } else {
                System.err.println("Failed to save/fetch data. HTTP response code: " + connection.getResponseCode());
            }

        } catch (IOException e) {
            System.err.println("Error fetching JSON file " +  e.getMessage());
        }
    }
}

