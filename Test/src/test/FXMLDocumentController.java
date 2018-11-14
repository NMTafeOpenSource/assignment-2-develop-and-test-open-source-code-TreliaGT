/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.lang.String;
import java.time.LocalDate;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import static sun.management.Agent.error;
/**
 *
 * @author V244682
 */
public class FXMLDocumentController implements Initializable {
    
   
   public ArrayList<Vehicle> list = new ArrayList();
    @FXML
    private Button Back;
    @FXML
    private Button Add;
    @FXML
    private Button Details;
    @FXML
    private Pane Main;
    @FXML
    private Pane add;
    @FXML
    private TableView<Vehicle> TableView;
    @FXML
    private TableColumn<Vehicle, String> Manufactor;
    @FXML
    private TableColumn<Vehicle, String> Model;
    @FXML
    private TableColumn<Vehicle, Integer> MakeYear;
    @FXML
    private TableColumn<Vehicle,String> Registration;
    @FXML
    private TableColumn<Vehicle, Integer> Odometre;
    @FXML
    private TableColumn<Vehicle, Integer> Tank;
    @FXML
    private TextField ManufactorT;
    @FXML
    private TextField ModelT;
    @FXML
    private TextField MakeYearT;
    @FXML
    private TextField RegistrationT;
    @FXML
    private TextField OdometreT;
    @FXML
    private TextField TankCT;
    @FXML
    private TextField LastServiceT;
    @FXML
    private TextField ServiceT;
    @FXML
    private TextField LastServiceDateT;
    @FXML
    private Button AddB;
    @FXML
    private Button RentB;
    @FXML
    private Pane rentalP;
    @FXML
    private RadioButton km;
    @FXML
    private RadioButton day;
    @FXML
    private CheckBox RS;
    @FXML
    private TextField Days;
    @FXML
    private TextField Km;
    @FXML
    private DatePicker rentout;
    @FXML
    private DatePicker Collection;
    @FXML
    private TextField FuelE;
    @FXML
    private TextField CostF;
    @FXML
    private TextField LitresF;
    @FXML
    private TextField FileName;
    @FXML
    private TextField MadeCost;
    @FXML
    private Button Service;
    @FXML
    private TextField UpDateOdo;
    @FXML
    private TextField DateS;
    @FXML
    private Button close;
    @FXML
    private Pane ServiceP;
    @FXML
    private Pane moreDetailsP;
    @FXML
    private TextField CostOfFuel;
    @FXML
    private TextField LitresPurchase;
    @FXML
    private Button rentoutb;
    @FXML
    private CheckBox RendoutCheck;
    
