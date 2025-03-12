module com.example.grafischerstudentenwuerfel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grafischerstudentenwuerfel to javafx.fxml;
    exports com.example.grafischerstudentenwuerfel;
}