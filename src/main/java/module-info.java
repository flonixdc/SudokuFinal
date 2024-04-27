module org.example.sudokufinal {
    // Required dependencies
    requires javafx.controls;
    requires javafx.fxml;

    // Apertura de paquetes para el cargador de FXML
    opens org.example.sudokufinal to javafx.fxml;
    opens org.example.sudokufinal.controller to javafx.fxml;
    // Exportación del paquete principal
    exports org.example.sudokufinal;
}