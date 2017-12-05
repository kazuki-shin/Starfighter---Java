import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */
class AlienBullets extends Ammo
{
	private List<Ammo> ammo;

	/**
	 * Constructs a Bullets with no ammo
	 */
	public AlienBullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	/**
	 * Adds an Ammo to the Bullets
	 * @param al the Ammo
	 */
	public void add(Ammo al)
	{
		ammo.add(al);
	}

	/**
	 * Draws all of the ammo in the bullets list
	 * @param window the graphics window
	 */
	public void drawEmAll( Graphics window )
	{
		for(Ammo e: ammo){
			e.draw(window);
		}
	}

	/**
	 * Moves all of the ammo in the bullets list UP
	 */
	public void moveEmAll()
	{
		for(Ammo e: ammo){
			e.move("DOWN");
		}
	}

	/**
	 * Removes all of the ammo that have gone off the top of the graphics window
	 */
	public void cleanEmUp()
	{
		for(int i = 0; i <ammo.size(); i++){
			if((ammo.get(i).getY()<0)||ammo.get(i).getY()>=StarFighter.HEIGHT)
				ammo.remove(i);
		}
	}

	/**
	 * Gets the list of ammo
	 * @return the list of ammo
	 */
	public List<Ammo> getList()
	{
		return ammo;
	}

	/**
	 * Returns a string version of the bullets 
	 * @return a string version of the bullets
	 */
	public String toString()
	{
		return "";
	}
}
