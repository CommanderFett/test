package test;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.util.glu.GLU.*;
import static org.lwjgl.opengl.GL11.*;
 
public class testClass {
 
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
 
	// init OpenGL
    glEnable(GL_DEPTH_TEST);
    
    glEnable (GL_BLEND);
    glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	//glOrtho(0, 800, 0, 600, 1, -1);
	gluPerspective(45f,800/600f,10f,5000f);//makes the center of the window (0,0,0)
	//GLU.gluPerspective(fovy, aspect, zNear, zFar);
	glMatrixMode(GL_MODELVIEW);
	int x = 0;//Mouse.getX();
	int y = 0 ;//Mouse.getY();
	int z = -900;
	int offsetX = 0;
	int offsetY = 0;
	boolean keyPressed = false;
 
	while (!Display.isCloseRequested()) {
	    // Clear the screen and depth buffer
	    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	
	    
	    
	    
	    
	    x = Mouse.getX()-400;
	    y = Mouse.getY()-300;
	    
	    if(Keyboard.isKeyDown(Keyboard.KEY_S))
	    {
	    	offsetY -=1;
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_W))
	    {
	    	offsetY +=1;
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_D))
	    {
	    	offsetX +=1;
	    }
	    if(Keyboard.isKeyDown(Keyboard.KEY_A))
	    {
	    	offsetX -=1;
	    }
	    z = -300 + offsetY;	
	    // draw quad
	    
	    glColor3f(0.5f,0.5f,1.0f);
	    
	    //remember, right hand rule. draw verticies counterclockwise.
	    glPushMatrix();
	    glTranslatef(x, y, z);
	    glRotatef(offsetX,1,1,1);
	    
	    glBegin(GL_QUADS);
	    //counterclockwise
	    glColor4f(0.0f,0.0f,1.0f,0.1f);
	    glVertex3f(-100,100, 0);
	    glVertex3f(-100,-100, 0);
	    glVertex3f(100,-100, 0);
		glVertex3f(100,100, 0);
		
		glColor3f(0.0f,1.0f,0.0f);
		glVertex3f(-100,-100, 0);
		glVertex3f(-100,100, 0);
	    glVertex3f(-100,100, -200);
		glVertex3f(-100,-100, -200);
		
		glColor3f(1.0f,0.0f,0.0f);
		glVertex3f(100,100,0);
		glVertex3f(100,-100,0);
		glVertex3f(100,-100,-200);
		glVertex3f(100,100,-200);
		
		
		
		
		
		
		
		glColor3f(0.2f,0.2f,1.0f);
	    glEnd();
	    glPopMatrix();
	    /*
	    glColor3f(0.7f,0.1f,0.1f);
	    
	    glBegin(GL11.GL_TRIANGLES);
	    glVertex2f(x-offsetX,y-offsetY);
	    glVertex2f(x-offsetX+20,y-offsetY+10);
	    glVertex2f(x-offsetX+20,y-offsetY-10);
	    glEnd();*/
 
	    Display.update();
	}
 
	Display.destroy();
    }
 
    public static void main(String[] argv) {
        testClass quadExample = new testClass();
        quadExample.start();
    }
}


/*import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

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
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		int x = Mouse.getX();
		int y = Mouse.getY();
		boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_X);
		while (!Display.isCloseRequested()) {
			
			// render OpenGL here
			// clear the screen and depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);	
					
			// set the color of the quad (R,G,B,A)
			glColor3f(0.5f,0.5f,1.0f);
			Display.update();
			x = Mouse.getX();
			y = Mouse.getY();
			keyDown = Keyboard.isKeyDown(Keyboard.KEY_X);
			glBegin(GL_QUADS);
		    glVertex2f(100,100);
		    glVertex2f(100+200,100);
		    glVertex2f(100+200,100+200);
		    glVertex2f(100,100+200);
		    glEnd();
		    Display.update();
		}
		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		testClass displayExample = new testClass();
		displayExample.start();
	}
}*/