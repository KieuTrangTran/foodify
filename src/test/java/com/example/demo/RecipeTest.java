package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {
    @Test
    void testToString() {
        //Eingabedaten
        String name = "Chicken Teriyaki";
        int calories = 5000;
        double prepTime = 30;
        double cookTime = 10;

        //"System under test" aufsetzen
        Recipe recipe = new Recipe(name, calories, prepTime, cookTime);
        recipe.setId(1L);

        //Erwartetes Ergebnis
        String expected = "Recipe{id=1, name='Chicken Teriyaki', calories=5000, prepTime=30.0, cookTime=10.0}";

        //Tatsächliches Ergebnis
        String actual = recipe.toString();

        //Vergleich
        assertEquals(expected, actual);
    }

}
