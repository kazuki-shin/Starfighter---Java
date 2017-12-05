//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

//*** NOTE:  Unlike the other MovingThings, there is no image associated with Ammo.
//*** The draw method just uses Graphics method to set the color and draw a filled rectangle.
/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */
/**
 * Represents moving Ammo that can be drawn in a graphics window
 */
public class Ammo extends MovingThing
{	
	private Color color;
	/**
	 * Contructs an ammo at location (0,0) with a width, height and speed of 0
	 */
	public Ammo()
	{
		// add code
		setX(0);
		setY(0);
		setWidth(0);
		setHeight(0);
		setSpeed(0);
		color= Color.GREEN;
	}

	/**
	 * Constructs an ammo at a specified location with a width and height of 10 and speed of 0
	 * @param x the x location
	 * @param y the y location
	 */
	public Ammo(int x, int y)
	{
		//add code
		setX(x);
		setY(y);
		setWidth(0);
		setHeight(0);
		setSpeed(0);
		color= Color.GREEN;
	}

	/**
	 * Constructs an ammo at a specified location with a specified width, height and speed
	 * @param x the x location
	 * @param y the y location
	 * @param w the width
	 * @param h the height
	 * @param s the speed
	 */
	public Ammo(int x, int y, int w, int h, int s)
	{
		//add code
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setSpeed(s);
		color= Color.GREEN;
	}

	public void setColor(Color color){
		this.color = color;
	}
	
	/**
	 * Draws the ammo in the graphics window
	 * @param window the graphics window
	 */
	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Adjusts the y of the ammo based on a specified direction, either UP or DOWN and the 
	 * speed at which the ammo is moving. 
	 * @param direction the direction in which to move
	 */
	public void move( String direction )
	{
		//add code to draw the ammo
		if(direction.equals("UP"))
			setY(getY()-getSpeed());
		if(direction.equals("DOWN"))
			setY(getY()+getSpeed());
		if(direction.equals("LEFT"))
			setX(getX()-getSpeed());
		if(direction.equals("RIGHT"))
			setX(getX()+getSpeed());
		
	}


}
