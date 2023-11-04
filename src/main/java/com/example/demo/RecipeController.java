package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService service;

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @PostMapping("/recipes")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable String id) {
        logger.info("GET request on route recipes with {}", id);
        Long recipeId = Long.parseLong(id);
        return service.get(recipeId);
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(@RequestParam(required = false) Integer country) {
        if(country != null) {
            return service.findByCountry(country);
        }

        return service.getAll();
    }
    
}