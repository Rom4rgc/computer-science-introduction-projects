PATH_TO_FX=/home/jennmorales/Descargas/javafx-sdk-21.0.1/lib

compile:
	javac --module-path $(PATH_TO_FX) --add-modules=javafx.controls -d ./classes --source-path ./src src/autómatas/Demo.java

run:
	java --module-path $(PATH_TO_FX) --add-modules=javafx.controls -classpath classes autómatas.Demo

.PHONY: clean
clean:
	rm -rf classes
	rm -rf dist
	rm -rf autómatas.*
	rm -rf Autómatas.*