     public ObservableList<Vehicle> Tasksdata;
    Service s = new Service();
    Rental R = new Rental();
    FuelPurchase fp = new FuelPurchase();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       add.setVisible(false);
       Main.setVisible(true);
        rentalP.setVisible(false);
        ServiceP.setVisible(false);
       getVehicles();
    }    

    @FXML
    private void Back_Click(ActionEvent event) {
          add.setVisible(false);
          Main.setVisible(true);
          rentalP.setVisible(false);
          ServiceP.setVisible(false);
          ServiceT.setDisable(false);
          moreDetailsP.setVisible(false);
            rentoutb.setVisible(true);
            reset();
    }

    @FXML
    private void Show_Add(ActionEvent event) {
            ServiceT.setDisable(true);
         add.setVisible(true);
       Main.setVisible(false);
        RentB.setVisible(false);
            AddB.setVisible(true);
            moreDetailsP.setVisible(false);
            rentoutb.setVisible(false);
    }

    @FXML
    private void Detail_Click(ActionEvent event) {
            add.setVisible(true);
            Main.setVisible(false);
            RentB.setVisible(true);
            AddB.setVisible(false);
              moreDetailsP.setVisible(true);
            print_Details();
    }
    
     @FXML //removes a vehicle from the list and txt file
    private void Delete_Click(ActionEvent event) {
        try{
        list.remove(TableView.getSelectionModel().getSelectedIndex());
     refresh();
        writerTxt();
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Please Click on what Vehicle You Wish To Delete");
        }
    }
    
      @FXML //collection vehicle button to collect car wont work if the car requires service
    private void rent_click(ActionEvent event) {
         ServiceP.setVisible(false);
         //if car needs service not about to rent
         if(RS.isSelected() == true){
              JOptionPane.showMessageDialog(null, "This car needs Service");
         }else{
             rentalP.setVisible(true);
         }
    }

    @FXML
    private void print_click(ActionEvent event) throws IOException  {
      updatingRent();
       
    }
    @FXML
    private void Service_Click(ActionEvent event) {
            ServiceP.setVisible(true);
              rentalP.setVisible(false);
    }

    @FXML
    private void UpdateS_Click(ActionEvent event) throws IOException {
        updatingService();
    }

    @FXML
    private void Close_Click(ActionEvent event) {
            ServiceP.setVisible(false);
          
            
    }
   
       @FXML
    private void Rent_out(ActionEvent event) { //collection vehicle button to collect car & update car details
         if(RS.isSelected() == true){
              JOptionPane.showMessageDialog(null, "This car needs Service");
         }else if (RendoutCheck.isSelected()){
            JOptionPane.showMessageDialog(null, "This car is Already Rented Out");
         }else{
              int i=  TableView.getSelectionModel().getSelectedIndex();
              list.set(i, new Vehicle(list.get(i).getManufacturer() , list.get(i).getModel() , list.get(i).getMakeYear() , list.get(i).getRegistrationNo()
                        , list.get(i).getOdometerReadingKm() , list.get(i).getTankCapacityL() , s.lastServiceOdometerKm , s.serviceCount
                        , s.lastServiceDate , false , list.get(i).fuelPurchase.getFuelEconomy() , list.get(i).getRevenuerecorded(), list.get(i).fuelPurchase.getFuel(), list.get(i).fuelPurchase.getCost(), true)); 
                JOptionPane.showMessageDialog(null, "This Vehicle is rented out");
                  writerTxt();
         }
    }
    
    /**
     * Get vehicles from reading the txt file
     */
    public void getVehicles(){
            
        try {
            Scanner inFile = new Scanner(new FileReader("src\\test\\Vehicle.txt")); //read txt file
      
            while (inFile.hasNextLine()){ //read each line adding the task to the table veiw
              
            String  manufacturer = inFile.next(); 
            String model = inFile.next();
            int makeYear =   Integer.parseInt(inFile.next()); 
            String RegistrationNo =  inFile.next(); 
           double OdometerReadingKm = Double.parseDouble(inFile.next());
            int TankCapacityL = Integer.parseInt(inFile.next());
            int LastService0 = Integer.parseInt(inFile.next());
            int ServiceCourt = Integer.parseInt(inFile.next());
            String Date = inFile.next();
              boolean RS = Boolean.parseBoolean(inFile.next());
            double C = Math.round(Double.parseDouble(inFile.next()));
            double litres = Math.round(Double.parseDouble(inFile.next()));
            double Cost = Math.round(Double.parseDouble(inFile.next()));
            boolean rent = Boolean.parseBoolean(inFile.next());
             double FE = Math.round(fp.getCalFuelEconomy(Cost, litres));
                
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo, OdometerReadingKm, TankCapacityL ,LastService0 ,ServiceCourt, Date , RS, FE, C, litres, Cost, rent));
              
            }
            
            
         refresh();
               
        } catch (FileNotFoundException ex) { //errors messages
          JOptionPane.showMessageDialog(null, "txt file not found. Or there is a space in the txt file which causes this program to not display the required Data");
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "There was a problem with loading the txt file into this page");
        }
     
    } 
/**
 * Add Vehicle then use another method to add vehicle to list then txt file
 * @param event 
 */
    @FXML 
    private void AddVehicles_Click(ActionEvent event) {
    
             String  manufacturer = ManufactorT.getText() ;
            String model = ModelT.getText();
            int makeYear =   Integer.parseInt(MakeYearT.getText()); 
            String RegistrationNo =  RegistrationT.getText(); 
            double OdometerReadingKm = Double.parseDouble(OdometreT.getText());
            int TankCapacityL = Integer.parseInt(TankCT.getText());
            int LastService0 = Integer.parseInt(LastServiceT.getText());
             s.lastServiceOdometerKm = LastService0;
            int ServiceCourt = s.getTotalScheduledServices();
            String Date = LastServiceDateT.getText();
            boolean RService = RS.isSelected();
            double FE = Double.parseDouble(FuelE.getText());
            double C = Double.parseDouble(MadeCost.getText());
            double litres = 0.0;
            double Cost = 0.0;
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo, OdometerReadingKm, TankCapacityL ,LastService0 ,ServiceCourt, Date, RService, FE , C, litres, Cost, false));
        
         refresh();
          writerTxt();
    }
    /**
     * Refreshes the table
     */
    public void refresh(){
                    ObservableList<Vehicle> Tasksdata = FXCollections.observableArrayList(list);
          Manufactor.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
       Model.setCellValueFactory(new PropertyValueFactory<>("model"));
       MakeYear.setCellValueFactory(new PropertyValueFactory<>("makeYear"));
       Registration.setCellValueFactory(new PropertyValueFactory<>("RegistrationNo"));
       Odometre.setCellValueFactory(new PropertyValueFactory<>("OdometerReadingKm"));
       Tank.setCellValueFactory(new PropertyValueFactory<>("TankCapacityL"));
        TableView.setItems(Tasksdata);
    }
    
    
    
    
    
