module com.example.miniprojet1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.miniprojet1 to javafx.fxml;
    exports com.example.miniprojet1;
}