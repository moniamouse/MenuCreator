/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oem
 */
public class FoodComponentsCollectionTest {
    
    private final FoodComponentsCollection instance;

    private final FoodComponent foodComponent1;
    private final FoodComponent foodComponent2;
    private final NutritionComponent[] nutrition1;
    private final NutritionComponent[] nutrition2;

    private final FoodComponent foodComponent11;
    private final FoodComponent foodComponent21;
    private final NutritionComponent[] nutrition11;
    private final NutritionComponent[] nutrition21;
    
    private final String name = "Breakfasts";

    
    public FoodComponentsCollectionTest() {
        
        nutrition1 = new NutritionComponent[3];
        nutrition1[0] = new NutritionComponent("Carbo", "Carbo", "g", 80);
        nutrition1[1] = new NutritionComponent("Fat", "Fat", "g", 8);
        nutrition1[2] = new NutritionComponent("Protein", "Protein", "g", 4);
        foodComponent1 = new FoodComponent("Bread", "12345", nutrition1);
        
        nutrition2 = new NutritionComponent[3];
        nutrition2[0] = new NutritionComponent("Carbo", "Carbo", "g", 10);
        nutrition2[1] = new NutritionComponent("Fat", "Fat", "g", 18);
        nutrition2[2] = new NutritionComponent("Protein", "Protein", "g", 34);
        foodComponent2 = new FoodComponent("Ham", "12344", nutrition2);
        
        nutrition11 = new NutritionComponent[3];
        nutrition11[0] = new NutritionComponent("Carbo", "Carbo", "g", 50);
        nutrition11[1] = new NutritionComponent("Fat", "Fat", "g", 9);
        nutrition11[2] = new NutritionComponent("Protein", "Protein", "g", 5);
        foodComponent11 = new FoodComponent("Oats", "12333", nutrition11);
        
        nutrition21 = new NutritionComponent[3];
        nutrition21[0] = new NutritionComponent("Carbo", "Carbo", "g", 15);
        nutrition21[1] = new NutritionComponent("Fat", "Fat", "g", 56);
        nutrition21[2] = new NutritionComponent("Protein", "Protein", "g", 44);
        foodComponent21 = new FoodComponent("Plum", "12324", nutrition21);
              
        instance = new FoodComponentsCollection(name);
        instance.addFoodComponent(foodComponent1);
        instance.addFoodComponent(foodComponent2);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addFoodComponent method, of class FoodComponentsCollection.
     */
    @Test
    public void testAddFoodComponent() {
                
        System.out.println("addFoodComponent");
        FoodComponent newFood = new FoodComponent("test", "1222", new NutritionComponent[0]);
        instance.addFoodComponent(newFood);
        assertEquals(newFood, instance.getFoodList().get(2));
        instance.removeFoodComponent(newFood);
    }

    /**
     * Test of removeFoodComponent method, of class FoodComponentsCollection.
     */
    @Test
    public void testRemoveFoodComponent() {
        System.out.println("removeFoodComponent");
        instance.removeFoodComponent(foodComponent2);
        assertTrue(instance.getFoodList().size()==1);
        
    }

    /**
     * Test of findFoodComponent method, of class FoodComponentsCollection.
     */
    @Test
    public void testFindFoodComponent() {
        System.out.println("findFoodComponent");
        String testName = foodComponent2.getName();
        FoodComponent expResult = foodComponent2;
        FoodComponent result = instance.findFoodComponent(testName);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class FoodComponentsCollection.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String result = instance.getName();
        assertEquals(name, result);

    }

    /**
     * Test of setName method, of class FoodComponentsCollection.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String tname = "name1";    
        instance.setName(tname);
        assertEquals(tname, instance.getName());
        instance.setName(name);
    }

    /**
     * Test of getFoodList method, of class FoodComponentsCollection.
     */
    @Test
    public void testGetFoodList() {
        System.out.println("getFoodList");
        ArrayList<FoodComponent> expResult = new ArrayList<>();
        expResult.add(foodComponent1);
        expResult.add(foodComponent2);
        ArrayList<FoodComponent> result = instance.getFoodList();
        assertEquals(expResult.get(0), result.get(0));
        assertEquals(expResult.get(1), result.get(1));
    }

    /**
     * Test of setFoodList method, of class FoodComponentsCollection.
     */
    @Test
    public void testSetFoodList() {
        System.out.println("setFoodList");
        ArrayList<FoodComponent> expResult = new ArrayList<>();
        expResult.add(foodComponent1);
        expResult.add(foodComponent2);
        instance.setFoodList(expResult);
        assertEquals(expResult, instance.getFoodList());
    }
    
}
