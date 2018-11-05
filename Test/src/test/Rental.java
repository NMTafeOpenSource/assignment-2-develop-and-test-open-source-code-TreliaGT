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
    private final int Days = 100;
    private final int Km = 1;
    private int Amount;
    private int Total;
    
  public int getAmount(){
        return this.Amount;
    }
    public void setAmount(int fAmount){
        this.Amount = fAmount;
    }
    
    public int getRentalCostDays(){
        return Amount * Days;
    }
    
     public int getRentalCostKm(){
        return Amount * Km;
    }
}
