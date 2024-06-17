package ciencias.icc.tortugafx;

import ciencias.icc.tortugafx.log.Formateador;
import ciencias.icc.tortugafx.log.LogConsola;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

/**
 * JavaFX App
 */
public class App extends Application {
	
	private final static Logger LOG_RAIZ = Logger.getLogger("ciencias.icc.tortugafx");
	private final static Logger LOGGER = Logger.getLogger("ciencias.icc.tortugafx.config");
	static { LOGGER.setLevel(Level.OFF); }

	/**
	 * Única escena en esta aplicación.
	 */
    private static Scene scene;
	
	/**
	 * Redirecciona los mensajes de la bitácora a la terminal en lugar de un
	 * archivo.
	 */
	private void configLogger() {
		LogConsola handler = new LogConsola();
		handler.setLevel(Level.ALL);
		handler.setFormatter(new Formateador());
		LOG_RAIZ.addHandler(handler);
		LOG_RAIZ.setUseParentHandlers(false);
		LOG_RAIZ.setLevel(Level.ALL);
		//LOG_RAIZ.setLevel(Level.OFF);
	}
	
	/**
	 * Permite imprimir mensajes en español de México.
	 */
	private void setLocaleMX() {
		java.util.Locale.setDefault(new Locale("es", "MX"));
		java.util.Locale currentLocale = java.util.Locale.getDefault();
		
		Level level = Level.CONFIG;
 
		LOGGER.log(level, currentLocale.getDisplayLanguage());
		LOGGER.log(level, currentLocale.getDisplayCountry());

		LOGGER.log(level, currentLocale.getLanguage());
		LOGGER.log(level, currentLocale.getCountry());

		System.setProperty("user.country", "MX");
		
		LOGGER.log(level, System.getProperty("user.country"));
		LOGGER.log(level, System.getProperty("user.language"));
	}

	/**
	 * Crea la ventana principal (stage) e inicializa la interfaz.
	 * @param stage
	 * @throws IOException 
	 */
    @Override
    public void start(Stage stage) throws IOException {
		configLogger();
		setLocaleMX();
		
        scene = new Scene(loadFXML("lienzo"), 900 + 250, 650 + 40);
        stage.setScene(scene);
        stage.show();
    }

	/**
	 * Carga los componentes de la interfaz desde un archivo fxml y los asigna
	 * a la escena única.
	 * @param fxml
	 * @throws IOException 
	 */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

	/**
	 * Carga los componentes de la interfaz desde un archivo fxml.
	 * @param fxml
	 * @return
	 * @throws IOException 
	 */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

	/**
	 * Inicia la ejecución de la aplicación.
	 * @param args 
	 */
    public static void main(String[] args) {
        launch();
    }

}