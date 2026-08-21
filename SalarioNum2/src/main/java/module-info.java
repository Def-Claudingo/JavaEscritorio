module ni.uam.edu.salarionum2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.uam.edu.salarionum2 to javafx.fxml;
    exports ni.uam.edu.salarionum2;
}