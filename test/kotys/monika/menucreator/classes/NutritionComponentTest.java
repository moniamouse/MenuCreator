/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NutritionComponentTest {
    
        private final NutritionComponent instance;
        private final String name = "Saturated";
        private final String type = "Fat";
        private final String unit = "g";
        private final float amount = 23.5f;
    
    public NutritionComponentTest() {
        instance = new NutritionComponent(this.name, this.type, this.unit, this.amount);
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.instance.setAmount(amount);
        this.instance.setName(name);
        this.instance.setType(type);
        this.instance.setUnit(unit);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class NutritionComponent.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = this.name;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class NutritionComponent.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String testName = name + "1";
        instance.setName(testName);
        assertEquals(testName, instance.getName());
        setUp();
    }

    /**
     * Test of getType method, of class NutritionComponent.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String expResult = type;
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class NutritionComponent.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String testType = type + "1";
        instance.setType(testType);
        assertEquals(testType, instance.getType());
        setUp();
    }

    /**
     * Test of getUnit method, of class NutritionComponent.
     */
    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        String expResult = unit;
        String result = instance.getUnit();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnit method, of class NutritionComponent.
     */
    @Test
    public void testSetUnit() {
        System.out.println("setUnit");
        String testUnit = "kj";
        instance.setUnit(testUnit);
        assertEquals(instance.getUnit(), testUnit);
        setUp();
    }

    /**
     * Test of getAmount method, of class NutritionComponent.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        float expResult = amount;
        float result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setAmount method, of class NutritionComponent.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        float testAmount = 25.0F;
        instance.setAmount(testAmount);
        assertEquals(testAmount , instance.getAmount(), 0.0f);
        setUp();
    }

    /**
     * Test of clone method, of class NutritionComponent.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        NutritionComponent result;
        try {
            result = (NutritionComponent)instance.clone();
                    assertTrue(
                instance.getAmount() == result.getAmount() 
                    && instance.getName().equals(result.getName())
                    && instance.getType().equals(result.getType())
                    && instance.getUnit().equals(result.getUnit())
                );
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(NutritionComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      /**
     * Test of clone method, of class NutritionComponent.
     */
    @Test
    public void testEqualsAndHashCode() {
        System.out.println("clone");
        NutritionComponent result;
        try {
            result = (NutritionComponent)instance.clone();
                    assertTrue(
                result.equals(instance) && result.hashCode()==instance.hashCode()
                );
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(NutritionComponentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
