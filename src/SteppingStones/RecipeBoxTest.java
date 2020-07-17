package SteppingStones;

import java.util.ArrayList;

/**
 * Test application for verifying program works
 * @author Brian Gould
 */
public class RecipeBoxTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // create ingredients through the ingredient constructor
        ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
        Ingredient cheese = new Ingredient("Cheese", 3, 4, 12, "slices"); // format for each is (name, amount, calories, total cal, measurement)
        Ingredient beef = new Ingredient("ground beef", 1, 40, 40, "lb");
        Ingredient bread = new Ingredient("Bread", 2, 20, 20, "slices");
        // add ingredients to array
        recipeIngredients.add(cheese);
        recipeIngredients.add(beef);
        recipeIngredients.add(bread);
        // add directions to direction array
        ArrayList<String> recipeDirections = new ArrayList<String>();
        recipeDirections.add("Form beef into patty");
        recipeDirections.add("Grill beef");
        recipeDirections.add("Place cheese on top");
        recipeDirections.add("Place burger and cheese between bread slices");
        // creates the full recipe
        Recipe recipe1 = new Recipe(
                "Cheeseburger", 2, recipeIngredients, 300, recipeDirections);
        System.out.println("Recipe 1"); // for start of test
        recipe1.printRecipe(); //follows print recipe method

        // Now change some of the values using mutator methods
        recipe1.setRecipeName("Steak Tips"); //change name
        recipe1.setServings(3);
        recipe1.setTotalRecipeCalories(90); //change calories
        recipeDirections.clear(); //clear out directions and ingredients to make sure code still runs correctly
        recipeIngredients.clear();
        System.out.println(); // blank line
        System.out.println("RECIPE 1 (Modified)");
        // printRecipe() will show these values have changed and ingredients and directions are cleared out.
        recipe1.printRecipe(); //reprint the recipe

        // test input logic of create new recipe
        System.out.println(); // blank line
        System.out.println("RECIPE 2");
        Recipe recipe2 = new Recipe();
        recipe2.createNewRecipe();
        recipe2.printRecipe(); //prints a completely new recipe
    }

}
