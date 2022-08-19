module com.example.mealplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires json.simple;


    opens com.example.mealplanner to javafx.fxml;
    exports com.example.mealplanner;
}