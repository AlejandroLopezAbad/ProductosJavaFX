module com.example.rickandmortyinterfaces {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.net.http;
    requires org.json;

    opens com.example.rickandmortyinterfaces to javafx.fxml;
    exports com.example.rickandmortyinterfaces;
    exports com.example.rickandmortyinterfaces.Controller;
    opens com.example.rickandmortyinterfaces.Controller to javafx.fxml;
    opens com.example.rickandmortyinterfaces.models to javafx.fxml;
    exports com.example.rickandmortyinterfaces.models;

}