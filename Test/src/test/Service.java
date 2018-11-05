/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author V244682
 */
public class Service {
   // Constant to indicate that the vehicle needs to be serviced every 10,000km
    public static final int SERVICE_KILOMETER_LIMIT = 10000;
    
   public int lastServiceOdometerKm=0;
    public int serviceCount=0;
   public String lastServiceDate = "Unknown";
   public boolean RequiredService = false;
    
    // return the last service
    public int getLastServiceOdometerKm()
    {
        return this.lastServiceOdometerKm;
    }    
    
    /**
     * The function recordService expects the total distance traveled by the car, 
     * saves it and increase serviceCount.
     * @param distance 
     * @param date 
     */
    public void recordedService(int distance, String date, int count)
    {
        this.lastServiceOdometerKm = distance;
        this.serviceCount= count;
        this.lastServiceDate = date;
    }
    
      public void recordService(int distance, String date)
    {
        this.lastServiceOdometerKm = distance;
        this.serviceCount ++;
        this.lastServiceDate = date;
    }
    
    
    // return how many services the car has had
    public int getServiceCount()
    {
        return this.serviceCount;
    }
    
    public String getLastServiceDate(){
        return this.lastServiceDate;
    }
    
      public int lastServiceOdometerKm()
    {
        return this.lastServiceOdometerKm;
    }
    
    /**
     * Calculates the total services by dividing kilometers by
     * {@link #SERVICE_KILOMETER_LIMIT} and floors the value. 
     * 
     * @return the number of services needed per SERVICE_KILOMETER_LIMIT
     */
    public int getTotalScheduledServices() {
            return (int) Math.floor(lastServiceOdometerKm / SERVICE_KILOMETER_LIMIT);
    } 
}
