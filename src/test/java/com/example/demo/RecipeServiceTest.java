package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

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
}
