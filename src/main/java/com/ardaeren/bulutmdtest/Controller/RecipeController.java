package com.ardaeren.bulutmdtest.Controller;

import com.ardaeren.bulutmdtest.Domain.Recipe;
import com.ardaeren.bulutmdtest.Service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> showAllRecipes() {
        List<Recipe> recipes = recipeService.showAllRecipes();
        return ResponseEntity.ok(recipes);
    }
}