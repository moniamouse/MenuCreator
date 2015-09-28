/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author oem
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({kotys.monika.menucreator.classes.FoodComponentTest.class, kotys.monika.menucreator.classes.NutritionComponentTest.class, kotys.monika.menucreator.classes.MealComponentTest.class, kotys.monika.menucreator.classes.MealTest.class})
public class AllTestsRun {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
//    public void run(){
//        Suite.emptySuite();
        
//    }
    
}
