package com.ardaeren.bulutmdtest.Service;

import com.ardaeren.bulutmdtest.Domain.Recipe;
import com.ardaeren.bulutmdtest.Repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepo receipeRepo;

    public Recipe createRecipe(Recipe recipe) {
        return receipeRepo.save(recipe);
    }

    public List<Recipe> showAllRecipes() {
        return receipeRepo.findAll();
    }
}
