/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oem
 */
public class NutritionCollectionTest {
    
    public NutritionCollectionTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class NutritionCollection.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Integer i = null;
        NutritionCollection instance = new NutritionCollection();
        NutritionComponent expResult = null;
        NutritionComponent result = instance.get(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNutritionList method, of class NutritionCollection.
     */
    @Test
    public void testGetNutritionList() {
        System.out.println("getNutritionList");
        NutritionCollection instance = new NutritionCollection();
        ArrayList<NutritionComponent> expResult = null;
        ArrayList<NutritionComponent> result = instance.getNutritionList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class NutritionCollection.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Integer i = null;
        NutritionComponent nutrition = null;
        NutritionCollection instance = new NutritionCollection();
        instance.set(i, nutrition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class NutritionCollection.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        NutritionComponent nutrition = null;
        NutritionCollection instance = new NutritionCollection();
        instance.add(nutrition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class NutritionCollection.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        NutritionComponent nutrition = null;
        NutritionCollection instance = new NutritionCollection();
        instance.remove(nutrition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class NutritionCollection.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
        NutritionCollection instance = new NutritionCollection();
        List<NutritionComponent> expResult = null;
        List<NutritionComponent> result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByType method, of class NutritionCollection.
     */
    @Test
    public void testFindByType() {
        System.out.println("findByType");
        String type = "";
        NutritionCollection instance = new NutritionCollection();
        List<NutritionComponent> expResult = null;
        List<NutritionComponent> result = instance.findByType(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNameTypeUnit method, of class NutritionCollection.
     */
    @Test
    public void testFindByNameTypeUnit() {
        System.out.println("findByNameTypeUnit");
        String name = "";
        String type = "";
        String unit = "";
        NutritionCollection instance = new NutritionCollection();
        List<NutritionComponent> expResult = null;
        List<NutritionComponent> result = instance.findByNameTypeUnit(name, type, unit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class NutritionCollection.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        NutritionCollection instance = new NutritionCollection();
        Integer expResult = null;
        Integer result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class NutritionCollection.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        NutritionCollection instance = new NutritionCollection();
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
