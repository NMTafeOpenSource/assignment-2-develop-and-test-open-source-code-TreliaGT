/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startervehicle;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author V244682
 */
public class View {
       private final SimpleStringProperty Vehicle = new SimpleStringProperty("");
       private final SimpleStringProperty Registration = new SimpleStringProperty("");
       private final SimpleStringProperty Totalkilometrestravelled = new SimpleStringProperty("");
       private final SimpleStringProperty Totalservices = new SimpleStringProperty("");
       private final SimpleStringProperty KMSinceservice = new SimpleStringProperty("");
       private final SimpleStringProperty Revenuerecorded = new SimpleStringProperty("");
       private final SimpleStringProperty requiresService = new SimpleStringProperty("");
       
       
     public View(){
         this("", "", "", "", "", "", "");
     }
     //Setter and getters
     public View(String vehicle, String registration, String totalkm, String totalS, String hmSS, String RR, String RS){
      setVehicle(vehicle);
      setRegistration(registration);
      setTotalkm(totalkm);
      setTotalS(totalS);
      setHmSS(hmSS);
      setRr(RR);
      setRS(RS);
      }

    View(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVehicle() {
        return Vehicle.get();
    }
     
     public void setVehicle(String fvehicle) {
        Vehicle.set(fvehicle);
    }

    public String  getRegistration() {
        return Registration.get();
    }
     
    public void setRegistration(String fregistration) {
        Registration.set(fregistration);
    }

     public String getTotalkm() {
        return Totalkilometrestravelled.get();
    }
     
    public void setTotalkm(String ftotalkm) {
        Totalkilometrestravelled.set(ftotalkm);
    }

    public String getTotalS() {
        return Totalservices.get();
    }
    
     public void setTotalS(String ftotalS) {
        Totalservices.set(ftotalS);
    }

       public String getHmSS() {
        return KMSinceservice.get();
    }
       
     public void setHmSS(String fhmSS) {
        KMSinceservice.set(fhmSS);
    }

    public String getRr() {
        return Revenuerecorded.get();
    }
    
      public void setRr(String fRR) {
       Revenuerecorded.set(fRR);
    }

      
    public String getRS() {
        return requiresService.get();
    }
    
    public void setRS(String fRS) {
    requiresService.set(fRS);
    }
}
