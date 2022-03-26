package com.mellberg.myphonebook.controller;

import com.mellberg.myphonebook.Main;
import com.mellberg.myphonebook.contact.Contact;
import com.mellberg.myphonebook.contact.ContactDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateSceneController {


    @FXML
    private TextField createFirstName;
    @FXML
    private TextField createLastName;
    @FXML
    private TextField createPhoneNr;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Create button
    public void createContact(ActionEvent event) throws IOException {
        ContactDAO contactDAO = new ContactDAO();
        String firstName = createFirstName.getText();
        String lastName = createLastName.getText();
        int phoneNr = Integer.parseInt(createPhoneNr.getText());
        Contact contact = new Contact(firstName,lastName,phoneNr);
        contactDAO.createContact(contact);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // Switch scene method
    @FXML
    private void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
