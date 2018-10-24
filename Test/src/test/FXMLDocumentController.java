/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
   
    private ListView<Vehicle> Tableview;
    @FXML
    private Button Details;
    @FXML
    private Pane Main;
    @FXML
    private Pane add;
    @FXML
    private Text WarningL;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       add.setVisible(false);
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
            
            
           list.add(new Vehicle(manufacturer, model, makeYear, RegistrationNo,OdometerReadingKm,TankCapacityL));
            }
         
        } catch (FileNotFoundException ex) {
             WarningL.setVisible(true);
            WarningL.setText("txt file not found");
        }
        ObservableList<Vehicle> Tasksdata = FXCollections.observableArrayList(list);
        Tableview.setItems(Tasksdata);
    } 

}


