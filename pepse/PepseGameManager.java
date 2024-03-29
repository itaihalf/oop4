package pepse;

import danogl.GameManager;
import danogl.collisions.Layer;
import danogl.gui.ImageReader;
import danogl.gui.SoundReader;
import danogl.gui.UserInputListener;
import danogl.gui.WindowController;
import pepse.world.Sky;
import pepse.world.daynight.Night;
import pepse.world.daynight.Sun;

public class PepseGameManager extends GameManager {
	@Override
	public void initializeGame(ImageReader imageReader, SoundReader soundReader,
							   UserInputListener inputListener, WindowController windowController) {
		super.initializeGame(imageReader, soundReader, inputListener, windowController);

		gameObjects().addGameObject(
				Sky.create(windowController.getWindowDimensions())
		);
		gameObjects().addGameObject(Night.create(windowController.getWindowDimensions(), 30),
				Layer.BACKGROUND);
		gameObjects().addGameObject(Sun.create(windowController.getWindowDimensions(), 30),
				Layer.BACKGROUND);

	}

	public static void main(String[] args) {
		new PepseGameManager().run();
	}
}