/**
 * write in new information to txt file
 */
    public void writerTxt() {
      
       try (PrintWriter outfile = new PrintWriter("src\\test\\Vehicle.txt")) {
            int i = 0;
      while ( i != list.size()) {
               outfile.print(list.get(i).getManufacturer() + " " + list.get(i).getModel() + " " + list.get(i).getMakeYear() + " " + list.get(i).getRegistrationNo()
                       + " " + Math.round(list.get(i).getOdometerReadingKm()) + " " + list.get(i).getTankCapacityL() + " "+ list.get(i).s.lastServiceOdometerKm + " " + list.get(i).s.serviceCount
                       + " " + list.get(i).s.lastServiceDate + " " + list.get(i).s.RequiredService + " " + Math.round(list.get(i).fuelPurchase.getFuelEconomy()) + " " + 
                       Math.round(list.get(i).getRevenuerecorded()) + Math.round(list.get(i).fuelPurchase.getFuel()) +
                       " " +  Math.round(list.get(i).fuelPurchase.getCost()) + " " + list.get(i).R.getRentout());
                   i++;
                   if(i == list.size()){
                       
                   }else{
                       outfile.println();
                   }
       }
       outfile.close();
       }catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "txt file not found or error with writin");
        }

    }

  
    /**
     * show details on details page
     */
    public void print_Details(){
        try{
     int p =  TableView.getSelectionModel().getSelectedIndex();
          ManufactorT.setText(list.get(p).getManufacturer());
             ModelT.setText(list.get(p).getModel());
            MakeYearT.setText(Integer.toString(list.get(p).getMakeYear()));  
             RegistrationT.setText(list.get(p).getRegistrationNo()); 
             OdometreT.setText(Double.toString(list.get(p).getOdometerReadingKm()));
            TankCT.setText(Integer.toString(list.get(p).getTankCapacityL()));
             LastServiceT.setText(Integer.toString(list.get(p).s.lastServiceOdometerKm));
             ServiceT.setText(Integer.toString(list.get(p).s.serviceCount));
             LastServiceDateT.setText(list.get(p).s.lastServiceDate);
             RS.setSelected(list.get(p).s.RequiredService);
            FuelE.setText(Double.toString(list.get(p).fuelPurchase.getFuelEconomy()));
            MadeCost.setText(Double.toString(list.get(p).getRevenuerecorded()));
            CostOfFuel.setText(Double.toString(list.get(p).fuelPurchase.getCost()));
            LitresPurchase.setText(Double.toString(list.get(p).fuelPurchase.getFuel()));
              RendoutCheck.setSelected(list.get(p).R.getRentout());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle to view their Details");
        }
                    
    }
    /**
     * Reset all text boxes
     */
    public void reset(){
         ManufactorT.setText("");
             ModelT.setText("");
            MakeYearT.setText("");  
             RegistrationT.setText(""); 
             OdometreT.setText("");
            TankCT.setText("");
             LastServiceT.setText("");
             ServiceT.setText("");
             LastServiceDateT.setText("");
             RS.setSelected(false);
             Km.setText("");
             Days.setText("");
             rentout.setValue(null);
             Collection.setValue(null);
             day.setSelected(false);
             km.setSelected(false);
             FuelE.setText("");
             CostF.setText("");
             LitresF.setText("");
             UpDateOdo.setText("");
             DateS.setText("");
             RendoutCheck.setSelected(false);
    }
    /**
     * Get rental Costs
     * @return 
     */
    public double rentalCost(){
        
        if( day.isSelected()== true){
            R.setAmount(Double.parseDouble(Days.getText()));
            R.getRentalCostDays();
              return R.getAmount();
        }
        else if (km.isSelected() == true){
            R.setAmount(Double.parseDouble(Km.getText()));
            R.getRentalCostKm();
              return R.getAmount();
        }else{
             JOptionPane.showMessageDialog(null, "Select Payment Method");
                  return 0;
        }
    }
    
    /**
     * Print out information on rented out car
     * @throws IOException 
     */
    public void rentalPrint() throws IOException{
  int i =  TableView.getSelectionModel().getSelectedIndex();
        File file = new File("src\\test\\" + FileName.getText() + ".txt");
  
        //Create the file
        if (file.createNewFile())
        {
         JOptionPane.showMessageDialog(null, "File is created!");
        } else {
            JOptionPane.showMessageDialog(null, "File already exists.");
    }
 
        //Write Content
        PrintWriter writer = new PrintWriter(file);
        writer.println(("Vehicle: " + list.get(i).getManufacturer() + " " + list.get(i).getModel() + " " + list.get(i).getMakeYear() + " Registration: " + list.get(i).getRegistrationNo()));
           writer.println("Odometer Reading: " + list.get(i).getOdometerReadingKm()); 
            writer.println ("TankCapacity: " + list.get(i).getTankCapacityL() + "L" );
               writer.println("ServiceCount: " + list.get(i).s.serviceCount );
                 writer.println("LastServicedDate: " + list.get(i).s.lastServiceDate );
        writer.println("Between: " + rentout.getValue().toString() + " - " + Collection.getValue().toString());
         writer.println("Cost: $" + rentalCost());
      writer.println("FuelEconomy " + Double.toString(list.get(i).fuelPurchase.getFuelEconomy()));
        writer.close();
        
       
    }
    
    /**
     * Updating information after printing informations
     */
    public void updatingRent() throws IOException{
          int i =  TableView.getSelectionModel().getSelectedIndex();
             //Get new OdometerReading
         Journey J = new Journey();
      J.setKilometers(list.get(i).getOdometerReadingKm());
      J.addKilometers(Double.parseDouble(Km.getText()));
      
      //new fuel Fuel Economy
      fp.setCost(list.get(i).fuelPurchase.getCost());
      fp.setFuel(list.get(i).fuelPurchase.getCost());
    fp.purchaseFuel(Double.parseDouble(CostF.getText()), Double.parseDouble(LitresF.getText()));
    double totalFuelE = fp.getCalFuelEconomy(fp.getCost(), fp.getFuel());
      
      //new Revenuerecorded
      double Revenuerecorded = list.get(i).getRevenuerecorded() + rentalCost();
      
       list.set(i, new Vehicle(list.get(i).getManufacturer() , list.get(i).getModel() , list.get(i).getMakeYear() , list.get(i).getRegistrationNo()
                        , J.getKilometers() , list.get(i).getTankCapacityL() , list.get(i).s.lastServiceOdometerKm , list.get(i).s.serviceCount
                        , list.get(i).s.lastServiceDate ,  s.RequiredService(J.getKilometers() , list.get(i).s.serviceCount) , fp.getFuelEconomy() , Revenuerecorded
                         ,fp.getFuel(), fp.getCost(), false)); 
       rentalPrint();
        writerTxt();
    //rewrite file to update the data
    
    }
    
    /**
     * Updating service information
     */
    public void updatingService() throws IOException{
         int i =  TableView.getSelectionModel().getSelectedIndex();
         
         //service
          s.serviceCount = list.get(i).s.serviceCount;
         s.recordService(Integer.parseInt(UpDateOdo.getText()), DateS.getText());
         
      list.set(i, new Vehicle(list.get(i).getManufacturer() , list.get(i).getModel() , list.get(i).getMakeYear() , list.get(i).getRegistrationNo()
                        , list.get(i).getOdometerReadingKm() , list.get(i).getTankCapacityL() , s.lastServiceOdometerKm , s.serviceCount
                        , s.lastServiceDate , false , list.get(i).fuelPurchase.getFuelEconomy() , list.get(i).getRevenuerecorded(), list.get(i).fuelPurchase.getFuel(), list.get(i).fuelPurchase.getCost(), false)); 
 rentalPrint();
  writerTxt();
    }

 

  
    
    
}


