package coit11134.carmanagementgui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SearchCarController {

    @FXML private TextField txtSearchID;
    @FXML private TextArea txtResult;

    @FXML
    private void searchCarAction() {
        try {
            int id = Integer.parseInt(txtSearchID.getText().trim());
            Car car = App.getDataHandler().findCarByID(id);
            if (car != null) {
                txtResult.setText(car.toString());
            } else {
                txtResult.setText("Car not found.");
            }
        } catch (Exception e) {
            txtResult.setText("Invalid input.");
        }
    }

    @FXML
    private void exitAction() {
        App.changeScene(0);
    }
}