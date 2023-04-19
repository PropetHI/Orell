module adrian.roszkowski.orell {
    requires javafx.controls;
    requires javafx.fxml;


    exports adrian.roszkowski.orell.frontend;
    opens adrian.roszkowski.orell.frontend to javafx.fxml;
    exports adrian.roszkowski.orell.backend;
    opens adrian.roszkowski.orell.backend to javafx.fxml;
}