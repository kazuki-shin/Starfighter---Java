//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

//*** CONSTRUCTOR NOTE:  The 5 parameter constructor is the one that loads the image, 
//*** so, ultimately, all of the other constructors need to call that one (like the default constructor does)

import java.io.File;
import java.net.URL;
import java.util.List;
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
 * Represents a moving ship that can be drawn in a graphics
 * window.
 */
public class Ship extends MovingThing
{
	private Image image;
	private int hp, counter;
	/**
	 * Constructs a ship with a location of (10,10), a width
	 * height and speed of 10
	 */
	public Ship()
	{
		this(10,10,10,10,10);
		hp=200;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image file not found" + e.getMessage());
		}
	}

	/**
	 * Constructs a ship at a specified location with width,
	 * height and speed of 10.
	 * @param x the x location
	 * @param y the y location
	 */
	public Ship(int x, int y)
	{
	   //add code here
		this(x, y, 10,10,10);
		hp=200;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image file not found" + e.getMessage());
		}
	}

	/**
	 * Constructs a ship at a specified location with a specified
	 * speed with a width and height of 10.
	 * @param x the x location
	 * @param y the y location
	 * @param s the speed
	 */
	public Ship(int x, int y, int s)
	{
	   //add code here
		this(x,y,10,10,s);
		hp=200;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image file not found" + e.getMessage());
		}
	}

	/**
	 * Constructs a ship at a specified location with a specified
	 * speed, width and height.
	 * @param x the x location
	 * @param y the y location
	 * @param w the width
	 * @param h the height
	 * @param s the speed
	 */
	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h, s);
		hp=200;
		counter = 0;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Image file not found" + e.getMessage());
		}
	}

	public void shoot(Bullets bullets){
		bullets.cleanEmUp();
		bullets.add(new Ammo(getX()+29, getY()+5, 10,10, 4));
		//bullets.getList().get(bullets.getList().size()-1).move("UP");
	}
	
	public void takeDamage(Bullets alienShots){
		if(counter>=20){
			int shipMidX = getX()+(getWidth()/2);
			int shipMidY = getY()+(getHeight()/2);
			int shipOffSet = getWidth()/3;
			for(int i = 0; i < alienShots.getList().size();i++){
				int ammoTop = alienShots.getList().get(i).getY();
				int ammoBottom = ammoTop + alienShots.getList().get(i).getHeight();
				int ammoLeft = alienShots.getList().get(i).getX();
				int ammoRight = ammoLeft + alienShots.getList().get(i).getWidth();
				if(((ammoTop>=shipMidY-shipOffSet)&&(ammoTop<=shipMidY+shipOffSet)&&((ammoBottom>=shipMidY-shipOffSet)&&(ammoBottom<=shipMidY+shipOffSet)) &&
					(((ammoLeft>=shipMidX-shipOffSet)&&(ammoLeft<=shipMidX+shipOffSet))&&((ammoRight>=shipMidX-shipOffSet)&&(ammoRight<=shipMidX+shipOffSet))))	
						){
					counter = 0;
					hp = hp-10;
				}
			}
		}
		counter++;
	}
	
	public int getHp(){
		return hp;
	}
	
	public void setHp(int val){
		hp = val;
	}
		
	/**
	 * Adjusts the x and y of the Ship based on a specified direction, and the speed at which the
	 * ship is moving. Ships can move LEFT, RIGHT, UP or DOWN
	 * @param direction the direction in which to move
	 */
	public void move(String direction)
	{
		//add code here
		switch(direction){
		case "LEFT": 
			if(getX()-getSpeed()+10>=0)
			setX(getX()-getSpeed()); break;
		case "RIGHT": 
			if(getX()+getSpeed()<=StarFighter.WIDTH-getWidth())
			setX(getX()+getSpeed()); break;
		case "UP": 
			if(getY()-getSpeed()>=200)
			setY(getY()-getSpeed()); break;
		case "DOWN": 
			if(getY()+getSpeed()<=StarFighter.HEIGHT-getHeight()-40)
			setY(getY()+getSpeed()); break;
		}
	}

	/**
	 * Draws a Ship in a specified Graphics window
	 * @param window the Graphics window
	 */
	public void draw( Graphics window )
	{
   		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	
}
