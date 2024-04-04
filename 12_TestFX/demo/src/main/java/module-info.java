module com.exercise_12 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.exercise_12 to javafx.fxml;
    exports com.exercise_12;
}
