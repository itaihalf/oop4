package pepse.world.daynight;

import danogl.GameObject;
import danogl.collisions.GameObjectCollection;
import danogl.components.CoordinateSpace;
import danogl.components.Transition;
import danogl.gui.rendering.OvalRenderable;
import danogl.util.Vector2;


import java.awt.*;

public class Sun {

	public static GameObject create(Vector2 windowDimensions,
									float cycleLength) {
		GameObject sun = new GameObject(
				windowDimensions.mult(.5f),
				new Vector2(30, 30),
				new OvalRenderable(Color.YELLOW)
		);
		sun.setCoordinateSpace(CoordinateSpace.CAMERA_COORDINATES);
		sun.setTag("sun");
		Vector2 initialSunCenter = new Vector2(windowDimensions.x() / 2, windowDimensions.y());
		Vector2 cycleCenter = new Vector2(windowDimensions.x() / 2, windowDimensions.y() / 2);
		new Transition<Float>(sun, (Float angle) -> sun.setCenter
				(initialSunCenter.subtract(cycleCenter)
						.rotated(angle)
						.add(cycleCenter))
				,
				0f, 360f, Transition.LINEAR_INTERPOLATOR_FLOAT,
				cycleLength/2, Transition.TransitionType.TRANSITION_LOOP, null);
//		Vector2 initialSunCenter = new Vector2(windowDimensions.x() / 2, windowDimensions.y() / 2);
		return sun;
	}
}
