module com.mellberg.myphonebook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mellberg.myphonebook to javafx.fxml;
    exports com.mellberg.myphonebook;
}