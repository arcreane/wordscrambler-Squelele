module com.example.miniprojet1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.miniprojet1 to javafx.fxml;
    exports com.example.miniprojet1;
    exports com.example.miniprojet1.fx;
    opens com.example.miniprojet1.fx to javafx.fxml;
    exports com.example.miniprojet1.game;
    opens com.example.miniprojet1.game to javafx.fxml;
    exports com.example.miniprojet1.console;
    opens com.example.miniprojet1.console to javafx.fxml;
}