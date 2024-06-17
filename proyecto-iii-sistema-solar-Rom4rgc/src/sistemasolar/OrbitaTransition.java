package sistemasolar;

import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;

public class OrbitaTransition extends Transition {

    private final Satelite satelite;
    private final double semiejeMayor;
    private final double semiejeMenor;
    private final double c;

    public OrbitaTransition(Satelite satelite,
                            double semiejeMayor, double semiejeMenor,
                            double periodoOrbital) {
        this.satelite = satelite;
        this.semiejeMayor = semiejeMayor;
        this.semiejeMenor = semiejeMenor;
        this.c = Math.sqrt(semiejeMayor * semiejeMayor - semiejeMenor * semiejeMenor);

        setInterpolator(new KeplerInterpolator());
        setCycleDuration(Duration.seconds(periodoOrbital));
        setCycleCount(Timeline.INDEFINITE);
    }

    @Override
    protected void interpolate(double frac) {
        double t = 2 * Math.PI * frac;
        double x = semiejeMayor * Math.cos(t) + 2 * c;
        double y = semiejeMenor * Math.sin(t);


        Node foco = this.satelite.getFoco().getFigura();
        Bounds inSceneCoords = foco.localToParent(foco.getBoundsInLocal());
        Point2D origen = foco.localToParent(0, 0);
        double focoX = (inSceneCoords.getMinX() + inSceneCoords.getMaxX()) / 2;
        double focoY = (inSceneCoords.getMinY() + inSceneCoords.getMaxY()) / 2;

        this.satelite.getNodo().setTranslateX(origen.getX() - focoX + x);
        this.satelite.getNodo().setTranslateY(origen.getY() - focoY + y);

    if (this.satelite.getNombre().equals("PLUTON")) {
        double alpha = Math.toRadians(17.1); // Ángulo de inclinación de Plutón en radianes
    
        double newX = Math.cos(alpha) * x - Math.sin(alpha) * y;
        double newY = Math.sin(alpha) * x + Math.cos(alpha) * y;

        Node focoPluton = this.satelite.getFoco().getFigura();
        Bounds inSceneCoordsPluton = focoPluton.localToParent(focoPluton.getBoundsInLocal());
        Point2D origenPluton = focoPluton.localToParent(0, 0);
        double focoXPluton = (inSceneCoordsPluton.getMinX() + inSceneCoordsPluton.getMaxX()) / 2;
        double focoYPluton = (inSceneCoordsPluton.getMinY() + inSceneCoordsPluton.getMaxY()) / 2;

        this.satelite.getNodo().setTranslateX(origenPluton.getX() - focoXPluton + newX);
        this.satelite.getNodo().setTranslateY(origenPluton.getY() - focoYPluton + newY);
    }

    }
}
