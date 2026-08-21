package ni.uam.edu.salarionum2;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;
import javafx.scene.control.TextField;

public class HelloApplication extends Application {

    private ArrayList<Double> listaSalarios = new ArrayList<>();
    private int totalSalarios = 0;

    @Override
    public void start(Stage stage) throws IOException {
        //Primera parte, pedir la cantidad de salarios
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: skyblue");

        Label lblTitulo = new Label("Analisas de salarios");
        lblTitulo.setStyle("-fx-font-weight: bold;" +
                "-fx-text-fill: black;" +
                "-fx-font-size: 16");
        Label lblInfo = new Label("¿Cuantos salarios ingresará?");

        TextField tfCantidad = new TextField();
        tfCantidad.setPromptText("Ej. 5");

        Button btnComenzar = new Button("Comenzar");
        btnComenzar.setStyle("-fx-background-radius: 20;" +
                "-fx-text-fill: black;" +
                "-fx-background-color: green;" +
                "-fx-font-weight: bold");
        btnComenzar.setDefaultButton(true);

        HBox contenedorInfo = new HBox();
        contenedorInfo.setSpacing(15);
        contenedorInfo.setAlignment(Pos.CENTER);
        contenedorInfo.getChildren().addAll(tfCantidad, btnComenzar);

        //Segunda parte, pedir los salarios
        Label lblResultados = new Label("");
        Label lblProgreso = new Label("Esperando cantidad...");

        TextField tfSalario = new TextField();
        tfSalario.setPromptText("Monto del salario");
        tfSalario.setDisable(true);

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setStyle("-fx-background-radius: 20;" +
                "-fx-text-fill: black;" +
                "-fx-background-color: green;" +
                "-fx-font-weight: bold");
        btnAgregar.setDisable(true);

        HBox contenedorAgregar = new HBox();
        contenedorAgregar.setAlignment(Pos.CENTER);
        contenedorAgregar.setSpacing(15);
        contenedorAgregar.getChildren().addAll(tfSalario, btnAgregar);

        //tercera parte, hacer la logica de los botones

        btnComenzar.setOnAction(event -> {
            totalSalarios = Integer.parseInt(tfCantidad.getText());
            if(totalSalarios > 0){
                btnComenzar.setDisable(true);
                tfCantidad.setDisable(true);

                btnAgregar.setDisable(false);
                tfSalario.setDisable(false);
                btnAgregar.setDefaultButton(true);

                lblProgreso.setText("Ingresando salarios...");
            } else{
                lblResultados.setText("Error, Ingrese un numero mayor a 0");
            }
        });

        btnAgregar.setOnAction(event -> {
            double salarioActual = Double.parseDouble(tfSalario.getText());
            listaSalarios.add(salarioActual);

            tfSalario.clear();
            tfSalario.requestFocus();

            if(listaSalarios.size() == totalSalarios){
                tfSalario.setDisable(true);
                btnAgregar.setDisable(true);
                lblProgreso.setText("¡Todos los salarios registrados!");
                lblProgreso.setStyle("-fx-font-weight: bold");
                calcularEstadisticas(root);
            }
        });

        root.getChildren().addAll(lblTitulo,lblInfo,contenedorInfo, lblProgreso, contenedorAgregar);
        Scene scene = new Scene(root, 430, 250);
        stage.setScene(scene);
        stage.show();
    }
    private void calcularEstadisticas( VBox root) {

        Collections.sort(listaSalarios);
        double min = listaSalarios.get(0);
        double max = listaSalarios.get(listaSalarios.size() - 1);

        double sumaTotal = 0;
        for (double salario : listaSalarios) {
            sumaTotal += salario;
        }
        double promedio = sumaTotal / listaSalarios.size();

        HashMap<Double, Integer> frecuencias = new HashMap<>();
        for (double salario : listaSalarios) {
            frecuencias.put(salario, frecuencias.getOrDefault(salario, 0) + 1);
        }

        double moda = listaSalarios.get(0);
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entrada : frecuencias.entrySet()) {
            if (entrada.getValue() > maxFrecuencia) {
                maxFrecuencia = entrada.getValue();
                moda = entrada.getKey();
            }
        }

        Label mod = new Label("");

        if (maxFrecuencia > 1) {

            mod.setText(String.format("Moda: %.2f (Aparece %d veces)", moda, maxFrecuencia));
        } else {

            mod.setText("Moda: No aplica (ningún salario se repite");
        }

        Label alto = new Label(String.format("Salario Más Alto: %.2f\n", max));
        alto.setStyle("-fx-font-weight: bold;" +
                "-fx-text-fill: black");
        Label bajo = new Label(String.format("Salario Más Bajo: %.2f\n", min));
        bajo.setStyle("-fx-font-weight: bold;" +
                "-fx-text-fill: black");
        Label pro = new Label( String.format("Promedio: %.2f\n", promedio));
        pro.setStyle("-fx-font-weight: bold;" +
                "-fx-text-fill: black");

        mod.setStyle("-fx-font-weight: bold;" +
                "-fx-text-fill: black");

        HBox primera = new HBox();
        primera.setSpacing(50);
        primera.getChildren().addAll(alto, bajo);

        HBox segunda = new HBox();
        segunda.setSpacing(50);
        segunda.getChildren().addAll(pro, mod);

        root.getChildren().addAll(primera, segunda);
    }
}