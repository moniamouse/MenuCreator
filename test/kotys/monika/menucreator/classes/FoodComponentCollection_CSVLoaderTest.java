/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oem
 */
public class FoodComponentCollection_CSVLoaderTest {
    
    public FoodComponentCollection_CSVLoaderTest() {
        instance = new FoodComponentCollection_CSVLoader();
    }
    
    final FoodComponentCollection_CSVLoader instance;
    
    @Before
    public void setUp() {    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLoadedClassName method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testGetLoadedClassName() {
        System.out.println("getLoadedClassName");
        String expResult = "FoodComponentCollection";
        String result = instance.getLoadedClassName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataSourceType method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testGetDataSourceType() {
        System.out.println("getDataSourceType");
        String expResult = "CSV";
        String result = instance.getDataSourceType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataSourceParameters method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testGetDataSourceParameters() {
        System.out.println("getDataSourceParameters");
        TreeMap<String, String> expResult = new TreeMap<>();
        expResult.put("FilePath", "");
        expResult.put("Headears_Count", "");
        expResult.put("Separator", ";");
        expResult.put("DecimalSeparator", ".");
        TreeMap<String, String> result = instance.getDataSourceParameters();
        assertEquals(expResult, result);
    }

    /**
     * Test of connect method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        String file = "C:\\Users\\oem\\Downloads\\tabele wartości odżywczych.csv";
        instance.getDataSourceParameters().put("FilePath", file);
        instance.getDataSourceParameters().put("Headears_Count", "3");
        instance.getDataSourceParameters().put("Separator", ";");
        boolean expResult = true;
        boolean result = instance.connect();
        assertEquals(expResult, result);
        instance.disconnect();
    }

    /**
     * Test of isConnected method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTargetObject method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testSetTargetObject() {
        System.out.println("setTargetObject");
        FoodComponentsCollection targetObject = new FoodComponentsCollection("test");
        instance.setTargetObject(targetObject);
        FoodComponentsCollection resultObject = (FoodComponentsCollection) instance.getTargetObject();
        assertEquals(targetObject, resultObject);
    }

    /**
     * Test of loadData method, of class FoodComponentCollection_CSVLoader.
     * @throws java.lang.Exception
     */
    @Test
    public void testLoadData() throws Exception {
        System.out.println("loadData");
        String file = "C:\\Users\\oem\\Downloads\\tabele wartości odżywczych.csv";
        instance.getDataSourceParameters().put("FilePath", file);
        instance.getDataSourceParameters().put("Headears_Count", "3");
        instance.getDataSourceParameters().put("Separator", ";");
        instance.getDataSourceParameters().put("DecimalSeparator", ",");
        instance.getHeadersMaping().put("Name", 2);
        instance.getHeadersMaping().put("Type", 1);
        instance.getHeadersMaping().put("Unit", 3);
        instance.getMapping().put("Name", 3);
        instance.getMapping().put("Code", 2);
        instance.getMapping().put("NutritionValues", 4);
        boolean expResult = true;
        instance.connect();
        boolean result = instance.loadData();
        FoodComponentsCollection instanceResult = (FoodComponentsCollection) instance.getTargetObject();
        FoodComponent fc = instanceResult.findFoodComponent("Serwatka płynna");
        NutritionComponent founded = fc.getNutritionTable().findByName("tłuszcz").get(0);
        Float nutrValue = founded.getAmount();
        assertEquals(expResult, result);
        assertEquals((Integer)86, instanceResult.getFoodList().get(0).getNutritionTable().size()); // ilosc zaladowanych nutr
        assertEquals(831, instanceResult.getFoodList().size()); // ilosc zaladowanych potraw
        
        //!!! źle załadowane wartości 
        assertEquals(0.1, nutrValue, 0.001); // losowo wybrany element bezpośrednio z pliku CSV
    }

    /**
     * Test of saveData method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testSaveData() {
        System.out.println("saveData");
        FoodComponentCollection_CSVLoader instance = new FoodComponentCollection_CSVLoader();
        boolean expResult = false;
        boolean result = instance.saveData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // implement this method
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapping method, of class FoodComponentCollection_CSVLoader.
     */
    @Test
    public void testGetMapping() {
        System.out.println("getMapping");
        FoodComponentCollection_CSVLoader instance = new FoodComponentCollection_CSVLoader();
        TreeMap<String, Integer> result = instance.getMapping();
        assertEquals(3, result.size());
    }
    
}
