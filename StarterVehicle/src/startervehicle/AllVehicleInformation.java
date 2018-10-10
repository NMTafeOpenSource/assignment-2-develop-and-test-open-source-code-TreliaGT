/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startervehicle;

import java.util.ArrayList;

/**
 *
 * @author V244682
 */
public class AllVehicleInformation {
     private final ArrayList<View> list = new ArrayList<>(); //Arraylist for thr tableview
    private String Registration;                            // ALL Strings in the array
     private String Totalkilometrestravelled;
    private String Totalservices;
     private String  KMSinceservice;
     private String Revenuerecorded;
     private String  requiresService;
     private String Vehicle;

 
    public ArrayList VehiclesAdd(){
   
    list.add(new View(Vehicle, 
            Registration, 
            Totalkilometrestravelled, 
            Totalservices,
            KMSinceservice,
            Revenuerecorded,
            requiresService
           ));
    return list;
    }  
    
    
    
    
}
