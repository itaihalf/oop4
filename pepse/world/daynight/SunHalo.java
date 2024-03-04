package pepse.world.daynight;

import danogl.GameObject;
import danogl.collisions.GameObjectCollection;
import danogl.components.CoordinateSpace;
import danogl.components.Transition;
import danogl.gui.rendering.OvalRenderable;
import danogl.util.Vector2;

import java.awt.*;

public class SunHalo {
    public static GameObject create (GameObject sun) {
        Color halo = new Color(255, 255, 0, 20);
        GameObject sunHalo = new GameObject(
                sun.getCenter(),
                sun.getDimensions().mult(1.5f),
                new OvalRenderable(halo)
        );
        sunHalo.setCoordinateSpace(CoordinateSpace.CAMERA_COORDINATES);
        sunHalo.setTag("sunHalo");
        sunHalo.addComponent(deltaTime -> {
            sunHalo.setCenter(sun.getCenter());
        });
        return sunHalo;
    }
}
