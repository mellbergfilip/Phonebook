module com.mellberg.myphonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;


    opens com.mellberg.myphonebook to javafx.fxml;
    exports com.mellberg.myphonebook;
    exports com.mellberg.myphonebook.controller;
    opens com.mellberg.myphonebook.controller to javafx.fxml;
    opens com.mellberg.myphonebook.contact to org.hibernate.orm.core, javafx.base;
}