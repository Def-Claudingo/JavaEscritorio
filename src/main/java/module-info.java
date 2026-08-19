module ni.uam.edu.calculadora_g1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.uam.edu.calculadora_g1 to javafx.fxml;
    exports ni.uam.edu.calculadora_g1;
}