package pepse.world.daynight;

import danogl.GameObject;
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

		Vector2 initialSunCenter = new Vector2(windowDimensions.x() / 2, windowDimensions.y() / 2);
//		Transition<Float> transition = new Transition<>(
//				sun,
//				(Float angle) -> sun.setCenter
//						(initialSunCenter.subtract(cycleCenter)
//								.rotated(angle)
//								.add(cycleCenter)),
//
//				)
		return sun;
	}
}
