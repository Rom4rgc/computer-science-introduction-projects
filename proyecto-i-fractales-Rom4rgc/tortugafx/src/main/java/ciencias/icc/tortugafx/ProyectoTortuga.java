/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 *
 * Se permite utilizarlo de forma personal para fines didácticos, pero no está
 * permitido transferirlo.
 */
package ciencias.icc.tortugafx;

import java.util.logging.Level;
import java.util.logging.Logger;
import ciencias.icc.tortugafx.figuras.FunciónFigura;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

/**
 * Controlador con funciones específicas para que la tortuga las ejecute.
 * @author blackzafiro
 */
public class ProyectoTortuga extends ControladorTortuga {
	
	private final static Logger LOGGER = Logger.getLogger("ciencias.icc.tortugafx.ProyectoTortuga");
	static { LOGGER.setLevel(Level.FINE); }
	
	/**
	 * Mueve a la tortuga activa en la dirección en la que está mirando.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Avanza")
	public void avanza(ActionEvent t) {
		LOGGER.log(Level.FINER, "Avanza ");
		Tortuga tortuga = dameTortugaActiva();
		tortuga.avanza(50);
	}
	
	/**
	 * Gira a la tortuga activa a la derecha.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Rota a la derecha")
	public void rotaDerecha(ActionEvent t) {
		LOGGER.log(Level.FINER, "Rota a la derecha ");
		Tortuga tortuga = dameTortugaActiva();
		tortuga.rota(-10);
	}
	
	/**
	 * Gira a la tortuga activa a la izquierda.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Rota a la izquierda")
	public void rotaIzquierda(ActionEvent t) {
		LOGGER.log(Level.FINER, "Rota a la izquierda ");
		Tortuga tortuga = dameTortugaActiva();
		tortuga.rota(10);
	}
	
	/**
	 * Levanta la pluma de la tortuga activa.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Levanta la pluma")
	public void levantaPluma(ActionEvent t) {
		LOGGER.log(Level.FINER, "Levanta la pluma");
		Tortuga tortuga = dameTortugaActiva();
		tortuga.plumaAbajo(false);
	}
	
	/**
	 * Baja la pluma de la tortuga activa.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Baja la pluma")
	public void bajaPluma(ActionEvent t) {
		LOGGER.log(Level.FINER, "Baja la pluma");
		Tortuga tortuga = dameTortugaActiva();
		tortuga.plumaAbajo(true);
	}
	
	/**
	 * Dibuja un triángulo con la tortuga activa a partir de la posición en la
	 * que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Triángulo")
	public void dibujaTriángulo(ActionEvent t) {
		Tortuga tortuga = dameTortugaActiva();
		
		// Uso de un ciclo para controlar la tortuga.
		for(int i = 0; i < 3; i++) {
			tortuga.avanza(100);
			tortuga.rota(-120);
		}
	}
	
	/**
	 * Dibuja un par de triángulos con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
	@FunciónFigura(nombre = "Banderín")
	public void dibujaBanderín(ActionEvent t) {
		Tortuga tortuga = dameTortugaActiva();
		dibujaTriángulo(t);
		tortuga.rota(60);
		dibujaTriángulo(t);
		tortuga.rota(-60);    // Reacomoda a la tortuga en su posición inicial
	       
	}
    /**
	 * Dibuja un dibujo libre con las funciones base con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
          @FunciónFigura(nombre = "Barco")
	  public void dibujaBarco(ActionEvent t) {
  	          Tortuga tortuga = dameTortugaActiva();
		  tortuga.asignaColor(Color.BROWN);
		  tortuga.rota(90);
		  tortuga.avanza(300);
		  tortuga.rota(-90);	 
		  dibujaBanderín(t);
		  levantaPluma(t);
		  tortuga.avanza(100);
		  tortuga.rota (-90);
		  bajaPluma(t);
		  tortuga.avanza(300);
		  tortuga.rota(-90);
		  dibujaBanderín(t);
		  levantaPluma(t);
		  tortuga.avanza(100);
		  tortuga.rota(-90);
		  bajaPluma(t);
		  tortuga.avanza(200);
		  tortuga.rota(-90);
		  levantaPluma(t);
		  tortuga.avanza(100);
		  bajaPluma(t);
		  tortuga.avanza(100);
		  tortuga.rota(60);
		  dibujaTriángulo(t);
		  tortuga.rota(-60);
	  }
        /**
	 * Dibuja un cuadrado con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
         @FunciónFigura(nombre = "Cuadrado")
	 public void dibujaCuadrado(ActionEvent t) {
	         Tortuga tortuga = dameTortugaActiva();
		 tortuga.asignaColor(Color.RED);
		 for (int i = 0; i < 4; i++ ) {
		     tortuga.avanza(150);
		     tortuga.rota(-90);
		 }

	 }
         /**
	 * Dibuja un circulo con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
         @FunciónFigura(nombre = "Circulo")
	 public void dibujaCirculo(ActionEvent t) {
	         Tortuga tortuga = dameTortugaActiva();
		 tortuga.asignaColor(Color.BLUE);
	         for (int i = 0; i < 360; i++) {
		     tortuga.avanza(2);
		     tortuga.rota(-1);
	     }
	 }
    
        /**
	 * Dibuja una flor con el cuadrado y círculo con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
         @FunciónFigura(nombre = "Flor")
	 public void dibujaFlor(ActionEvent t) {
	        Tortuga tortuga = dameTortugaActiva();
		tortuga.asignaColor(Color.PINK);
		for (int i = 0; i < 360; i++) {
		    tortuga.rota(10);
		    dibujaCuadrado(t);
		    dibujaCirculo(t);
		}
	       
	 }

          /**
	 * Dibuja un cuadrado como función auxiliar para el dibujo Patrón con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
          @FunciónFigura(nombre = "Cuadrado2")
	 public void dibujaCuadrado2(ActionEvent t) {
	         Tortuga tortuga = dameTortugaActiva();
		 for (int i = 0; i < 4; i++ ) {
		     tortuga.avanza(50);
		     tortuga.rota(-90);
		 }
	  }
           /**
	 * Dibuja un cuadrado como función auxiliar para el dibujo Patrón con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
	  @FunciónFigura(nombre = "Cuadrado3")
	  public void dibujaCuadrado3(ActionEvent t) {
	      Tortuga tortuga = dameTortugaActiva();
		 for (int i = 0; i < 4; i++ ) {
		     tortuga.avanza(90);
		     tortuga.rota(-90);
		 }
	  }
         /**
	 * Dibuja un Patrón con Cuadrado2 y Cuadrado3 con la tortuga activa a partir de la posición
	 * en la que se encuentre.
	 * @param t No se usa, pero es requerido.
	 */
         @FunciónFigura(nombre = "Patrón")
	 public void dibujaPatron(ActionEvent t) {
	         Tortuga tortuga = dameTortugaActiva();
		 tortuga.asignaColor(Color.PURPLE);
		 for (int i = 0; i < 4; i++) {
		     tortuga.avanza(120);
		     tortuga.rota(-80);
		     tortuga.avanza(50);
		     dibujaCuadrado3(t);
		     tortuga.rota(80);
		     tortuga.avanza(20);
		     dibujaCuadrado2(t);
		     tortuga.rota(80);
		 }

	  }
}
