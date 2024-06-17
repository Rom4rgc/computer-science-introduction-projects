[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=12310961&assignment_repo_type=AssignmentRepo)
<p align="center">
<img
    src="./imgs/donatelo.png"
    alt="Donatelo"
    width=100 heigh=100
/> 
</p>

## Gráficos Tortuga

Donatelo es una tortuga muy feliz que vive en un mundo bidimensional pintado de blanco, por el cual puede desplazarse libremente. Pero no solo eso, Donatelo es un excelente artista, que puede usar su propio mundo como lienzo y pintarlo usando su cola como pincel. En esta ocasión, Donatelo ha comprado un nuevo conjunto de colores y quiere compartir contigo este gran momento para que juntos puedan crear grandes obras de arte.

Como Donatelo no puede hablar nuestro idioma, la única manera en que te puedes comunicar con él es a través de la siguiente interfaz de operaciones:

```java
/*
* Donatelo se mueve hacia el frente las unidades determinadas por la variable distance.
*/
public void avanza(double distancia);

/*
* Donatello gira en la dirección contraria a las manecillas del reloj la cantidad de grados indicados.
* Gira en la dirección opuesta si el valor es negativo.
*/
public void rota(double grados);

/*
* Donatelo baja su cola sí estaAbajo es true, asī que cuando se desplaza dejará pintado su rastro.
* Donatello sube su cola si es false, por lo que cuando se desplaza no pintará nada.
*/
public void plumaAbajo(boolean estaAbajo);

/*
* Donatello pone en su cola el color especificado.
*/
public void asignaColor(Color color);
```

El estado inicial en donde comienza Donatelo es mirando hacia el Norte con la cola abajo y el color en su cola establecido en Negro.

## Objetivo
Ayuda a Donatelo a crear diversas figuras geométricas, usando para ello el conocimiento que haz adquirido de objectos, métodos y programación recursiva.


## Ejecutar tu Programa

1. Copia tu proyecto _Maven_ de la práctica _Tortugas_.  Lo que harás es agregarle más funciones.

2. Entrar en la carpeta del proyecto _tortugafx_ en la terminal usando el comando **cd**.

3. Compilar el proyecto usando Maven:

        $ mvn clean javafx:run
        
4. También puedes compilar y ejecutarlo a mano, descargando y descomprimiento la versión de javafx que coincide con la versión de java que tienes instalada de aquí [Gluon JavaFX](https://gluonhq.com/products/javafx/).  Por ejemplo, para la versión 11 los comandos se ven así:

        $ export PATH_TO_FX=<where_you_placed_it>/javafx-sdk-11.0.1/lib
        $ javac --module-path $PATH_TO_FX --add-modules=javafx.controls,javafx.fxml,java.logging -d ./target/classes --source-path ./src/main/java src/main/java/ciencias/icc/tortugafx/*.java
        $ cp ./src/main/resources/ciencias/icc/tortugafx/* ./target/classes/ciencias/icc/tortugafx/
        $ java --module-path $PATH_TO_FX --add-modules=javafx.controls,javafx.fxml,java.logging -classpath target/classes ciencias.icc.tortugafx.App
