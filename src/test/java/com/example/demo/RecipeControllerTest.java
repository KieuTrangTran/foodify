package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService service;

    @Test
    public void testGetRoute() throws Exception {
        //Test Daten und Service Mock
        Recipe t2 = new Recipe("Pho", 100, 60, 300);
        t2.setId(35L);
        when(service.get(35L)).thenReturn(t2);

        //Erwartetes Ergebnis
        String expected = "{\"id\":35,\"name\":\"Pho\",\"calories\":100,\"prepTime\":60.0,\"cookTime\":300.0}";

        //Aufruf und Vergleich
        this.mockMvc.perform(get("/recipes/35"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testCreateRecipe() throws Exception {
        // Testdaten vorbereiten
        Recipe newRecipe = new Recipe("Lasagne", 250, 30, 30);
        when(service.save(any(Recipe.class))).thenReturn(newRecipe);

        // Konvertiere das Objekt in einen JSON String
        ObjectMapper objectMapper = new ObjectMapper();
        String newRecipeJson = objectMapper.writeValueAsString(newRecipe);

        // Aufruf und Vergleich
        this.mockMvc.perform(post("/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newRecipeJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(newRecipeJson));
    }

}
