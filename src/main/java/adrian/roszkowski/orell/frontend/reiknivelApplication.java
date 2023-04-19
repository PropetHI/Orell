package adrian.roszkowski.orell.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/******************************************************************************
 *  Nafn    : Adrian Roszkowski
 *  T-póstur: adr11@hi.is
 *
 *  Lýsing  : Starts the Calculator application.
 *
 *
 *****************************************************************************/
public class reiknivelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(reiknivelApplication.class.getResource("reiknivel-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
