package com.exercise_8;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField emailField;

    @FXML
    private TextArea outputArea;

    @FXML
    private void handleSubmitButtonAction() {
        String name = nameField.getText();
        String number = numberField.getText();
        String email = emailField.getText();
        
        // Format the output
        String output = String.format("Name: %s\nNumber: %s\nEmail: %s", name, number, email);
        
        // Set the output
        outputArea.setText(output);
    }
}