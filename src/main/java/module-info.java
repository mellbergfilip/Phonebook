module com.mellberg.myphonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;


    opens com.mellberg.myphonebook to javafx.fxml;
    exports com.mellberg.myphonebook;
}