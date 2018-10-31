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
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       add.setVisible(false);
       Main.setVisible(true);
        WarningL.setVisible(false); 
       getVehicles();
    }    

    @FXML
    private void Back_Click(ActionEvent event) {
          add.setVisible(false);
          Main.setVisible(true);
    }

    @FXML
    private void Show_Add(ActionEvent event) {
        add.setVisible(true);
        Main.setVisible(false);
    }

    @FXML
    private void Detail_Click(ActionEvent event) {
        
    }
    
    //get vehicles from txt file
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
            
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo, OdometerReadingKm, TankCapacityL ,LastService0 ,ServiceCourt, Date ));
            }
         
        } catch (FileNotFoundException ex) {
             WarningL.setVisible(true);
             WarningL.setText("txt file not found");
        }
        ObservableList<Vehicle> Tasksdata = FXCollections.observableArrayList(list);
          Manufactor.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
       Model.setCellValueFactory(new PropertyValueFactory<>("model"));
       MakeYear.setCellValueFactory(new PropertyValueFactory<>("makeYear"));
       Registration.setCellValueFactory(new PropertyValueFactory<>("RegistrationNo"));
       Odometre.setCellValueFactory(new PropertyValueFactory<>("OdometerReadingKm"));
       Tank.setCellValueFactory(new PropertyValueFactory<>("TankCapacityL"));
        TableView.setItems(Tasksdata);
    } 

    @FXML //Add vehicles to tableview
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
            
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo, OdometerReadingKm, TankCapacityL ,LastService0 ,ServiceCourt, Date ));
        
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

    public void writerTxt() {
       try (PrintWriter outfile = new PrintWriter("src\\test\\Vehicle.txt")) {

       for (int i = 0; i < list.size(); i++) {
        
         outfile.println(list.get(i).getManufacturer() + " " + list.get(i).getModel() + " " + list.get(i).getMakeYear() + " " + list.get(i).getRegistrationNo()
                        + " " + list.get(i).getOdometerReadingKm() + " " + list.get(i).getTankCapacityL() + " "+ list.get(i).s.lastServiceOdometerKm + " " + list.get(i).s.serviceCount
                        + " " + list.get(i).s.lastServiceDate);
                        
		}
          
           getVehicles();
       }catch (FileNotFoundException ex) {
             WarningL.setVisible(true);
             WarningL.setText("txt file not found or error with writing");
        }

    }
}


