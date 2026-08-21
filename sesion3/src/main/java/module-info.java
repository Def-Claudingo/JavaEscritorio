module ni.uam.edu.sesion3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.uam.edu.sesion3 to javafx.fxml;
    exports ni.uam.edu.sesion3;
}