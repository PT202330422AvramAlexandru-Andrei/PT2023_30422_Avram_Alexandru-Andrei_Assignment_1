module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.testng;
    requires junit;

    opens com.example.App to javafx.fxml;
    exports com.example.App;
    exports Tests;
}