package SteppingStones;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Menu driver application for program
 * @author Brian Gould
 */
public class RecipeBox {

    private ArrayList<Recipe> listOfRecipes;

    /**
     * @param args the command line arguments
     */
    /**
     * @return the listOfRecipes
     */
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    /**
     * @param listOfRecipes the listOfRecipes to set
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    /**
     * No args for RecipeBox
     */
    public RecipeBox() {
        this.listOfRecipes = new ArrayList();
    }

    /**
     *
     * @param listOfRecipes with constructors
     */
    public RecipeBox(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    /**
     *
     * @param selectedRecipeName prints all the total details of recipe
     */
    public void printAllRecipeDetails(String selectedRecipeName) {
        for (int i = 0; i < listOfRecipes.size(); i++) {
            if (listOfRecipes.get(i).getRecipeName().equals(selectedRecipeName)) {
                listOfRecipes.get(i).printRecipe();
            }
        }
    }

    /**
     * method for printing just the name of each
     */
    public void printAllRecipeNames() {
        for (Recipe currentRecipe : listOfRecipes) {
            System.out.println(currentRecipe.getRecipeName());
        }
    }

    /**
     * method for adding a new recipe to the recipe box
     */
    public void addNewRecipe() {

        listOfRecipes.add(new Recipe().createNewRecipe());
    }

    /**
     * using included driver class
     *
     * @param args
     */
    public static void main(String[] args) {
        RecipeBox myRecipeBox = new RecipeBox(); //creates new instance of recipeBox
        Scanner menuScnr = new Scanner(System.in); //for selected a menu option
        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "\nPlease select a menu item:");
            int input = menuScnr.nextInt();
            if (input == 1) { //option for adding a new recipe
                myRecipeBox.addNewRecipe();
            } else if (input == 2) { //given a specific name prints the recipe
                System.out.print("Which recipe?\n");
                menuScnr.nextLine();
                String selectedRecipeName = menuScnr.nextLine();
                myRecipeBox.printAllRecipeDetails(selectedRecipeName);
            } else if (input == 3) { //will print a list of all recipes.
                myRecipeBox.printAllRecipeNames();
                for (int j = 0; j < myRecipeBox.listOfRecipes.size(); j++) {
                    System.out.println((j + 1) + ": " + myRecipeBox.listOfRecipes.get(j).getRecipeName());
                }
            } else {
                System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe\n" + "3. Adjust Recipe Servings\n" + "\nPlease select a menu item:");
            }
            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "\nPlease select a menu item:");

        }
    }
}
