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
     public void getCalFuelEconomy() {
       double expected = 9.0;
       
       double actual = FuelPurchase.getCalFuelEconomy(45.0, 5.0);
       assertEquals(expected, actual, 9.0);
     }
     
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
     
         
     
}
