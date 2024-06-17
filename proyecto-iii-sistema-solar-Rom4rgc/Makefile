PATH_TO_FX=/home/jennmorales/Descargas/javafx-sdk-21.0.1/lib
compile:
	javac --module-path $(PATH_TO_FX) --add-modules=javafx.controls -d ./classes --source-path ./src src/sistemasolar/SistemaSolar.java

run:
	java --module-path $(PATH_TO_FX) --add-modules=javafx.controls -classpath classes sistemasolar.SistemaSolar

.PHONY: clean
clean:
	rm -rf classes

