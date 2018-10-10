/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startervehicle;

import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.ArrayList;
/**
 *
 * @author V244682
 */
public class FXMLDocumentController implements Initializable {
 
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    

    @FXML private TableView<View> tableView;
    
    
    @FXML
    protected void addPerson(ActionEvent event) {
        AllVehicleInformation information = new AllVehicleInformation();
        ObservableList<View> cars = FXCollections.observableArrayList(information.VehiclesAdd());
        tableView.setItems(cars);
    }
    @FXML
    private void AddButton(ActionEvent event) {
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        
    }

    @FXML
    private void ViewDetail(ActionEvent event) {
        
    }
    
}
