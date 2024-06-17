private void sierpinski(double longitud, int nivel) {
    Tortuga tortuga = dameTortugaActiva();
    if (nivel == 0) {
        tortuga.rota(-30);
        // Caso base: Dibuja un triángulo equilátero
        for (int i = 0; i < 3; i++) {
            tortuga.avanza(longitud);
            tortuga.rota(-120);
        }
    } else {
        double newLongitud = longitud;
        // Dibuja el triángulo superior
        sierpinski(newLongitud / 2, nivel - 1);
        // Mueve la tortuga  la punta superior
        tortuga.avanza(newLongitud / 2);
        tortuga.rota(30);

        sierpinski(newLongitud / 2, nivel - 1);
        tortuga.rota(-120);
        tortuga.avanza(newLongitud / 2);
        tortuga.rota(150);

        sierpinski(newLongitud / 2, nivel - 1);
        tortuga.rota(120);
        tortuga.avanza(newLongitud / 2);
        tortuga.rota(-120);
    }
}




@FunciónFigura(nombre = "Sierpinski")
public void dibujaSierpinski(ActionEvent t) {
    Tortuga tortuga = dameTortugaActiva();
    sierpinski(200, 3);
}




private void snowflakeSide(double longitud, int nivel) {
    Tortuga tortuga = dameTortugaActiva();
    if (nivel == 0) {
        tortuga.avanza(longitud);
    } else {
        double newLongitud = longitud / 3;

        snowflakeSide(newLongitud, nivel - 1);
        tortuga.rota(-60);
        snowflakeSide(newLongitud, nivel - 1);
        tortuga.rota(120);
        snowflakeSide(newLongitud, nivel - 1);
        tortuga.rota(-60);
        snowflakeSide(newLongitud, nivel - 1);
    }
}




private void snowflake(double longitud, int nivel) {
    Tortuga tortuga = dameTortugaActiva();
    for (int i = 0; i < 3; i++) {
        snowflakeSide(longitud, nivel);
        tortuga.rota(120);
    }
}



private void snowflake(double longitud, int nivel) {
    Tortuga tortuga = dameTortugaActiva();
    for (int i = 0; i < 3; i++) {
        snowflakeSide(longitud, nivel);
        tortuga.rota(120);
    }
}

