module com.example.grafischerstudentenwuerfel {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.grafischerstudentenwuerfel to javafx.fxml;
    exports com.example.grafischerstudentenwuerfel;
}