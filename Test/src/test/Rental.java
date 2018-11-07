/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Trelia
 */
public class Rental {
    private final double Days = 100;
    private final double Km = 1;
    private double Amount;
    private double Total;
    
    //setters & getters
  public double getAmount(){
        return this.Amount;
    }
    public void setAmount(double fAmount){
        this.Amount = fAmount;
    }
    
    //rental for days
    public double getRentalCostDays(){
        return Amount * Days;
    }
    //rental for per km
     public  double getRentalCostKm(){
        return Amount * Km;
    }
     //total Revenue Recorded
     public double getTotal(double made){
        return made += Amount;
     }
}
