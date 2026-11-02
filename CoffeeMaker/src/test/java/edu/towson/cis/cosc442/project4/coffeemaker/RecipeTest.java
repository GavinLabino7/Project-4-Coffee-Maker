package edu.towson.cis.cosc442.project4.coffeemaker;

import edu.towson.cis.cosc442.project4.coffeemaker.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RecipeTest {

    Recipe recipe1;
    Recipe recipe2;

    @BeforeEach
    void setup(){
        recipe1 = new Recipe();
        recipe2 = new Recipe();
    } 

    @AfterEach
    void teardown(){
        recipe1 = null;
        recipe2 = null;
    }

    @Test
    void testEquals() {

        recipe1.setName("Gavin");
        recipe2.setName("Gavin");
        assertTrue(recipe1.equals(recipe2));

        recipe2.setName("Zelda");
        assertFalse(recipe1.equals(recipe2));
        

    }

    @Test
    void testEqualsNull() {

        recipe1.setName("Gavin");
        assertFalse(recipe1.equals(recipe2));
        assertFalse(recipe2.equals(recipe1));

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetAmtChocolate(int expected, int total) {

        recipe1.setAmtChocolate(total);
        assertEquals(expected, recipe1.getAmtChocolate());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetAmtCoffee(int expected, int total) {

        recipe1.setAmtCoffee(total);
        assertEquals(expected, recipe1.getAmtCoffee());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetAmtMilk(int expected, int total) {

        recipe1.setAmtMilk(total);
        assertEquals(expected, recipe1.getAmtMilk());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetAmtSugar(int expected, int total) {

        recipe1.setAmtSugar(total);
        assertEquals(expected, recipe1.getAmtSugar());

    }

    @Test
    void testSetName() {

        recipe1.setName("Gavin");
        assertEquals("Gavin", recipe1.getName());

    }

    @ParameterizedTest 
    @CsvSource ({
        "5, 5",
        "0, 0",
        "0, -1"
    })
    void testSetPrice(int expected, int total) {

        recipe1.setPrice(total);
        assertEquals(expected, recipe1.getPrice());

    }

    @Test
    void testToString() {
        recipe1.setName("Gavin");
        assertEquals(recipe1.getName(), recipe1.toString());
    }
}
