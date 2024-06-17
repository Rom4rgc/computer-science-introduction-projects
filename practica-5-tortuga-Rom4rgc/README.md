[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11987234&assignment_repo_type=AssignmentRepo)
# icc-tortuga
Tortuga en JavaFX para hacer dibujos

Utilizar interfaces gráficas siempre es un algo más intrincado, aunque mucho más vistoso y emocionante.  Para que comiences a trabajar con ellas, usaremos el apoyo de otra herramienta para compilación: _Maven_.  Es como _Ant_, pero permite instalar dependencias de forma automática.  Así como _ant_ requiere un archivo ```build.xml```, _Maven_ utiliza un archivo ```pom.xml```.

Para usar esta herramienta también hay que instalarla.  Si usas cualquier distribución basada en Ubuntu puedes hacerlo con:

```
sudo apt install maven
```

En Fedora el equivalente es:
```
sudo dnf install maven
```

Suponiendo que incias en una terminal, dentro del directorio de este repo, para compilar y ejecutar el codigo auxiliar entra a la carpeta _tortugafx_:

```
cd tortugafx
```

y utiliza

```
mvn clean javafx:run
```

Para generar la documentación utiliza

```
mvn javadoc:javadoc
```

encontrarás los archivos html generados dentro del directorio

```
target/site/apidocs/
```

# Compilación y ejecución manual

En caso de que no puedas utilizar maven, es posible compilar y ejecutar el código del modo siguiente.

1. Descarga manualmente JavaFX del sitio [JavaFX](https://openjfx.io/), busca la última versión el archivo SDK para la arquitectura x64. Descomprime el directorio y toma nota de dónde lo pusiste, entra al directorio descomprimiedo y encuentra la carpeta .  Llamemos a ese directorio ```<javafx_dir>```.

2. En la terminal donde vayas a trabajar escribe:
```
export PATH_TO_FX=<javafx_dir>/javafx-sdk-21/lib
```
donde debes sustituir <javafx_dir> por el directorio donde descargaste JavaFX.  Esto creará una variable de ambiente en tu consola que ahorrará tener que estar escribiendo esta dirección tan larga en los comandos siguientes.

OJO: ```javafx-sdk-21``` es una versión de JavaFX en particular, es probable que el directorio que se creó al descomprimir el archivo que descargaste tenga un nombre diferente, escribe entonces el nombre del directorio que tú tengas.

3. Para compilar la práctica colócate dentro del directorio de tu repo en la consola donde ejecutaste el ```export``` y luego haz:
```
cd tortugafx
javac --module-path $PATH_TO_FX --add-modules=javafx.fxml,javafx.controls -d ./target/classes --source-path ./src/main/java src/main/java/ciencias/icc/tortugafx/App.java
```

4. Para ejecutar:
```
java --module-path $PATH_TO_FX --add-modules=javafx.fxml,javafx.controls -classpath ./target/classes/ ciencias.icc.tortugafx.App
```
