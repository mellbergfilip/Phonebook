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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.sql.Update;

import java.io.IOException;

public class MainController {

    private ContactDAO contactDAO = new ContactDAO();



    @FXML
    private StackPane stackPaneWarning;
    @FXML
    private Label warningLabel;

    @FXML
    private TableColumn<Contact, Integer> columnID;
    @FXML
    private TableColumn<Contact, String> columnFirstName;
    @FXML
    private TableColumn<Contact, String> columnLastName;
    @FXML
    private TableColumn<Contact, Integer> columnPhoneNr;
    @FXML
    private TableView<Contact> contactTableView;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    // initialize method
    @FXML
    public void initialize() {
        stackPaneWarning.setVisible(false);

        columnID.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("contactId"));
        columnFirstName.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
        columnLastName.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
        columnPhoneNr.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("phoneNr"));

        updateContactTableView();
    }

    //Connected to deleteButton
    public void deleteContact(ActionEvent event) {
        if (contactTableView.getSelectionModel().getSelectedItem() == null) {
            warningLabel.setText("Select a contact");
            stackPaneWarning.setVisible(true);
        } else {
            Contact contact = contactTableView.getSelectionModel().getSelectedItem();
            contactDAO.deleteContact(contact);
            updateContactTableView();
        }
    }

    // Updates tableview with contacts
    private void updateContactTableView() {
        contactTableView.setItems(FXCollections.observableArrayList(contactDAO.readContacts()));
    }

    // Switch scenes methods
    @FXML
    public void switchToCreateScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("createScene.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToUpdateScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("updateScene.fxml"));
        root = fxmlLoader.load();
        UpdateSceneController updateSceneController = fxmlLoader.getController();

        if (contactTableView.getSelectionModel().getSelectedItem() != null) {
            Contact contact = contactTableView.getSelectionModel().getSelectedItem();
            updateSceneController.updateCurrentContact(contact);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            warningLabel.setText("Select a contact");
            stackPaneWarning.setVisible(true);
        }
    }

    // Method connected to warning pop-up OK button

    @FXML
    void okWarningSign(ActionEvent event) {
        stackPaneWarning.setVisible(false);
    }

}