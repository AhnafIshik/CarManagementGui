package coit11134.carmanagementgui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddCarController {

    @FXML private TextField txtCarID, txtBrand, txtModel, txtYear, txtPrice;
    @FXML private RadioButton rbNew, rbUsed;
    @FXML private ToggleGroup category;
    @FXML private Button btnCancel, btnSubmit, btnReset;

    @FXML
    private void cancelAction() {
        App.changeScene(0);
    }

    @FXML
    private void resetAction() {
        txtCarID.clear();
        txtBrand.clear();
        txtModel.clear();
        txtYear.clear();
        txtPrice.clear();
        category.selectToggle(null);
    }

    @FXML
private void submitAction() {
    try {
        int id = Integer.parseInt(txtCarID.getText().trim());
        if (id < 100 || id > 999) {
            showAlert("Invalid ID", "Car ID must be a 3-digit number.");
            return;
        }

        if (App.getDataHandler().idExists(id)) {
            showAlert("Duplicate ID", "Car ID already exists.");
            return;
        }

        String brand = txtBrand.getText().trim();
        String model = txtModel.getText().trim();

        if (brand.isEmpty() || model.isEmpty()) {
            showAlert("Missing Fields", "Brand and Model cannot be empty.");
            return;
        }

        int year = Integer.parseInt(txtYear.getText().trim());
        int currentYear = java.time.Year.now().getValue();
        if (year < 1000 || year > currentYear) {
            showAlert("Invalid Year", "Year must be a 4-digit number and not in the future.");
            return;
        }

        double price = Double.parseDouble(txtPrice.getText().trim());
        if (price <= 0) {
            showAlert("Invalid Price", "Price must be greater than 0.");
            return;
        }

        String categoryStr = rbNew.isSelected() ? "New" : rbUsed.isSelected() ? "Used" : "";
        if (categoryStr.isEmpty()) {
            showAlert("Category Missing", "Please select a car category.");
            return;
        }

        Car newCar = new Car(id, brand, model, year, price, categoryStr);
        App.getDataHandler().addCar(newCar);
        showAlert("Success", "Car added successfully.");
        resetAction();

    } catch (NumberFormatException e) {
        showAlert("Input Error", "Please enter valid numbers for ID, Year, and Price.");
    } catch (Exception e) {
        showAlert("Unexpected Error", e.getMessage());
    }
}

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}