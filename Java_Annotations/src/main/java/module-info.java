module com.example.java_annotations {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_annotations to javafx.fxml;
    exports com.example.java_annotations;
}