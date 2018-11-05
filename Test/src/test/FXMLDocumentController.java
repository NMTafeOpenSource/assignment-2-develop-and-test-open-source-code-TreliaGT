/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private Text WarningL;
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
    
  public ObservableList<Vehicle> Tasksdata;
  Service s = new Service();
  Rental R = new Rental();
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
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       add.setVisible(false);
       Main.setVisible(true);
        WarningL.setVisible(false); 
        rentalP.setVisible(false);
       getVehicles();
    }    

    @FXML
    private void Back_Click(ActionEvent event) {
          add.setVisible(false);
          Main.setVisible(true);
          rentalP.setVisible(false);
            reset();
    }

    @FXML
    private void Show_Add(ActionEvent event) {
         add.setVisible(true);
       Main.setVisible(false);
        RentB.setVisible(false);
            AddB.setVisible(true);
    }

    @FXML
    private void Detail_Click(ActionEvent event) {
            add.setVisible(true);
            Main.setVisible(false);
            RentB.setVisible(true);
            AddB.setVisible(false);
            print_Details();
    }
    
     @FXML
    private void Delete_Click(ActionEvent event) {
        try{
        list.remove(TableView.getSelectionModel().getSelectedIndex());
           Manufactor.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
       Model.setCellValueFactory(new PropertyValueFactory<>("model"));
       MakeYear.setCellValueFactory(new PropertyValueFactory<>("makeYear"));
       Registration.setCellValueFactory(new PropertyValueFactory<>("RegistrationNo"));
       Odometre.setCellValueFactory(new PropertyValueFactory<>("OdometerReadingKm"));
       Tank.setCellValueFactory(new PropertyValueFactory<>("TankCapacityL"));
        TableView.setItems(Tasksdata);
        writerTxt();
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Please Click on what Vehicle You Wish To Delete");
           
        }
    }
    
      @FXML 
    private void rent_click(ActionEvent event) {//if car needs service
         //if car needs service not about to rent
         if(RS.isSelected() == true){
              JOptionPane.showMessageDialog(null, "This car needs Service");
         }else{
             rentalP.setVisible(true);
         }
    }

    @FXML
    private void print_click(ActionEvent event) {
        rentalCost();
    }
    
    /**
     * Get vehicles from txt file
     */
    public void getVehicles(){
            
        try {
            Scanner inFile = new Scanner(new FileReader("src\\test\\Vehicle.txt")); //read txt file
          
            while (inFile.hasNextLine()){ //read each line adding the task to the table veiw
            String  manufacturer = inFile.next();
            String model = inFile.next();
            int makeYear =   Integer.parseInt(inFile.next()); 
            String RegistrationNo =  inFile.next(); 
            int OdometerReadingKm = Integer.parseInt(inFile.next());
            int TankCapacityL = Integer.parseInt(inFile.next());
            int LastService0 = Integer.parseInt(inFile.next());
            int ServiceCourt = Integer.parseInt(inFile.next());
            String Date = inFile.next();
              boolean RS = inFile.nextBoolean();
            
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo, OdometerReadingKm, TankCapacityL ,LastService0 ,ServiceCourt, Date , RS));
            }
            ObservableList<Vehicle> Tasksdata = FXCollections.observableArrayList(list);
            Manufactor.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
            Model.setCellValueFactory(new PropertyValueFactory<>("model"));
            MakeYear.setCellValueFactory(new PropertyValueFactory<>("makeYear"));
             Registration.setCellValueFactory(new PropertyValueFactory<>("RegistrationNo"));
             Odometre.setCellValueFactory(new PropertyValueFactory<>("OdometerReadingKm"));
             Tank.setCellValueFactory(new PropertyValueFactory<>("TankCapacityL"));
                TableView.setItems(Tasksdata);
        } catch (FileNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "txt file not found or there is a space in the txt file");
        }
     
    } 
/**
 * Add Vehicle then use another method to add vehicle to txt file
 * @param event 
 */
    @FXML 
    private void AddVehicles_Click(ActionEvent event) {
             String  manufacturer = ManufactorT.getText() ;
            String model = ModelT.getText();
            int makeYear =   Integer.parseInt(MakeYearT.getText()); 
            String RegistrationNo =  RegistrationT.getText(); 
            int OdometerReadingKm = Integer.parseInt(OdometreT.getText());
            int TankCapacityL = Integer.parseInt(TankCT.getText());
            int LastService0 = Integer.parseInt(LastServiceT.getText());
            int ServiceCourt = Integer.parseInt(ServiceT.getText());
            String Date = LastServiceDateT.getText();
            boolean RService = RS.isSelected();
            
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo, OdometerReadingKm, TankCapacityL ,LastService0 ,ServiceCourt, Date, RService));
        
            ObservableList<Vehicle> Tasksdata = FXCollections.observableArrayList(list);
          Manufactor.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
       Model.setCellValueFactory(new PropertyValueFactory<>("model"));
       MakeYear.setCellValueFactory(new PropertyValueFactory<>("makeYear"));
       Registration.setCellValueFactory(new PropertyValueFactory<>("RegistrationNo"));
       Odometre.setCellValueFactory(new PropertyValueFactory<>("OdometerReadingKm"));
       Tank.setCellValueFactory(new PropertyValueFactory<>("TankCapacityL"));
        TableView.setItems(Tasksdata);
       
        writerTxt();
    }
/**
 * write in new information to txt file
 */
    public void writerTxt() {
       try (PrintWriter outfile = new PrintWriter("src\\test\\Vehicle.txt")) {

       for (int i = 0; i < list.size(); i++) {
        
         outfile.println(list.get(i).getManufacturer() + " " + list.get(i).getModel() + " " + list.get(i).getMakeYear() + " " + list.get(i).getRegistrationNo()
                        + " " + list.get(i).getOdometerReadingKm() + " " + list.get(i).getTankCapacityL() + " "+ list.get(i).s.lastServiceOdometerKm + " " + list.get(i).s.serviceCount
                        + " " + list.get(i).s.lastServiceDate + " " + list.get(i).s.RequiredService);
                        
		}
          
           getVehicles();
       }catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "txt file not found or error with writin");
        }

    }

  
    /**
     * show details on details page
     */
    public void print_Details(){
     int p =  TableView.getSelectionModel().getSelectedIndex();
          ManufactorT.setText(list.get(p).getManufacturer());
             ModelT.setText(list.get(p).getModel());
            MakeYearT.setText(Integer.toString(list.get(p).getMakeYear()));  
             RegistrationT.setText(list.get(p).getRegistrationNo()); 
             OdometreT.setText(Integer.toString(list.get(p).getOdometerReadingKm()));
            TankCT.setText(Integer.toString(list.get(p).getTankCapacityL()));
             LastServiceT.setText(Integer.toString(list.get(p).s.lastServiceOdometerKm));
             ServiceT.setText(Integer.toString(list.get(p).s.serviceCount));
             LastServiceDateT.setText(list.get(p).s.lastServiceDate);
             RS.setSelected(list.get(p).s.RequiredService);
        
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
    }
    /**
     * Get rental Costs
     */
    public void rentalCost(){
        
        if( day.isSelected()== true){
            R.setAmount(Integer.parseInt(Days.getText()));
            R.getRentalCostDays();
        }
        else if (km.isSelected() == true){
            R.setAmount(Integer.parseInt(Km.getText()));
            R.getRentalCostKm();
        }else{
             JOptionPane.showMessageDialog(null, "Select Payment Method");
        }
    }
}


