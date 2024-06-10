module com.example.neo_aucoustic_intelligence {
    requires javafx.controls;
    requires javafx.fxml;

    exports Database;
    opens com.example.neo_aucoustic_intelligence to javafx.fxml;
    exports com.example.neo_aucoustic_intelligence;
}
