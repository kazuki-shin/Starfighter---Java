import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

public class UserInterface {
	
	private int score;
	
	public UserInterface(){
		score = 0;
	}

	public void levelView(Graphics g, int hordeLvl){
		g.setColor(Color.GREEN);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.drawString("Level "+ hordeLvl, 25, 75);
	}
	
	public void timeView(Graphics g, int timeLeft){
		g.setColor(Color.GREEN);
		g.setFont(new Font("TimesRoman", Font .PLAIN, 20)); 
		if(timeLeft>0){
		g.drawString("Time Left: "+ timeLeft, 110, 75);
		}
		else
			g.drawString("Time Left: "+ 0, 110, 75);
	}
	
	public void updateScore(int spareTime){
		score += spareTime;
	}
	
	public int getScore(){
		return score;
	}
	
}
