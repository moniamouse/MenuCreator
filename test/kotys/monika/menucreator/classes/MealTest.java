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
public class MealTest {
    
    private final Meal instance;
    private final MealComponent mealComponent1;
    private final MealComponent mealComponent2;
    private final FoodComponent foodComponent1;
    private final FoodComponent foodComponent2;
    private final NutritionComponent[] nutrition;
    private final NutritionComponent[] nutrition1;
    private final NutritionComponent[] nutrition2;
    private final String name;
    private final MealType mealType;
    private final String prescription2;
    private final ArrayList<String> prescription1;
    
    public MealTest() {
        nutrition1 = new NutritionComponent[3];
        nutrition1[0] = new NutritionComponent("Carbo", "Carbo", "g", 80);
        nutrition1[1] = new NutritionComponent("Fat", "Fat", "g", 8);
        nutrition1[2] = new NutritionComponent("Protein", "Protein", "g", 4);
        foodComponent1 = new FoodComponent("Bread", "12345", nutrition1);
        mealComponent1 = new MealComponent(foodComponent1);
        mealComponent1.setAmount(150);
        
        nutrition2 = new NutritionComponent[3];
        nutrition2[0] = new NutritionComponent("Carbo", "Carbo", "g", 10);
        nutrition2[1] = new NutritionComponent("Fat", "Fat", "g", 18);
        nutrition2[2] = new NutritionComponent("Protein", "Protein", "g", 34);
        foodComponent2 = new FoodComponent("Ham", "12344", nutrition2);
        mealComponent2 = new MealComponent(foodComponent2);
        mealComponent2.setAmount(30);
        
        instance = new Meal();
        instance.addMealComponent(mealComponent1);
        instance.addMealComponent(mealComponent2);
        prescription1 = new ArrayList<>();
        prescription1.add("line1");
        prescription1.add("line2");
        prescription2 = prescription1.get(0) + System.lineSeparator() + prescription1.get(1) + System.lineSeparator();
        
        
        name = "Breakfast";
        instance.setName(name);
        mealType = new MealType();
        mealType.defaultSetup();
        instance.setType(mealType.getMealType().get(1));
        
        nutrition = new NutritionComponent[3];
        nutrition[0] = new NutritionComponent("Carbo", "Carbo", "g", 80 * 1.5f + 10 * 0.3F);
        nutrition[1] = new NutritionComponent("Fat", "Fat", "g", 8 * 1.5f + 18 * 0.3F);
        nutrition[2] = new NutritionComponent("Protein", "Protein", "g", 4 * 1.5f + 34 * 0.3F);
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMealComponent method, of class Meal.
     */
    @Test
    public void testAddMealComponent() {
        System.out.println("addMealComponent");
        MealComponent newMealComp = new MealComponent(new FoodComponent("butter", "1233", nutrition.clone()));
        instance.addMealComponent(newMealComp);
        assertTrue(instance.getComponentsList().size() == 3);
        instance.removeMealComponent(instance.getComponentsList().get(2));
    }

    /**
     * Test of removeMealComponent method, of class Meal.
     */
    @Test
    public void testRemoveMealComponent() {
        System.out.println("RemoveMealComponent");
        instance.removeMealComponent(mealComponent2);
        assertTrue(instance.getComponentsList().size() == 1);
        instance.addMealComponent(mealComponent2);
    }

    /**
     * Test of getNutritionList method, of class Meal.
     */
    @Test
    public void testGetNutritionList() {
        System.out.println("getNutritionList");
        ArrayList<NutritionComponent> result = instance.getNutritionList();
        assertTrue(result != null && result.size() == 3
        && result.get(0).equals(nutrition[0]) && result.get(1).equals(nutrition[1]) && result.get(2).equals(nutrition[2]));
    }

    /**
     * Test of getComponentsList method, of class Meal.
     */
    @Test
    public void testGetComponentsList() {
        System.out.println("getComponentsList");
        ArrayList<MealComponent> result = instance.getComponentsList();
        assertEquals(mealComponent1, result.get(0));
        assertEquals(mealComponent2, result.get(1));
    }

    /**
     * Test of findComponent method, of class Meal.
     */
    @Test
    public void testFindComponent() {
        
        System.out.println("findComponent");
        String findName = mealComponent1.getName();
        MealComponent expResult = mealComponent1;
        MealComponent result = instance.findComponent(findName).get(0);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getName method, of class Meal.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Meal.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String testName = "Dinner";
        instance.setName(testName);
        assertEquals(testName, instance.getName());
        instance.setName(name);
    }

    /**
     * Test of getType method, of class Meal.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String expResult = mealType.getMealType().get(1);
        String result = instance.getType();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setType method, of class Meal.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        instance.setType(mealType.getMealType().get(0));
        assertEquals(mealType.getMealType().get(0), instance.getType());
        instance.setType(mealType.getMealType().get(0));
    }
    
    @Test
    public void testSetPrescritption(){
        instance.setPrescritption(prescription1);
        assertEquals(prescription1, instance.getPrescritptionArray());
    }
    
    @Test
    public void testGetPrescritption(){
        instance.setPrescritption(prescription1);
        String result = instance.getPrescritption();
        assertEquals(prescription2, result);
    }
    
}
