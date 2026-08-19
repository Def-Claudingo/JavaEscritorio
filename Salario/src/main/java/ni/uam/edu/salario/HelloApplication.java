package ni.uam.edu.salario;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        Label lblTitulo = new Label("Calculadora de Salario");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label lblPide = new Label("Ingresa el salario del trabajador:");
        TextField tfSalario = new TextField();

        Button btnCalcular = new Button("Calcular");

        Label lblSeguro    = new Label("");
        Label lblBono      = new Label("");
        Label lblSalNeto   = new Label("");

        btnCalcular.setOnAction(event -> {
            double salario = Double.parseDouble(tfSalario.getText());

            double seguro = salario * 0.07;

            double bono;
            if (salario < 12000) {
                bono = salario * 0.10;
            } else if (salario <= 20000) {
                bono = salario * 0.05;
            } else {
                bono = salario * 0.03;
            }

            double salarioNeto = salario - seguro + bono;

            lblSeguro.setText("Seguro Social (7%): " +  seguro);
            lblBono.setText("Bono: " +  bono);
            lblSalNeto.setText("Salario Neto: " + salarioNeto);
        });

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(lblTitulo, lblPide, tfSalario, btnCalcular, lblSeguro, lblBono, lblSalNeto);

        Scene scene = new Scene(vbox, 320, 300);
        stage.setTitle("Calculadora de Salario");
        stage.setScene(scene);
        stage.show();
    }
}









