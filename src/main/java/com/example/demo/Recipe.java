package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int calories;
    private double prepTime;
    private double cookTime;

    public Recipe() {
    }

    public Recipe(String name, int calories, double prepTime, double cookTime) {
        this.name = name;
        this.calories = calories;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return calories == recipe.calories && Double.compare(recipe.prepTime, prepTime) == 0 && Double.compare(recipe.cookTime, cookTime) == 0 && Objects.equals(id, recipe.id) && Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, prepTime, cookTime);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(double prepTime) {
        this.prepTime = prepTime;
    }

    public double getCookTime() {
        return cookTime;
    }

    public void setCookTime(double cookTime) {
        this.cookTime = cookTime;
    }



}
