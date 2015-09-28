/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import kotys.monika.menucreator.interfaces.IMenuCreatorLoader;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oem
 */
public class FoodComponent_LoaderTest {
    
    public FoodComponent_LoaderTest() {
    }
    
    MenuCreator_LoaderFactory instance;
    
    @Before
    public void setUp() {
        instance = MenuCreator_LoaderFactory.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class MenuCreator_LoaderFactory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MenuCreator_LoaderFactory expResult = instance;
        MenuCreator_LoaderFactory result = MenuCreator_LoaderFactory.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFoodComponent_Loader method, of class MenuCreator_LoaderFactory.
     */
    @Test
    public void testAddFoodComponent_Loader() {
        System.out.println("addFoodComponent_Loader");
        IMenuCreatorLoader loader = null;
        instance.addFoodComponent_Loader(loader);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFoodComponent_Loader method, of class MenuCreator_LoaderFactory.
     */
    @Test
    public void testRemoveFoodComponent_Loader() {
        System.out.println("removeFoodComponent_Loader");
        IMenuCreatorLoader loader = null;
        instance.removeFoodComponent_Loader(loader);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findLoaderByName method, of class MenuCreator_LoaderFactory.
     */
    @Test
    public void testFindLoaderByName() {
        System.out.println("findLoaderByName");
        String name = "testLoader";
        IMenuCreatorLoader expResult = null;
        IMenuCreatorLoader result = instance.findLoaderByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of listAvailbleLoaders method, of class MenuCreator_LoaderFactory.
     */
    @Test
    public void testListAvailbleLoaders() {
        System.out.println("listAvailbleLoaders");
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = instance.listAvailbleLoaders();
        assertEquals(expResult.size(), result.size());
    }
    
}
