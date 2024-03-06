module com.exercise_8 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.exercise_8 to javafx.fxml;
    exports com.exercise_8;
}
