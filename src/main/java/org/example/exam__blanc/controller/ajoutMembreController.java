package org.example.exam__blanc.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.exam__blanc.dao.impl.MembreDaoImpl;
import org.example.exam__blanc.model.Membre;

import java.util.UUID;

public class ajoutMembreController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;


    private final MembreDaoImpl membreDao = new MembreDaoImpl();

    // Regular expressions for email and phone validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";

    @FXML
    public void handleAddButton(ActionEvent event) {
        // Validate inputs
        if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() ||
                emailField.getText().isEmpty() || phoneField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields must be filled!");
            return;
        }

        // Validate email
        if (!isValidEmail(emailField.getText())) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid email format!");
            return;
        }

        // Validate phone number
        if (!isValidPhone(phoneField.getText())) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid phone number format!");
            return;
        }

        // Generate random ID for the member
        String idd = UUID.randomUUID().toString();
        String id = idd.substring(0,10);

        System.out.println(idd);


        // Create a new Membre object
        Membre membre = new Membre(
                id,
                nomField.getText(),
                prenomField.getText(),
                emailField.getText(),
                phoneField.getText()
        );

        // Add the member to the database
        membreDao.insere(membre);

        // Show success message
        showAlert(Alert.AlertType.INFORMATION, "Success", "Member added successfully!");

        // Clear input fields
        clearFields();
    }

    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    private boolean isValidPhone(String phone) {
        return phone.matches(PHONE_REGEX);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nomField.clear();
        prenomField.clear();
        emailField.clear();
        phoneField.clear();
    }

}