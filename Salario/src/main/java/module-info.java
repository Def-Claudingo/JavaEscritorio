module ni.uam.edu.salario {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.uam.edu.salario to javafx.fxml;
    exports ni.uam.edu.salario;
}