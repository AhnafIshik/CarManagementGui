package coit11134.carmanagementgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene sceneMain, sceneAddRecord, sceneSearch;
    private static Stage stage;
    private static DataHandler data;

    @Override
    public void start(Stage primaryStage) {
        try {
            data = new DataHandler("cars_data.txt");

            Parent rootMain = FXMLLoader.load(getClass().getResource("/coit11134/carmanagementgui/mainMenu.fxml"));
            Parent rootAdd = FXMLLoader.load(getClass().getResource("/coit11134/carmanagementgui/addCar.fxml"));
            Parent rootSearch = FXMLLoader.load(getClass().getResource("/coit11134/carmanagementgui/searchCar.fxml"));

            sceneMain = new Scene(rootMain);
            sceneAddRecord = new Scene(rootAdd);
            sceneSearch = new Scene(rootSearch);

            stage = primaryStage;
            stage.setTitle("Car Management System");
            stage.setScene(sceneMain);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(int sceneNumber) {
        switch (sceneNumber) {
            case 0 -> stage.setScene(sceneMain);
            case 1 -> stage.setScene(sceneAddRecord);
            case 2 -> stage.setScene(sceneSearch);
        }
    }

    public static DataHandler getDataHandler() {
        return data;
    }

    public static void main(String[] args) {
        launch();
    }
}