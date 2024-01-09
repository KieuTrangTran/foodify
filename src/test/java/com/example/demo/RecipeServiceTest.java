package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    private RecipeService service;

    @MockBean
    private RecipeRepository repository;

    @Test
    @DisplayName("should find a recipe by its id")
    void testGet() {
        var t1 = new Recipe("Chicken Teriyaki", 5000, 30, 10);
        var t2 = new Recipe("Pho", 100, 60, 300);
        doReturn(Optional.of(t1)).when(repository).findById(1L);
        doReturn(Optional.of(t2)).when(repository).findById(35L);

        Recipe actual = service.get(1L);

        assertEquals(actual.getCalories(), 5000);
    }

    @Test
    @DisplayName("should delete a recipe by its id")
    void testDelete() {
        Long recipeId = 35L;

        // Stellen Sie sicher, dass das Löschen keine Ausnahme wirft
        assertDoesNotThrow(() -> service.delete(recipeId));

        // Verifizieren, dass die deleteById Methode des Repositorys aufgerufen wurde
        verify(repository).deleteById(recipeId);
    }

    @Test
    @DisplayName("should update a recipe")
    void testUpdate() {
        Long recipeId = 1L;
        Recipe existingRecipe = new Recipe("Spaghetti", 300, 20, 40);
        existingRecipe.setId(recipeId);

        Recipe updatedRecipe = new Recipe("Spaghetti Bolognese", 350, 25, 45);
        updatedRecipe.setId(recipeId);

        // Mocking des Findens des existierenden Rezepts
        doReturn(Optional.of(existingRecipe)).when(repository).findById(recipeId);

        // Mocking des Speicherns des aktualisierten Rezepts
        doReturn(updatedRecipe).when(repository).save(any(Recipe.class));

        // Update Methode aufrufen
        Recipe result = service.update(recipeId, updatedRecipe);

        // Prüfen, ob die Eigenschaften des Rezepts korrekt aktualisiert wurden
        assertEquals(updatedRecipe.getName(), result.getName());
        assertEquals(updatedRecipe.getCalories(), result.getCalories());
        assertEquals(updatedRecipe.getPrepTime(), result.getPrepTime());
        assertEquals(updatedRecipe.getCookTime(), result.getCookTime());
    }


}
