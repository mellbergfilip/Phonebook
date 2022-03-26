package com.mellberg.myphonebook.controller;

import com.mellberg.myphonebook.Main;
import com.mellberg.myphonebook.contact.Contact;
import com.mellberg.myphonebook.contact.ContactDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateSceneController {

    private ContactDAO contactDAO = new ContactDAO();
    private Contact currentContact;

    @FXML
    private TextField updateLastName;
    @FXML
    private TextField updatePhoneNr;
    @FXML
    private TextField updateFirstName;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    //method that updates current contact
    public void updateCurrentContact(Contact contact) {
        currentContact = contact;
        updateTextFields(currentContact);
    }

    // method that updates textfields with current contact
    @FXML
    public void updateTextFields(Contact contact) {

        String phoneNr = String.valueOf(contact.getPhoneNr());
        updateFirstName.setText(contact.getFirstName());
        updateLastName.setText(contact.getLastName());
        updatePhoneNr.setText(phoneNr);
    }

    // Method connected to update button
    @FXML
    public void updateContact(ActionEvent event) throws IOException {
        currentContact.setFirstName(updateFirstName.getText());
        currentContact.setLastName(updateLastName.getText());
        int phoneNr = Integer.parseInt(updatePhoneNr.getText());
        currentContact.setPhoneNr(phoneNr);
        contactDAO.updateContact(currentContact);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    //Switch scene method
    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
