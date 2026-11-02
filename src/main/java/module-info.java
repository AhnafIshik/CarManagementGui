module coit11134.carmanagementgui {
    requires javafx.controls;
    requires javafx.fxml;

    opens coit11134.carmanagementgui to javafx.fxml;
    exports coit11134.carmanagementgui;
}