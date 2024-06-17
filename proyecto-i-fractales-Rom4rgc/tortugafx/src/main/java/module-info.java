module ciencias.icc.tortugafx {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.logging;

    opens ciencias.icc.tortugafx to javafx.fxml;
    exports ciencias.icc.tortugafx;
}
