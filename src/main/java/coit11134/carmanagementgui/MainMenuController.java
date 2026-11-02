/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coit11134.carmanagementgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author lil
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnViewAll;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnSaveExit;
    @FXML
    private TextArea txtDisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addCarAction(ActionEvent event) {
        System.out.println("You clicked on Add new car!");
        // Switch to the add add car scene 
        App.changeScene(1); 
    }

    @FXML
    private void viewAllAction(ActionEvent event) {
        System.out.println("You clicked on View all cars");
        // display all records from the ArrayList 
        this.txtDisplay.setText(App.getDataHandler().getDisplayOutput());  
    }

    @FXML
    private void searchAction(ActionEvent event) {
        System.out.println("You clicked on Search Car");
         //Switch to the Search scene 
        App.changeScene(2);
    }

    @FXML
    private void saveExitAction(ActionEvent event) {
        System.out.println("You clicked on Save & Exit!");     
       
        App.getDataHandler().saveData(); // call SaveData() method then exit
     
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Close?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        }); 
    }
    
}
