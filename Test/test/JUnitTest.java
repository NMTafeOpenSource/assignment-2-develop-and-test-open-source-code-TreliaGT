/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.FuelPurchase;

/**
 *
 * @author V244682
 */
public class JUnitTest {
   
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
   
     @Test
     public void getCalFuelEconomy() {
       double expected = 10.0;
       double actual = FuelPurchase.getCalFuelEconomy(45.0, 5.0);
       assertEquals(expected, actual);
     }
     
        
     
     
     
     
}
