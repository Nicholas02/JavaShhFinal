package game;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main
{

	private static boolean forceStop = false;

	public static void main(String[] args)
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Wuake Client");
			Display.create();
		}
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}

		Game game = new Game();
		game.init();
		game.initGL();
		game.start();

		long past = System.nanoTime();
		while (game.isRunning())
		{
			long now = System.nanoTime();
			float delta = (now - past) / 1000000000.0f;
			past = now;

			if (Display.isCloseRequested() || forceStop) game.stop();

			game.update(delta);
			game.render();

			Display.update();
			Display.sync(120);
		}
		game.cleanUp();
	}

	public static void forceStop()
	{
		forceStop = true;
	}

}