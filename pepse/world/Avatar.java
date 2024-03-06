package pepse.world;

import danogl.GameObject;
import danogl.gui.ImageReader;
import danogl.gui.UserInputListener;
import danogl.util.Vector2;

import java.awt.event.KeyEvent;

public class Avatar extends GameObject {
	private static final float AVATAR_MOVEMENT_SPEED = 300;
	private final UserInputListener inputListener;

	public Avatar(Vector2 pos, UserInputListener inputListener, ImageReader imageReader,
				  UserInputListener inputListener1) {
		super(pos, new Vector2(100, 100),
				imageReader.readImage("assets/idle_0.png",
						false));
		this.inputListener = inputListener;
		setTag("avatar");
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		Vector2 movementDir = Vector2.ZERO;


		if (inputListener.isKeyPressed(KeyEvent.VK_LEFT)) {
			movementDir = movementDir.add(Vector2.LEFT);
		}
		if (inputListener.isKeyPressed(KeyEvent.VK_RIGHT)) {
			movementDir = movementDir.add(Vector2.RIGHT);
		}
		if (inputListener.isKeyPressed(KeyEvent.VK_SPACE)) {
			movementDir = movementDir.add(Vector2.UP);
		}
		setVelocity(movementDir.mult(AVATAR_MOVEMENT_SPEED));
	}
}
