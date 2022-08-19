module com.example.mealplanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mealplanner to javafx.fxml;
    exports com.example.mealplanner;
}