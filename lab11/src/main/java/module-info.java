module com.dh.lab11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.dh.lab11 to javafx.fxml;
    exports com.dh.lab11;
}
