/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startervehicle;

/**
 * Set the vehicle details
 * @author V244682
 */
public class Vehicle {
    
        private String	manufacturer;
	private String	model;
	private int	makeYear;
        public String  Vehicle;
        // TODO add Registration Number 
        // TODO add variable for OdometerReading (in KM), 
        // TODO add a vehicle 
               

	/**
	 * Class constructor specifying name of make (manufacturer), model and year
	 * of make.
	 * @param manufacturer
	 * @param model
	 * @param makeYear
	 */
	Vehicle(String manufacturer, String model, int makeYear) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.makeYear = makeYear;
		
	}

        // TODO Add missing getter and setter methods
        
	/**
	 * Prints details for { Vehicle details}
	 */
	public void printVehicle() {
		Vehicle = (makeYear + " " + manufacturer + " " + model);		
                // TODO Display additional information about this vehicle
	}

     
}
