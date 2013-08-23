package test;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class testClass {
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(1200,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// init OpenGL here
		int x = Mouse.getX();
		int y = Mouse.getY();
		boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_X);
		while (!Display.isCloseRequested()) {
			
			// render OpenGL here
			
			Display.update();
			x = Mouse.getX();
			y = Mouse.getY();
			keyDown = Keyboard.isKeyDown(Keyboard.KEY_X);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		testClass displayExample = new testClass();
		displayExample.start();
	}
}