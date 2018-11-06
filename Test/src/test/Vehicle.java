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
public final class Vehicle {
     private String	manufacturer;
	private String	model;
	private int	makeYear;
        private String RegistrationNo; 
       private double OdometerReadingKm; 
        private int TankCapacityL;
        private double Revenuerecorded;
               
     public FuelPurchase fuelPurchase = new FuelPurchase();
     public Service s = new Service();
     
     
	/**
	 * Class constructor specifying name of make (manufacturer), model and year
	 * of make.
	 * @param manufacturer
	 * @param model
	 * @param makeYear
         * @param RegistrationNo
         * @param LastService0
         * @param Date
         * @param ServiceCourt
         * @param RS
         * @param FuelE
	 */
	public Vehicle(String manufacturer, String model, int makeYear, String RegistrationNo,double OdometerReadingKm, int TankCapacityL
        ,int LastService0, int ServiceCourt, String Date, boolean RS, double FuelE, double Costmade) {
		setmanufacturer(manufacturer);
		setModel(model);
		setMakeYear(makeYear);
                setRegistrationNo(RegistrationNo);
                setOdometerReadingKm(OdometerReadingKm);
                setTankCapacityL(TankCapacityL);
                s.recordedService(LastService0,Date, ServiceCourt);
                s.RequiredService = RS;
                fuelPurchase.setFuelEconomy(FuelE);
                setRevenuerecorded(Costmade);
	}
        
        
        
//Setter and getters
    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setmanufacturer(String fmanufacturer) {
        this.manufacturer = fmanufacturer;
    }

    public String getModel(){
        return this.model;
    }
    public void setModel(String fModel){
        this.model = fModel;
    }
    public int getMakeYear(){
        return this.makeYear;
    }
    public void setMakeYear(int fmakeyear){
        this.makeYear = fmakeyear;
    }
    
     public String getRegistrationNo(){
        return this.RegistrationNo;
    }
    public void setRegistrationNo(String fRegistrationNo){
        this.RegistrationNo = fRegistrationNo;
    }
    
      public double getOdometerReadingKm(){
        return this.OdometerReadingKm;
    }
   public void setOdometerReadingKm(double fOdometerReadingKm){
        this.OdometerReadingKm = fOdometerReadingKm;
    }
  
     public int getTankCapacityL(){
        return this.TankCapacityL;
    }
    public void setTankCapacityL(int fTankCapacityL){
        this.TankCapacityL = fTankCapacityL;
    }
       public double getRevenuerecorded(){
        return this.Revenuerecorded;
    }
    public void setRevenuerecorded(double fRevenuerecorded){
        this.Revenuerecorded = fRevenuerecorded;
    }
        
	/**
	 * Prints details for {@link Vehicle}
	 */
	public void printDetails() {
		System.out.println("Vehicle: " + makeYear + " " + manufacturer + " " + model);		
                // TODO Display additional information about this vehicle
	}

        
        //  addKilometers method which takes a parameter for distance travelled 
         // and adds it to the odometer reading. 
        public void addKilometers(int kilometersTravel){
            this.OdometerReadingKm =+ kilometersTravel;
        }
        
       

        // adds fuel to the car
        public void addFuel(double litres, double price){            
            fuelPurchase.purchaseFuel(litres, price);
        }   
        
      
       
}

