package com.example;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class App extends Application {
    @Override
    public void start(Stage stage) {

        Label promptLabel = new Label("Temperature in F: ");
        TextField fahrTextField = new TextField();
        Button convertButton = new Button("Convert to Celsius");
        Label celsiusLabel = new Label();

        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Double fahr = Double.parseDouble(fahrTextField.getText());
                Double cel = (fahr - 32) * 5.0/9.0;
                celsiusLabel.setText(cel.toString());
            }
        });

        VBox root = new VBox();
        root.getChildren().add(promptLabel);
        root.getChildren().add(fahrTextField);
        root.getChildren().add(convertButton);
        root.getChildren().add(celsiusLabel);

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}