//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

//*** Note:  Because MovingThing is abstract, it will compile
//*** without implementing the Moveable methods.  However, subclasses
//*** would not compile without the interface methods.  


/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */
import java.awt.Color;
import java.awt.Graphics;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

/**
 * Represents a moving thing.  Cannot be instantiated
 */
public abstract class MovingThing implements Moveable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int speed;

	/**
	 * Constructs a MovingThing object with default values of 10
	 */
	public MovingThing()
	{
		xPos = 10;
		yPos = 10;
		width = 10;
		height = 10;
		speed = 10;
	}

	/** 
	 * Constructs a MovingThing object at a specified x and y position
	 * with width and height and speed of 10
	 * @param x the specified x
	 * @param y the specified y
	 */
	public MovingThing(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
		speed = 10;
	}
	
	/**
	 * Constructs a MovingThing object with specified position,
	 * width and height and speed
	 * ADD @param TAGS
	 */
	public MovingThing(int x, int y, int w, int h, int s)
	{
		//add code here
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		speed = s;
	}

	// add interface methods
	
	public void setPos( int x, int y){
		xPos = x;
		yPos = y;
	}
	
    public void setX( int x ){
    	xPos = x;
    }
    
    public void setY( int y ){
    	yPos = y;
    }

    public int getX(){
    	return xPos;
    }
    
    public int getY(){
    	return yPos;
    }

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public void setWidth( int w ){
		width = w;
	}

	public void setHeight( int h ){
		height = h;
	}

    public void setSpeed( int s ){
    	speed = s;
    }

	public int getSpeed(){
		return speed;
	}

	/**
	 * Moves a MovingThing according to a specified direction
	 * @param direction the direction in which to move
	 */
	public abstract void move(String direction);
	
	/**
	 * Draws a MovingThing in a specified Graphics window
	 * @param window the Graphics window
	 */
	public abstract void draw(Graphics window);

	/**
	 * Returns a string version of the MovingThing
	 * @return a string version of the MovingThing
	 */
	public String toString()
	{
		return xPos + " " + yPos + " " + width + " " + height + " " + speed;
	}
}