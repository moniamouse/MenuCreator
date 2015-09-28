/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oem
 */
public class FoodComponentTest {
    
    private final FoodComponent instance;
    private final String name = "Bread";
    private final String code = "1234";
    private final NutritionComponent[] nutritionTable;
    
    public FoodComponentTest() {
        nutritionTable = new NutritionComponent[3];
        nutritionTable[0] = new NutritionComponent("Carbo", "Carbo", "g", 80);
        nutritionTable[1] = new NutritionComponent("Fat", "Fat", "g", 8);
        nutritionTable[2] = new NutritionComponent("Protein", "Protein", "g", 4);
        
        instance = new FoodComponent(name, code, nutritionTable);
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance.setCode(code);
        instance.setName(name);
        instance.setNutritionTable(nutritionTable);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class FoodComponent.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class FoodComponent.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String testName = name + "1";
        instance.setName(testName);
        assertEquals(instance.getName(),testName);
        setUp();
    }

    /**
     * Test of getCode method, of class FoodComponent.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        String expResult = code;
        String result = instance.getCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCode method, of class FoodComponent.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String testCode = code + "1";
        instance.setCode(testCode);
        assertEquals(instance.getCode(), testCode);
    }

    /**
     * Test of getNutritionTable method, of class FoodComponent.
     */
    @Test
    public void testGetNutritionTable() {
        System.out.println("getNutritionTable");
        NutritionComponent[] expResult = nutritionTable;
        NutritionComponent[] result = instance.getNutritionTable();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setNutritionTable method, of class FoodComponent.
     */
    @Test
    public void testSetNutritionTable() {
        System.out.println("setNutritionTable");
        NutritionComponent[] testNutritionTable = nutritionTable.clone();
        testNutritionTable[0].setAmount(120);
        if(nutritionTable == testNutritionTable)
            fail();
        
        instance.setNutritionTable(testNutritionTable);
        assertTrue(instance.getNutritionTable() == testNutritionTable);
        setUp();
    }
    
}
