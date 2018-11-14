/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import test.FuelPurchase;
import test.Service;

/**
 *
 * @author V244682
 */
public class JUnitTest {
   
    
    public JUnitTest() {
    
    }
   
    // The methods must be annotated with annotation @Test. For example:
     
        @Test
         public void trueRequiredService(){
            boolean expected = true;
            boolean actual = Service.RequiredService(15000.0, 1);
               assertEquals(expected, actual);
     }
    
          @Test
         public void falseRequiredService2(){
            boolean expected = false;
            boolean actual = Service.RequiredService(10000.0, 1);
               assertEquals(expected, actual);
     } 
       @Test
       public void getCalFuelEconomy1(){
           double expected = 0.8;
          double actual = FuelPurchase.getCalFuelEconomy(4, 5);
                assertEquals(expected, actual, 0.8);   
       }
       
       @Test 
       public void getCalFuelEconomy2(){
          double expected = 9;
          double actual = FuelPurchase.getCalFuelEconomy(18, 2);
                assertEquals(expected, actual, 9);   
       }
         
}
