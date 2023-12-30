package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

        return service.getAll();
    }

    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return service.update(id, recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
