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
public class MealComponentTest {

    private final MealComponent instance;
    private final FoodComponent foodComponent;
    private final float amount;
    private final NutritionCollection nutrition;
    private final String name;
    private final String code;

    
    public MealComponentTest() throws NullPointerException, IllegalArgumentException, CloneNotSupportedException {
        
        nutrition = new NutritionCollection();
        nutrition.add(new NutritionComponent("Carbo", "Carbo", "g", 80));
        nutrition.add(new NutritionComponent("Fat", "Fat", "g", 8));
        nutrition.add(new NutritionComponent("Protein", "Protein", "g", 4));
        code = "12345";
        amount = 130;
        name = "Bread";
                
        foodComponent = new FoodComponent(name, code, nutrition);
               
        instance = new MealComponent(foodComponent);
        instance.setAmount(amount);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
        foodComponent.setCode(code);
        foodComponent.setName(name);
        foodComponent.setNutritionTable(nutrition);
        instance.setFoodComponent(foodComponent);
        instance.setAmount(amount);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFoodComponent method, of class MealComponent.
     */
    @Test
    public void testGetFoodComponent() {
        
        FoodComponent expResult = foodComponent;
        FoodComponent result = instance.getFoodComponent();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFoodComponent method, of class MealComponent.
     */
    @Test
    public void testSetFoodComponent() throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
        System.out.println("setFoodComponent");
        FoodComponent testFoodComponent = new FoodComponent("Bun", "12344", nutrition);
        instance.setFoodComponent(testFoodComponent);
        assertEquals(instance.getFoodComponent(), testFoodComponent);
        setUp();
    }

    /**
     * Test of getAmount method, of class MealComponent.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        float expResult = amount;
        float result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAmount method, of class MealComponent.
     */
    @Test
    public void testSetAmount() throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
        System.out.println("setAmount");
        float testAmount = 125F;
        instance.setAmount(testAmount);
        assertEquals(testAmount, instance.getAmount(), 0.0);
        setUp();
    }

    /**
     * Test of getName method, of class MealComponent.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = name;
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setName method, of class MealComponent.
     */
    @Test
    public void testSetName() throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
        System.out.println("setName");
        String testName = "Bun";
        instance.setName(testName);
        assertEquals(instance.getName(), testName);
        setUp();
    }

    /**
     * Test of getNutrition method, of class MealComponent.
     */
    @Test
    public void testGetNutrition() {
        System.out.println("getNutrition");
        Boolean result = true;
        int length = nutrition.size();
        for(int i =0; i< length; i++)
        {
            if(instance.getNutrition().get(i).getAmount() != nutrition.get(i).getAmount() * amount/100)
                result = false;
        }
        assertTrue(result);
    }
    
}
