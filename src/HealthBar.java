import java.awt.Color;
import java.awt.Graphics;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

public class HealthBar {
	
	int health;
	
	public HealthBar(int health){
		this.health = health;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int val){
		health = val;
	}
	
	public void draw(Graphics window){
		window.setColor(Color.green);
		window.fillRect(20, 20, health, 30);
		window.setColor(Color.WHITE);
		window.drawRect(20, 20, 200, 30);
		
	}

}
