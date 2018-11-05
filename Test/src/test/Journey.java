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
public class Journey {
    private double kilometers;

	/**
	 * Class constructor
	 */
	public Journey() {
		this.kilometers = 0;
	}

	/** 
	 * Appends the distance parameter to {@link #kilometers}
	 * @param kilometers the distance traveled 
	 */
	public void addKilometers(double kilometers) {
		this.kilometers += kilometers;
	}

        public void setKilometers(double Km){
            this.kilometers = Km;
        }


	/**
	 * Getter method for total Kilometers traveled in this journey.
	 * @return {@link #kilometers}
	 */
	public double getKilometers() {
		return kilometers;
	}
}
