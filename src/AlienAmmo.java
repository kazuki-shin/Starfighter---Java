import java.awt.Color;
/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

public class AlienAmmo extends Ammo{
	public AlienAmmo(int x, int y, int w, int h, int s)
	{
		//add code
		super(x,y,w,h,s);
		setColor(Color.RED);
	}
}
