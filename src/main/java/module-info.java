module com.mellberg.myphonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;


    opens com.mellberg.myphonebook to javafx.fxml;
    exports com.mellberg.myphonebook;
    exports com.mellberg.myphonebook.controller;
    opens com.mellberg.myphonebook.controller to javafx.fxml;
}