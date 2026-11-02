package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.towson.cis.cosc442.project4.coffeemaker.Inventory;
import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

public class InventoryTest {

Inventory inventory;
Recipe recipe;

@BeforeEach
    void setup(){
        inventory = new Inventory();
        recipe = new Recipe();
    } 

    @AfterEach
    void teardown(){
        inventory = null;
        recipe = null;
    }

    @ParameterizedTest 
    @CsvSource({
        "16,15,15,15",
        "15,16,15,15",
        "15,15,16,15",
        "15,15,15,16"
    }) 
    void testEnoughIngredientsFalse(int coffee, int milk, int sugar, int chocolate) {

        recipe.setAmtCoffee(coffee);
        recipe.setAmtMilk(milk);
        recipe.setAmtSugar(sugar);
        recipe.setAmtChocolate(chocolate);

        assertFalse(inventory.enoughIngredients(recipe));

    }

    @Test 
    void testEnoughIngredientsTrue(){
        recipe.setAmtCoffee(15);
        recipe.setAmtMilk(15);
        recipe.setAmtSugar(15);
        recipe.setAmtChocolate(15);

        assertTrue(inventory.enoughIngredients(recipe));

    }

  @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetChocolate(int expected, int total) {

        inventory.setChocolate(total);
        assertEquals(expected, inventory.getChocolate());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetCoffee(int expected, int total) {

        inventory.setCoffee(total);
        assertEquals(expected, inventory.getCoffee());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetMilk(int expected, int total) {

        inventory.setMilk(total);
        assertEquals(expected, inventory.getMilk());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetSugar(int expected, int total) {

        inventory.setSugar(total);
        assertEquals(expected, inventory.getSugar());

    }

    @Test 
    void testToString(){
        assertEquals("Coffee: " + 15 + "\n" + "Milk: " + 15 + "\n" +
                     "Sugar: " + 15 + "\n" + "Chocolate: " + 15 + "\n", 
                     inventory.toString());
    }
}
