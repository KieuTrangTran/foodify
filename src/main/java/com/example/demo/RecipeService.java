package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository repo;

    public Recipe save(Recipe recipe) {
        return repo.save(recipe);
    }


    public Recipe get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Recipe> getAll() {
        Iterable<Recipe> iterator = repo.findAll();
        List<Recipe> recipes = new ArrayList<Recipe>();
        for (Recipe recipe : iterator) recipes.add(recipe);
        return recipes;
    }

    public Recipe update(Long id, Recipe newRecipeData) {
        // Find the existing recipe by id
        Recipe existingRecipe = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        // Update the fields of the existing recipe with newRecipeData
        existingRecipe.setName(newRecipeData.getName());
        existingRecipe.setCalories(newRecipeData.getCalories());
        existingRecipe.setCookTime(newRecipeData.getCookTime());
        existingRecipe.setPrepTime(newRecipeData.getPrepTime());
        // ... Update other fields as needed

        // Save the updated recipe back to the database
        return repo.save(existingRecipe);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
