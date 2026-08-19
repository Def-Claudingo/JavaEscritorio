package ni.uam.edu.calculadora_g1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);

        TextField tfnumero1 = new TextField();
        TextField tfnumero2 = new TextField();
        Label lblTitulo = new Label("Calculadora Basica");
        Label lblrespuesta = new Label("" );
        Label lblnumero1 = new Label("Numero 1");
        Label lblnumero2 = new Label("Numero 2");


        Button btnmul = new Button("*");
        Button btnsum = new Button("+");
        Button btnrest = new Button("-");
        Button btndiv = new Button("/");

        btnsum.setOnAction(event -> {
            int num1 = Integer.parseInt(tfnumero1.getText());
            int num2 = Integer.parseInt(tfnumero2.getText());
            int sum = num1 + num2;
            lblrespuesta.setText((String.valueOf(sum)));
        });

        btnrest.setOnAction(event -> {
            int num1 = Integer.parseInt(tfnumero1.getText());
            int num2 = Integer.parseInt(tfnumero2.getText());
            int rest = num1 - num2;
            lblrespuesta.setText((String.valueOf(rest)));
        });

        btnmul.setOnAction(event -> {
            int num1 = Integer.parseInt(tfnumero1.getText());
            int num2 = Integer.parseInt(tfnumero2.getText());
            int mul = num1 * num2;
            lblrespuesta.setText((String.valueOf(mul)));
        });

        btndiv.setOnAction(event -> {
            int num1 = Integer.parseInt(tfnumero1.getText());
            int num2 = Integer.parseInt(tfnumero2.getText());
            double div = num1 / num2;
            lblrespuesta.setText((String.valueOf(div)));
        });

        HBox contenedor = new HBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);
        contenedor.setPadding(new Insets(10));
        contenedor.setStyle("-fx-border-color: #0099ab; -fx-border-radius: 10");
        contenedor.getChildren().addAll(btndiv, btnmul, btnrest, btnsum);

        vbox.getChildren().addAll(lblTitulo, lblnumero1, tfnumero1, lblnumero2
        , tfnumero2, lblrespuesta, contenedor);

        Scene scene = new Scene(vbox, 280, 280);
        stage.setScene(scene);
        stage.show();
    }
}
