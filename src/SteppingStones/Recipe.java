package SteppingStones;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Creating a new recipe for storing in recipeBox
 * @author Brian Gould
 */
public class Recipe {

    private String recipeName;
    private double servings = 0;
    private ArrayList<Ingredient> recipeIngredients;
    private double totalRecipeCalories = 0;
    private ArrayList recipeDirections = new ArrayList();

    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public double getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(double servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the totalRecipeCalories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     *
     * @param recipeName to recipeName to set
     */
    public Recipe(String recipeName) {
        this.recipeName = recipeName;

    }

    /**
     *
     * @return the recipeDirections
     */
    public ArrayList getRecipeDirections() {
        return recipeDirections;
    }

    /**
     *
     * @param recipeDirections the recipeDirections to set
     */
    public void setRecipeDirections(ArrayList recipeDirections) {
        this.recipeDirections = recipeDirections;
    }
    //constructor with values initialized
    //default constructor

    /**
     * no args constructor
     */
    public Recipe() {
        this.recipeName = ""; //assignment for empty string
        this.servings = 0.0; //<--- assignment value with appropriate data type
        this.recipeIngredients = new ArrayList<Ingredient>();  //<-- assignment value for empty ArrayList
        this.totalRecipeCalories = 0.0; //initial value
        this.recipeDirections = new ArrayList();
    }

    //contructor with values
    /**
     *
     * @param recipeName
     * @param servings
     * @param recipeIngredients
     * @param totalRecipeCalories
     * @param recipeDirections
     */
    public Recipe(String recipeName, double servings, ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories, ArrayList recipeDirections) //<-- use appropriate data type for the ArrayList and the servings arguments
    {
        this.recipeName = recipeName; //callback to recipeName for constructor
        this.servings = servings; //callback to servings
        this.recipeIngredients = recipeIngredients; //same for recipeIngredients
        this.totalRecipeCalories = totalRecipeCalories; //totalRecipeCalories
        this.recipeDirections = recipeDirections;
    }
    //  begin printRecipe method

    /**
     * takes a recipe from the array and prints all details
     */
    public void printRecipe() {

        double singleServingCalories = (getTotalRecipeCalories() / getServings());
        // formula for calculating total calories in declaration

        //Prints the information the whole recipe
        System.out.println(""); //blank line
        System.out.println("Recipe: " + getRecipeName()); //print recipe
        System.out.println("Serves: " + getServings()); //servings
        System.out.println("***Ingredients List*** "); //cleaner code
        for (int i = 0; i < recipeIngredients.size(); ++i) {
            //For loop to interate through each ingredient in the Recipe.
            Ingredient ingredientList = getRecipeIngredients().get(i);

            System.out.println(ingredientList.ingredientAmount + " " + ingredientList.unitMeasurement + " of " + ingredientList.nameOfIngredient + ".");
            System.out.println("There are " + ingredientList.caloriesPerUnit + " calories per " + ingredientList.unitMeasurement + " for a total of " + ingredientList.totalCalories + " calories");
        }
        /*for loop starting at first array item at index 0 until 
           last ingredient to print all values
         */

        System.out.println("Each serving has " + singleServingCalories + " Calories.");
        //FIXME: The single serving calories will not populate
        printRecipeDirections();
        //calls the recipeDirections method

        /**
         * Print the following recipe information: Recipe: <<recipeName>>
         * Serves: <<servings>> Ingredients: <<Ingredient1>> <<Ingredient2>> ...
         * <<Last Ingredient>>
         *
         * Each serving has <<singleServingCalories>> Calories.
         *
         * HINT --> Use a for loop to iterate through the ingredients
         */
    }
    // begin createNewRecipe method

    /**
     *
     * @return new Recipe object to the RecipeBox
     */
    public Recipe createNewRecipe() {

        double totalRecipeCalories = 0.0;
        ArrayList<Ingredient> recipeIngredients = new ArrayList();
        boolean addMoreIngredients = true;
        Ingredient newIngredient = new Ingredient();
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();

        //insert code for type validation
        while (recipeName.length() < 1) {
            System.out.println("That is not a valid name.");
            System.out.println("Please enter the recipe name");
            recipeName = scnr.nextLine();
        }
        setRecipeName(recipeName);
        System.out.println("Please enter the number of servings: ");
        //correct data type & Scanner assignment method for servings variable
        double servings = scnr.nextDouble();
        setServings(servings);
        //recipeIngredients.add(newIngredient.createNewIngredient());

        do {
            System.out.println("Would you like to enter any ingredients? (y/n) ");
            String reply = scnr.next().toLowerCase();
            //option to add ingredients

            //verifies that y or n was entered
            while (!(reply.equals("y") || reply.equals("n"))) {
                System.out.println("That is not a valid entry try again ");
                System.out.println("Would you like to enter an ingredient? (y/n)");
                reply = scnr.next().toLowerCase();

            } //while y code runs
            while (reply.equals("y")) {
                recipeIngredients.add(newIngredient.createNewIngredient());
                setRecipeIngredients(recipeIngredients);
                System.out.println("Any more ingredients?");
                reply = scnr.next().toLowerCase();
            }
            //exits the while loop
            if (reply.equals("n")) {
                addMoreIngredients = false;
            }

        } while (addMoreIngredients); //continue to ask for ingredients until "n" is entered

        // calls the addRecipeDirections       
        addRecipeDirections();
        //passes the recipe to the recipe box
        Recipe recipe1 = new Recipe(getRecipeName(), getServings(), recipeIngredients, getTotalRecipeCalories(), recipeDirections);

        return recipe1;
    }

    /**
     * method for adding directions to the recipe
     */
    public void addRecipeDirections() {
        ArrayList<String> recipeDirections = new ArrayList<String>(); //array for holding directions
        Scanner scnr = new Scanner(System.in);

        String reply = ""; //for scanner input
        boolean moreDirections = true; //to break out of directions loop

        // follows a similar style of loop as the ingredients
        do {
            System.out.println("Would you like to enter any instructions? (y/n)");
            reply = scnr.next().toLowerCase();

            while (!(reply.equals("y") || reply.equals("n"))) {
                System.out.println("That is not a valid response, please try again ");
                System.out.println("Would you like to enter an instruction? ");
                reply = scnr.next().toLowerCase();
            }

            while (reply.equals("y")) {
                System.out.println("Please enter an instruction ");
                recipeDirections.add(scnr.next());
                //FIXME can not appear to get a full line of directions regardless of using scnr.next or scnr.nextLine
                setRecipeDirections(recipeDirections);
                System.out.println("Do you have any more instructions? ");
                reply = scnr.next().toLowerCase();
            }

            if (reply.equals("n")) {
                moreDirections = false; //break out of loop
            }

        } while (moreDirections); //changes to false if "n" is selected
    }

    /**
     * method for printing out the entered directions
     */
    public void printRecipeDirections() {
        int directionStep = 0; //for printing a number before each step
        System.out.println(" "); // blank speace for cleaner code

        System.out.println("***Instructions*** ");

        for (int i = 0; i < getRecipeDirections().size(); i++) {
            ++directionStep;
            System.out.println(directionStep + ": " + getRecipeDirections().get(i));
        }

    }

}
