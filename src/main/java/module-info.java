module com.example.pelotascaen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pelotascaen to javafx.fxml;
    exports com.example.pelotascaen;
    exports com.example.pelotascaen.controllers;
    opens com.example.pelotascaen.controllers to javafx.fxml;
}