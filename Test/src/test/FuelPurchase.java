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
public class FuelPurchase {
        private double  fuelEconomy = 0;
        private double litres = 0;
        private double cost = 0;

	public double getFuelEconomy() {
		return fuelEconomy;
	}
        
        public void setFuelEconomy(double fuelEconomy) {
		this.fuelEconomy = fuelEconomy;
	}
       
        
        public void setFuel(double Ffuel){
             this.litres = Ffuel;
         }
         
        public double getFuel(){
            return this.litres;
        }

	public void setCost(double fCost){
        this.cost = fCost;
        }
//        
        public double getCost(){
            return this.cost;
        }
        
        public void purchaseFuel(double amount,double price){
            this.litres += amount;
            this.cost += price;
        }
        
         
    public static double getCalFuelEconomy(double cost, double litres){
            return (cost / litres);
        }
}
