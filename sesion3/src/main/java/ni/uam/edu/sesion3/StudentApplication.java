package ni.uam.edu.sesion3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("student.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registro de notas");
        stage.setScene(scene);
        stage.show();
    }
}
