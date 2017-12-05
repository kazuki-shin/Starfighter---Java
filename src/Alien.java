//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

//*** LIKE THE SHIP CLASS

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

/**
 * Represents a moving alien that can be drawn in a graphics
 * window.
 */
public class Alien extends MovingThing
{
	private Image image;
	
	/**
	 * Constructs an alien with a location of (0,0), a width
	 * height of 30 and a speed of 0
	 */
	public Alien()
	{
		this(0,0,30,30,0);
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image not found" + e.getMessage());
		}
	}

	/**
	 * Constructs an alien with a specified location, a width
	 * height of 30 and a speed of 0
	 * @param x the x location
	 * @param y the y location
	 */
	public Alien(int x, int y)
	{
		//add code here
		this(x,y,30,30,0);
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image not found" + e.getMessage());
		}
	}

	/**
	 * Constructs an alien with a specified location, a width
	 * height of 30 and a specified speed
	 * @param x the x location
	 * @param y the y location
	 * @param s the speed
	 */
	public Alien(int x, int y, int s)
	{
		//add code here
		this(x,y,30,30,s);
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image not found" + e.getMessage());
		}
	}

	/**
	 * Constructs an alien with a specified location, width,
	 * height and speed
	 * @param x the x location
	 * @param y the y location
	 * @param w the width
	 * @param h the height
	 * @param s the speed
	 */
	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h, s);
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image not found" + e.getMessage());
		}
	}

	/**
	 * Adjusts the x and y of the Alien based on a specified direction, and the speed at which the
	 * alien is moving. 
	 * @param direction the direction in which to move
	 */
   public void move(String direction)
	{
	   //add code here
	   switch(direction){
		case "LEFT": 
			if(getX()-getSpeed()>=0)
				setX(getX()-getSpeed()); break;
		case "RIGHT": 
			if(getX()+getSpeed()<=StarFighter.WIDTH-getWidth()-30)
				setX(getX()+getSpeed()); break;
		case "UP": 
			if(getY()-getSpeed()>=0)
				setY(getY()-getSpeed()); break;
		case "DOWN": 
			if(getY()+getSpeed()<=StarFighter.HEIGHT-getHeight())
				setY(getY()+getSpeed()); break;
		}	
	}
   
   public void shoot(Bullets bullets){
		bullets.cleanEmUp();
		bullets.add(new AlienAmmo(getX()+30, getY()+50, 10,10, 2));
	}

	/**
	 * Draws an Alien in a specified Graphics window
	 * @param window the Graphics window
	 */
	public void draw( Graphics window )
	{
   		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	
}
