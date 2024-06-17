/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autómatas;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * IGU JavaFX con modelos tipo Autómata Celular.
 * @author blackzafiro
 */
public class Menús extends BorderPane {

    // TODO: Acomoda los elementos de la enumeración para que correspondan
    // a los autómatas que programaste.
    public enum TipoAutómata {
        AUTÓMATA_1(new AutómataUno()),   
        AUTÓMATA_2(new AutómataDos());  
        /**
         * Cada constante también tiene asociado el autómata correspondiente.
         */
        private final Autómata autómata;

        /**
         * Constructor.
         */
        TipoAutómata(Autómata a) {
            autómata = a;
        }

        public Autómata getAutómata() {
            return autómata;
        }
    }

    private Autómata autómataActual = null;
    private Text tPaso;

    /**
     * Crea la barra de menú que permitirá cambiar entre modelos de
     * autómatas.
     */
    Menús() {
        Menu menu = new Menu("Autómatas");
        EventHandler<ActionEvent> menuHandler = (event) -> {
            MenuItem target = (MenuItem)(event.getTarget());
            TipoAutómata a = (TipoAutómata)(target.getUserData());
            setAutómata(a);
        };

        // Agrega una opción por cada elemento en la enumeración TipoAutómata.
        for (TipoAutómata t : TipoAutómata.values()) {
            MenuItem menuItem = new MenuItem(t.toString());
            menuItem.setOnAction(menuHandler);
            menuItem.setUserData(t);
            menu.getItems().add(menuItem);
        }

        Button iniciar = new Button("Iniciar");
        iniciar.setOnAction(event -> autómataActual.start());
        Button detener = new Button("Detener");
        detener.setOnAction(event -> autómataActual.stop());
        // Barra inferior
        tPaso = new Text("0");
        ToolBar herramientas = new ToolBar(
            iniciar,
            detener,
            new Separator(),
            new Label("Paso"),
            tPaso
        );

        // Coloca los componentes utilizando los métodos heredados de BorderPane.
        setTop(new MenuBar(menu));
        setBottom(herramientas);

        // Inicia con el primer autómata por defecto.
        setAutómata(TipoAutómata.AUTÓMATA_1);
    }

    /**
     * Asigna al autómata que se mostrará en pantalla.
     */
    void setAutómata(TipoAutómata a) {
        if(autómataActual != null) {
            // Detiene la ejecución del autómata actual.
            autómataActual.stop();
        }
        // Carga e inicia el autómata solicitado.
        autómataActual = a.getAutómata();
        autómataActual.setTextPaso(tPaso);
        setCenter(autómataActual.getAutómataNode());
 
    }
   
}
