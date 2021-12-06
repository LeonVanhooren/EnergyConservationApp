module com.app.energyconservationapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.app.energyconservationapp to javafx.fxml;
    exports com.app.energyconservationapp;
    exports Objects;
    opens Objects to javafx.fxml;
}