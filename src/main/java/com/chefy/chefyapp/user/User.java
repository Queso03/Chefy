package com.chefy.chefyapp.user;

import com.chefy.chefyapp.ingredient.Ingredient;
import com.chefy.chefyapp.recipe.Recipe;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "creator")
    private Set<Recipe> createdRecipes = new HashSet<>();

    @ManyToMany
    private Set<Recipe> likedRecipes = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Recipe> getCreatedRecipes() {
        return createdRecipes;
    }

    public void createRecipe(String title, String category, String instructions, String imageUrl, Boolean isPublic, Set<Ingredient> ingredients) {
        Recipe newRecipe = new Recipe();
        newRecipe.setTitle(title);
        newRecipe.setCategory(category);
        newRecipe.setInstructions(instructions);
        newRecipe.setImageUrl(imageUrl);
        newRecipe.setPublic(isPublic);
        this.createdRecipes.add(newRecipe);
    }

    public void deleteRecipe(Recipe recipe) {
        this.createdRecipes.remove(recipe);
    }

    public Set<Recipe> getLikedRecipes() {
        return likedRecipes;
    }

    public void addLikedRecipe(Recipe recipe) {
        this.likedRecipes.add(recipe);
    }

    public void removeLikedRecipe(Recipe recipe) {
        this.likedRecipes.remove(recipe);
    }

    public void updateRecipe(Recipe recipe, String title, String category, String instructions, String imageUrl, Boolean isPublic, Set<Ingredient> ingredients) {
        recipe.setTitle(title);
        recipe.setCategory(category);
        recipe.setInstructions(instructions);
        recipe.setImageUrl(imageUrl);
        recipe.setPublic(isPublic);
        recipe.setIngredients(ingredients);
    }
}
