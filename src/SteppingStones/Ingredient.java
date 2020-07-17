
package SteppingStones;

import java.util.Scanner;

/**
 * Class for storing ingredients for a recipe in an object Array
 *
 * @author Brian Gould
 */
public class Ingredient {

    /**
     * @param args the command line arguments
     */
    String nameOfIngredient = ""; //ingredient name
    float ingredientAmount = 0; //generic amount of the ingredient
    double caloriesPerUnit = 0.0; //calories 
    double totalCalories = 0.0; // used for calculating total calories at the end of program
    String unitMeasurement = ""; // cups/ tsp/ ounces/ whatever
    final int MAX_AMOUNT = 100;

    /*
         *Used a constant for max amount of ingredient to allow for flexibility of program
     */

    // Default (no args) constructor
    /**
     * no args constructor
     */
    public Ingredient() {
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.caloriesPerUnit = 0.0;
        this.totalCalories = 0.0;
        this.unitMeasurement = "";
    }

    /**
     *
     * @return the NameOfIngredient
     */
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    /**
     *
     * @param nameOfIngredient
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    /**
     *
     * @return the Ingredient Amount
     */
    public float getIngredientAmount() {
        return ingredientAmount;
    }

    /**
     *
     * @param ingredientAmount
     */
    public void setIngredientAmount(float ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    /**
     *
     * @return the ingredient amount
     */
    public double getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    /**
     *
     * @param caloriesPerUnit
     */
    public void setCaloriesPerUnit(double caloriesPerUnit) {
        this.caloriesPerUnit = caloriesPerUnit;
    }

    /**
     *
     * @return the total recipe calories
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    /**
     *
     * @param totalCalories
     */
    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     *
     * @return the type of measurement for ingredient
     */
    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    /**
     *
     * @param unitMeasurement
     */
    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }
    // Overloaded constructor

    /**
     *
     * @param nameOfIngredient
     * @param ingredientAmount
     * @param caloriesPerUnit
     * @param totalCalories
     * @param unitMeasurement
     */
    public Ingredient(String nameOfIngredient, float ingredientAmount, double caloriesPerUnit, double totalCalories, String unitMeasurement) {
        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.caloriesPerUnit = caloriesPerUnit;
        this.totalCalories = totalCalories;
        this.unitMeasurement = unitMeasurement;
    }

    /**
     *
     * @return
     */
    public Ingredient createNewIngredient() {
        Scanner scnr = new Scanner(System.in);

        //INGREDIENT NAME SECTION
        System.out.println("Please enter the ingredient name: ");
        nameOfIngredient = scnr.nextLine();

        //while loop to continue to prompt for a valid ingredient name. 
        while (nameOfIngredient.length() < 1) { //validation that something is entered
            System.out.println("That is not a valid ingredient. Please try again");
            System.out.println("Please enter the ingredient name:");
            nameOfIngredient = scnr.nextLine();
        }
        System.out.println(nameOfIngredient + " is a valid ingredient name!");

        /* 
         * INGREDIENT AMOUNT SECTION
         */
        System.out.println(""); //added for cleaner output
        System.out.println("Please enter the amount of " + nameOfIngredient + " between 1 and " + MAX_AMOUNT + ": ");
        if (scnr.hasNextFloat()) { //type validation for float
            ingredientAmount = scnr.nextFloat(); //gets float now that it is validated

            if ((ingredientAmount > 0) && (ingredientAmount <= MAX_AMOUNT)) {
                System.out.println(ingredientAmount + " is a valid amount!");
            } //as long as a correct amount is entered
            else {
                System.out.println(ingredientAmount + " is not a valid amount!");
                //message if non-allowed amount  
                //start of nested do-while is else statement runs
                do {
                    System.out.println("Please enter the amount of" + nameOfIngredient + "between 1 and " + MAX_AMOUNT);
                    ingredientAmount = scnr.nextFloat();
                    // repeats the same if-else to contine to prompt
                    if ((ingredientAmount >= 1) && (ingredientAmount <= MAX_AMOUNT)) {
                        System.out.println(ingredientAmount + " is a valid amount!");
                    } else {
                        System.out.println(ingredientAmount + " is not a valid amount!");
                    }
                } while (ingredientAmount < 1 || ingredientAmount > MAX_AMOUNT);
            }
            //Above do-while will continue to prompt for a correct amount until entered.

            /*
             * MEASUREMENT TYPE SECTION  
             */
            System.out.println(""); //added for cleaner output
            System.out.println("What is the measurement size? (cup/ounce/teaspoon etc) ");
            unitMeasurement = scnr.next();
            if (unitMeasurement.length() > 0) {//validates that something was typed
                System.out.println(unitMeasurement + " is a valid measurement!");

                /*
                 * CALORIES SECTION
                 */
                System.out.println(""); //added for cleaner output
                System.out.println("How many calories per " + unitMeasurement + "?");
                if (scnr.hasNextDouble()) { //validates a number was typed

                    caloriesPerUnit = scnr.nextDouble(); //passes number once validated
                    totalCalories = caloriesPerUnit * ingredientAmount;
                    System.out.println(""); //added this line and below line to make output look cleaner
                    System.out.println("***INGREDIENT***");
                    System.out.println("You entered " + ingredientAmount + " " + unitMeasurement + " of " + nameOfIngredient + ".");
                    System.out.println("The " + nameOfIngredient + " has " + totalCalories + " total calories");
                    //callback to each entry for cleaner output

                } else { //calorie validation error message (non-double)
                    System.out.println("*ERROR* That is not a valid entry for calories. Exiting program");
                }

            } else { //measurement type validation error message (string less than 1)
                System.out.println("*ERROR* That is not a valid entry for measurement. Exiting program");
            }
        } else { //amount validation error message (non-float)
            System.out.println("*ERROR* That is not a valid entry for amount. Exiting program");
        }
        setTotalCalories(getIngredientAmount() * getCaloriesPerUnit());

        Ingredient newIngredient = new Ingredient(getNameOfIngredient(), getIngredientAmount(), getCaloriesPerUnit(), getTotalCalories(), getUnitMeasurement());
        return newIngredient;
    }
}
