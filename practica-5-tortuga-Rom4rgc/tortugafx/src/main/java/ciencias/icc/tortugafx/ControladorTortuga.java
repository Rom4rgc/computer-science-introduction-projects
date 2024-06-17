/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 *
 * Se permite utilizarlo de forma personal para fines didácticos, pero no está
 * permitido transferirlo.
 */
package ciencias.icc.tortugafx;

import ciencias.icc.tortugafx.figuras.FunciónFigura;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * Controlador base.
 * @author blackzafiro
 */
public class ControladorTortuga {
	
	private final static Logger LOGGER = Logger.getLogger("ciencias.icc.tortugafx.ControladorTortuga");
	static { LOGGER.setLevel(Level.FINE); }
	
	/**
	 * Lista de figuras que puede dibujar la tortuga.
	 */
	@FXML
	private ListView<Button> vistaLista;
	
	/**
	 * Panel donde está el canvas y donde aparecen las tortugas.
	 */
	@FXML
	private AnchorPane tortuguero;
	
	/**
	 * Lienzo donde dibuja la tortuga.
	 */
	@FXML
	private Canvas canvas;
	
	/**
	 * Componente para elegir el color con el que pintará la tortuga activa.
	 */
	@FXML
	private ColorPicker colorPicker;
	
	/**
	 * Tortugas que han sido creadas y agregadas al tortuguero.
	 */
	private ArrayList<Tortuga> tortugas = new ArrayList<>();
	
	/**
	 * Índice de la tortuga que realizan las acciones actualmente.
	 */
	private int tortugaActiva = -1;
	
	/**
	 * A falta de init, permite crear los botones para dibujar con la tortuga
	 * al presionar el botón "Cargar funciones".
	 * @param controlador Instancia de una clase hija de
	 *        <code>ControladorTortuga</code> con métodos anotados con
	 *        @FunciónFigura.
	 */
	public void cargarFunciones(ControladorTortuga controlador) {
		ObservableList<Button> botones = FXCollections.observableArrayList();
		Method[] métodos = controlador.getClass().getDeclaredMethods();
		for(Method método : métodos) {
			if(método.isAnnotationPresent(FunciónFigura.class)) {
				FunciónFigura dm = método.getAnnotation(FunciónFigura.class);
				Button botón = new Button(dm.nombre());
				botón.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						try {
							if (tortugaActiva == -1) {
								creaTortuga();
							}
							método.invoke(controlador, t);
						} catch (IllegalAccessException ex) {
							Logger.getLogger(ControladorTortuga.class.getName()).log(Level.SEVERE, ex.toString(), ex);
						} catch (IllegalArgumentException ex) {
							Logger.getLogger(ControladorTortuga.class.getName()).log(Level.SEVERE,
									String.format("%s%n  ActionEvent: %s%n  this: %s%n", ex.toString(), t, this), ex);
						} catch (InvocationTargetException ex) {
							Logger.getLogger(ControladorTortuga.class.getName()).log(Level.SEVERE, ex.toString(), ex);
						}
					}
				});
				botones.add(botón);
			}
		}
        vistaLista.setItems(botones);
	}
	
	/**
	 * Permite cargar las funciones para dibujar con la tortuga.
	 * @param evtCargar 
	 */
	public void cargarFunciones(ActionEvent evtCargar) {
		cargarFunciones(this);
	}
	
	/**
	 * Limpia el lienzo y remueve las tortugas.
	 */
	public void reinicia() {
		canvas.getGraphicsContext2D().clearRect(0, 0,
				canvas.getWidth(), canvas.getHeight());
		for (Tortuga tortuga : tortugas) {
			tortuga.remuevete();
		}
		tortugas.clear();
		tortugaActiva = -1;
	}
	
	/**
	 * Añade otra tortuga al tortuguero y la selecciona como tortuga activa.
	 */
	public void creaTortuga() {
		Tortuga tortuga = new Tortuga(tortuguero);
		tortuga.asignaColor(colorPicker.getValue());
		tortugas.add(tortuga);
		tortugaActiva++;
	}
	
	/**
	 * Asigna el color del que pintará la tortuga activa.
	 * @param e 
	 */
	public void asignaColor(Event e) {
		Color c = ((ColorPicker)e.getTarget()).getValue();
		dameTortugaActiva().asignaColor(c);
	}
	
	/**
	 * Devuelve la tortuga seleccionada actualmente.
	 * @return la tortuga activa.
	 */
	protected Tortuga dameTortugaActiva() {
		return tortugas.get(tortugaActiva);
	}
}
