package com.exercise_12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
class AppTest {

    @Start
    void onStart(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    
    @Test
    void inputEmailShowsInTextArea(FxRobot robot) {
        // expect:
        String email = "awesomeguy123@mail.com";
        robot.clickOn("#emailField");
        robot.write(email);
        robot.clickOn("#submitButton");
        TextArea outputArea = robot.lookup("#outputArea").queryAs(TextArea.class);
        assertTrue(outputArea.getText().contains(email));

    }


}


