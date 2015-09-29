/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oem
 */
public class MealsCollectionTest {
    
        private final FoodComponentsCollection instance;
    private final Meal meal1;
    private final Meal meal2;
    
    private final MealComponent mealComponent1;
    private final MealComponent mealComponent2;
    private final FoodComponent foodComponent1;
    private final FoodComponent foodComponent2;
    private final NutritionCollection nutrition1;
    private final NutritionCollection nutrition2;
    private final String name;
    private final MealType mealType;
    
    private final MealComponent mealComponent11;
    private final MealComponent mealComponent21;
    private final FoodComponent foodComponent11;
    private final FoodComponent foodComponent21;
    private final NutritionCollection nutrition11;
    private final NutritionCollection nutrition21;
    private final String name1;
    private final MealType mealType1;
    
    public MealsCollectionTest() throws NullPointerException, CloneNotSupportedException {
        
        nutrition1 = new NutritionCollection();
        nutrition1.add(new NutritionComponent("Carbo", "Carbo", "g", 80));
        nutrition1.add(new NutritionComponent("Fat", "Fat", "g", 8));
        nutrition1.add(new NutritionComponent("Protein", "Protein", "g", 4));
        foodComponent1 = new FoodComponent("Bread", "12345", nutrition1);
        mealComponent1 = new MealComponent(foodComponent1);
        mealComponent1.setAmount(150);
        
        nutrition2 = new NutritionCollection();
        nutrition2.add(new NutritionComponent("Carbo", "Carbo", "g", 10));
        nutrition2.add(new NutritionComponent("Fat", "Fat", "g", 18));
        nutrition2.add(new NutritionComponent("Protein", "Protein", "g", 34));
        foodComponent2 = new FoodComponent("Ham", "12344", nutrition2);
        mealComponent2 = new MealComponent(foodComponent2);
        mealComponent2.setAmount(30);
        
        meal1 = new Meal();
        meal1.addMealComponent(mealComponent1);
        meal1.addMealComponent(mealComponent2);
       
        name = "Sandwich";
        meal1.setName(name);
        mealType = new MealType();
        mealType.defaultSetup();
        meal1.setType(mealType.getMealType().get(1));
        
        nutrition11 = new NutritionCollection();
        nutrition11.add(new NutritionComponent("Carbo", "Carbo", "g", 50));
        nutrition11.add(new NutritionComponent("Fat", "Fat", "g", 9));
        nutrition11.add(new NutritionComponent("Protein", "Protein", "g", 5));
        foodComponent11 = new FoodComponent("Oats", "12333", nutrition11);
        mealComponent11 = new MealComponent(foodComponent11);
        mealComponent11.setAmount(150);
        
        nutrition21 = new NutritionCollection();
        nutrition21.add(new NutritionComponent("Carbo", "Carbo", "g", 15));
        nutrition21.add(new NutritionComponent("Fat", "Fat", "g", 56));
        nutrition21.add(new NutritionComponent("Protein", "Protein", "g", 44));
        foodComponent21 = new FoodComponent("Plum", "12324", nutrition21);
        mealComponent21 = new MealComponent(foodComponent21);
        mealComponent21.setAmount(30);
        
        meal2 = new Meal();
        meal2.addMealComponent(mealComponent11);
        meal2.addMealComponent(mealComponent21);
       
        name1 = "Oat meal";
        meal2.setName(name1);
        mealType1 = new MealType();
        mealType1.defaultSetup();
        meal2.setType(mealType.getMealType().get(1));
        
        instance = new FoodComponentsCollection("Breakfasts");
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
     * Test of getMealsCount method, of class MealsCollection.
     */
    @Test
    public void testGetMealsCount() {
        System.out.println("getMealsCount");
        MealsCollection instance = null;
        int expResult = 0;
        int result = instance.getMealsCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMeal method, of class MealsCollection.
     */
    @Test
    public void testAddMeal() {
        System.out.println("addMeal");
        Meal meal = null;
        MealsCollection instance = null;
        instance.addMeal(meal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMeal method, of class MealsCollection.
     */
    @Test
    public void testRemoveMeal() {
        System.out.println("removeMeal");
        Meal meal = null;
        MealsCollection instance = null;
        instance.removeMeal(meal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMeal method, of class MealsCollection.
     */
    @Test
    public void testFindMeal() {
        System.out.println("findMeal");
        String name = "";
        MealsCollection instance = null;
        ArrayList<Meal> expResult = null;
        ArrayList<Meal> result = instance.findMeal(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class MealsCollection.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MealsCollection instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class MealsCollection.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        MealsCollection instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetailedDate method, of class MealsCollection.
     */
    @Test
    public void testGetDetailedDate() {
        System.out.println("getDetailedDate");
        MealsCollection instance = null;
        Date expResult = null;
        Date result = instance.getDetailedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetailedDate method, of class MealsCollection.
     */
    @Test
    public void testSetDetailedDate() {
        System.out.println("setDetailedDate");
        Date detailedDate = null;
        MealsCollection instance = null;
        instance.setDetailedDate(detailedDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMeals method, of class MealsCollection.
     */
    @Test
    public void testGetMeals() {
        System.out.println("getMeals");
        MealsCollection instance = null;
        ArrayList<Meal> expResult = null;
        ArrayList<Meal> result = instance.getMeals();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMeals method, of class MealsCollection.
     */
    @Test
    public void testSetMeals() {
        System.out.println("setMeals");
        ArrayList<Meal> meals = null;
        MealsCollection instance = null;
        instance.setMeals(meals);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class MealsCollection.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        MealsCollection instance = null;
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class MealsCollection.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        MealsCollection instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
