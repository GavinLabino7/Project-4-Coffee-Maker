package edu.towson.cis.cosc442.project4.coffeemaker;

import edu.towson.cis.cosc442.project4.coffeemaker.CoffeeMaker;
import edu.towson.cis.cosc442.project4.coffeemaker.Inventory;
import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;
    Inventory inventory;
    Recipe recipe1;
    Recipe recipe2;
    Recipe recipe3;
    Recipe recipe4;
    Recipe recipe5;

    @BeforeEach
    void setup() {
        coffeeMaker = new CoffeeMaker();
        inventory = new Inventory();

        recipe1 = new Recipe();
        recipe1.setName("Coffee1");
        recipe1.setPrice(5);
        recipe1.setAmtCoffee(20);
        recipe1.setAmtMilk(1);
        recipe1.setAmtSugar(1);
        recipe1.setAmtChocolate(1);

        recipe2 = new Recipe();
        recipe2.setName("Coffee2");
        recipe2.setPrice(4);

        recipe3 = new Recipe();
        recipe3.setName("Coffee3");

        recipe4 = new Recipe();
        recipe4.setName("Coffee4");

        recipe5 = new Recipe();
        recipe5.setName("Coffee5");
    }

    @AfterEach
    void teardown() {
        coffeeMaker = null;
        inventory = null;
        recipe1 = null;
        recipe2 = null;
        recipe3 = null;
        recipe4 = null;
        recipe5 = null;
    }

    @Disabled 
    @ParameterizedTest
    @CsvSource({
        "-10, 10, 10, 10",
        "10, -10, 10, 10",
        "10, 10, -10, 10",
        "10, 10, 10, -10",
        "-1, 10, 10, 10",
        "10, -1, 10, 10",
        "10, 10, -1, 10",
        "10, 10, 10, -1"
    })
    void testAddInventory(int coffee, int milk, int sugar, int choco) {

        assertFalse(coffeeMaker.addInventory(coffee, milk, sugar, choco));

    }

    @Disabled 
    @Test
    void testAddInventoryTrue(){
        assertTrue(coffeeMaker.addInventory(10, 4, 3, 7));
        assertTrue(coffeeMaker.addInventory(0,0,0,0));
        assertEquals(19, inventory.getMilk());
        assertEquals(25, inventory.getCoffee());
        assertEquals(18, inventory.getSugar());
        assertEquals(22, inventory.getChocolate());

    }

    @Test
    void testAddRecipe() {

        assertTrue(coffeeMaker.addRecipe(recipe1));
        Recipe[] arr = coffeeMaker.getRecipes();
        assertEquals(recipe1, arr[0]);

        assertFalse(coffeeMaker.addRecipe(recipe1));

        assertTrue(coffeeMaker.addRecipe(recipe2));
        arr = coffeeMaker.getRecipes();
        assertEquals(recipe2, arr[1]);

        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.addRecipe(recipe4);

        assertFalse(coffeeMaker.addRecipe(recipe5));

    }

    @Test
    void testCheckInventory() {
        assertNotNull(coffeeMaker.checkInventory());
    }

    @Test
    void testDeleteRecipe() {

    coffeeMaker.addRecipe(recipe1);

    assertTrue(coffeeMaker.deleteRecipe(recipe1));

    assertFalse(coffeeMaker.deleteRecipe(recipe1));

    assertFalse(coffeeMaker.deleteRecipe(recipe2));

    assertFalse(coffeeMaker.deleteRecipe(null));

    }

    @Test
    void testEditRecipe() {

    coffeeMaker.addRecipe(recipe1);
    coffeeMaker.addRecipe(recipe1);

    assertTrue(coffeeMaker.editRecipe(recipe1, recipe2));
    assertEquals(recipe2, coffeeMaker.getRecipes()[1]);

    assertFalse(coffeeMaker.editRecipe(recipe1, recipe2));

    coffeeMaker.addRecipe(recipe1);
    assertFalse(coffeeMaker.editRecipe(recipe2, recipe1));

    }

    @Test
    void testGetRecipeForName() {
        
        coffeeMaker.addRecipe(recipe1);
        assertEquals(recipe1, coffeeMaker.getRecipeForName("Coffee1"));
        assertNotNull(coffeeMaker.getRecipeForName("Coffee3"));

    }

    @Test
    void testGetRecipes() {
        assertNotNull(coffeeMaker.getRecipes());
    }

    @Disabled 
    @Test
    void testMakeCoffee() {

    assertEquals(4, coffeeMaker.makeCoffee(recipe1, 4));

    coffeeMaker.addInventory(25, 15, 15, 15);
    assertEquals(0, coffeeMaker.makeCoffee(recipe1, 5));
    assertEquals(0, coffeeMaker.makeCoffee(recipe2, 4));
    assertEquals(0, coffeeMaker.makeCoffee(recipe2, 4));

        assertEquals(29, inventory.getMilk());
        assertEquals(20, inventory.getCoffee());
        assertEquals(29, inventory.getSugar());
        assertEquals(29, inventory.getChocolate());

    }
}