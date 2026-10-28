import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.towson.cis.cosc442.project4.coffeemaker.CoffeeMaker;
import edu.towson.cis.cosc442.project4.coffeemaker.Inventory;
import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;
    Inventory inventory;
    Recipe recipe1;
    Recipe recipe2;

    @BeforeEach
    void setup(){
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
    } 

    @AfterEach
    void teardown(){
        coffeeMaker = null;
        inventory = null;
        recipe1 = null;
        recipe2 = null;
    } 

    @Test
    void testAddInventory() {

        assertTrue(coffeeMaker.addInventory(10, 4, -3, 7));
        assertFalse(coffeeMaker.addInventory(10, 4, 6, 7));
        assertFalse(coffeeMaker.addInventory(-1, 4, -1, 7));

    }

    @Test
    void testAddRecipe() {

        coffeeMaker.addRecipe(recipe1);
        Recipe[] arr = coffeeMaker.getRecipes();
        assertEquals(recipe1, arr[3]);

        coffeeMaker.addRecipe(recipe1);
        arr = coffeeMaker.getRecipes();
        assertEquals(recipe1, arr[2]);

        coffeeMaker.addRecipe(recipe1);
        arr = coffeeMaker.getRecipes();
        assertEquals(recipe1, arr[1]);

        coffeeMaker.addRecipe(recipe1);
        arr = coffeeMaker.getRecipes();
        assertEquals(recipe1, arr[0]);

        assertFalse(coffeeMaker.addRecipe(recipe1));

    }


    @Test
    void testCheckInventory() {
        assertNotNull(coffeeMaker.checkInventory());
    }

    @Test
    void testDeleteRecipe() {

        coffeeMaker.addRecipe(recipe1);
        Recipe[] arr = coffeeMaker.getRecipes();
        assertEquals(recipe1, arr[3]);
        assertTrue(coffeeMaker.deleteRecipe(recipe1));

        assertFalse(coffeeMaker.deleteRecipe(recipe2));

    }

    @Test
    void testEditRecipe() {

        coffeeMaker.addRecipe(recipe1);
        assertTrue(coffeeMaker.editRecipe(recipe2, recipe1));
        assertFalse(coffeeMaker.editRecipe(recipe1, recipe2));

    }

    @Test
    void testGetRecipeForName() {

        coffeeMaker.addRecipe(recipe1);
        assertEquals(recipe1, coffeeMaker.getRecipeForName("Coffee1"));

    }

    @Test
    void testGetRecipes() {

        assertNotNull(coffeeMaker.getRecipes());

    }

    @Test
    void testMakeCoffee() {

        assertEquals(5, coffeeMaker.makeCoffee(recipe1, 5));
        assertTrue(coffeeMaker.addInventory(15, 15, -3, 15));
        assertEquals(0, coffeeMaker.makeCoffee(recipe2, 4));

    }
}
