package com.ardaeren.bulutmdtest.Repository;

import com.ardaeren.bulutmdtest.Domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    Recipe findByName(String name);
}
