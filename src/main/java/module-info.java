module adrian.roszkowski.orell {
    requires javafx.controls;
    requires javafx.fxml;


    opens adrian.roszkowski.orell to javafx.fxml;
    exports adrian.roszkowski.orell;
}