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
         * @param RS
         * @param SC
         * @param FuelE
         * @param Costmade
	 */
	public Vehicle(String manufacturer, String model, int makeYear, String RegistrationNo,double OdometerReadingKm, int TankCapacityL
        ,int LastService0, int SC , String Date, boolean RS, double FuelE, double Costmade, double litres, double cost) {
		setmanufacturer(manufacturer);
		setModel(model);
		setMakeYear(makeYear);
                setRegistrationNo(RegistrationNo);
                setOdometerReadingKm(OdometerReadingKm);
                setTankCapacityL(TankCapacityL);
                s.recordService(LastService0,Date);
                s.serviceCount = SC;
                s.RequiredService = RS;
                fuelPurchase.setFuelEconomy(FuelE);
                setRevenuerecorded(Costmade);
                fuelPurchase.setFuel(litres);
                fuelPurchase.setCost(cost);
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
}

