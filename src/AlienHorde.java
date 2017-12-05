//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */
/**
 * An AlienHorde represents a group of Aliens
 */
public class AlienHorde
{
	private List<Alien> aliens;
	private int frameH = StarFighter.HEIGHT;
	private int frameW = StarFighter.WIDTH;
	private int sizeOrig, hordeCounter;
	private String type;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>(size);
		type = "Basic";
		hordeCounter = 0;
	}
	
	/**
	 * Constructs an AlienHorde of a specified size
	 * @param size the number of aliens
	 */
	public AlienHorde(String type)
	{
		hordeCounter = 0;
		this.type = type;
		switch(type){
			case "None":
				aliens = new ArrayList<>(0);
				sizeOrig = 0;
				break;
			case "Level_1":
				aliens = new ArrayList<>(1);
				sizeOrig = 1;
				add(new Alien(frameW/2-20,-200,40,40,1)); break;
			case "Level_2":
				aliens = new ArrayList<>(1);
				sizeOrig = 1;
				add(new Alien(frameW/2,(frameH/8)-200,40,40,1));
				add(new Alien(frameW/2+150,(frameH/8)-100-200,40,40,1));
				add(new Alien(frameW/2-150,(frameH/8)-100-200,40,40,1)); break;
			case "Level_3":
				aliens = new ArrayList<Alien>(20);	
				sizeOrig = 20;
				add(new Alien(frameW/2+240,-(frameH/8),40,40,1));
				add(new Alien(frameW/2-300,-(frameH/8),40,40,1));
				add(new Alien(frameW/2+180,-(frameH/8),40,40,1));
				add(new Alien(frameW/2-240,-(frameH/8),40,40,1));
				add(new Alien(frameW/2+120,-(frameH/8),40,40,1));
				add(new Alien(frameW/2-180,-(frameH/8),40,40,1));
				add(new Alien(frameW/2+60,-(frameH/8),40,40,1));
				add(new Alien(frameW/2-120,-(frameH/8),40,40,1));
				add(new Alien(frameW/2,-(frameH/8),40,40,1));
				add(new Alien(frameW/2-60,-(frameH/8),40,40,1));
				add(new Alien(frameW/2+240,-(frameH/4),40,40,1));
				add(new Alien(frameW/2-300,-(frameH/4),40,40,1));
				add(new Alien(frameW/2+180,-(frameH/4),40,40,1));
				add(new Alien(frameW/2-240,-(frameH/4),40,40,1));
				add(new Alien(frameW/2+120,-(frameH/4),40,40,1));
				add(new Alien(frameW/2-180,-(frameH/4),40,40,1));
				add(new Alien(frameW/2+60,-(frameH/4),40,40,1));
			 	add(new Alien(frameW/2-120,-(frameH/4),40,40,1));
			 	add(new Alien(frameW/2,-(frameH/4),40,40,1));
			 	add(new Alien(frameW/2-60,-(frameH/4),40,40,1)); break;
			case "Level_4":
				aliens = new ArrayList<>(11);
				sizeOrig = 11;
				add(new Alien(frameW/2,(frameH/8)-200,40,40,1));
				add(new Alien(frameW/2+60,(frameH/8)-40-200,40,40,1));
				add(new Alien(frameW/2-60,(frameH/8)-40-200,40,40,1));
				add(new Alien(frameW/2+120,(frameH/8)-80-200,40,40,1));
				add(new Alien(frameW/2-120,(frameH/8)-80-200,40,40,1));
				add(new Alien(frameW/2+180,(frameH/8)-120-200,40,40,1));
				add(new Alien(frameW/2-180,(frameH/8)-120-200,40,40,1));
				add(new Alien(frameW/2+240,(frameH/8)-160-200,40,40,1));
				add(new Alien(frameW/2-240,(frameH/8)-160-200,40,40,1));
				add(new Alien(frameW/2+300,(frameH/8)-200-200,40,40,1));
				add(new Alien(frameW/2-300,(frameH/8)-200-200,40,40,1)); break;
			case "Level_5_Left": 
				aliens = new ArrayList<Alien>(7);
				sizeOrig = 7;
				add(new Alien(frameW/2-120+20,-250,40,40,1)); 
				add(new Alien(frameW/2-80+20,-250,40,40,1)); 
				add(new Alien(frameW/2-40+20,-250,40,40,1)); 
				add(new Alien(frameW/2-160+20,-250,40,40,1));
				add(new Alien(frameW/2-120+20,-210,40,40,1));
				add(new Alien(frameW/2-200+20,-250,40,40,1)); 
				add(new Alien(frameW/2-120+20,-170,40,40,1)); break;
			case "Level_5_Right": 
				aliens = new ArrayList<Alien>(7);
				sizeOrig = 7;
				add(new Alien(frameW/2+120-80,-250,40,40,1)); 
				add(new Alien(frameW/2+160-80,-250,40,40,1));
				add(new Alien(frameW/2+120-80,-210,40,40,1));
				add(new Alien(frameW/2+200-80,-250,40,40,1)); 
				add(new Alien(frameW/2+120-80,-170,40,40,1)); 
				add(new Alien(frameW/2+80-80,-250,40,40,1)); 
				add(new Alien(frameW/2+40-80,-250,40,40,1)); break;
		}
	}

	/**
	 * Adds an alien to the horder
	 * @param al the alien
	 */
	public void add(Alien al)
	{
		aliens.add(al);
	}
	
	public List<Alien> getList()
	{
		return aliens;
	}
	
	public int getSizeOrig(){
		return sizeOrig;
	}
	
	public int getHordeCounter(){
		return hordeCounter;
	}

	/**
	 * Draws all of the aliens in the horde
	 * @param window the graphics window
	 */
	public void drawEmAll( Graphics window )
	{
		for(Alien e: aliens){
			e.draw(window);
		}
	}

	/**
	 * Moves the entire alien horde down
	 */
	public void moveEmAll(String dir)
	{
		for(Alien e: aliens){
			switch(dir){
				case "UP": e.move("UP"); break;
				case "DOWN": e.move("DOWN"); break;
				case "LEFT": e.move("LEFT"); break;
				case "RIGHT": e.move("RIGHT"); break;
			}
		}
	}
	
	public void level1(){
		if(getList().size()>0){
			if(hordeCounter<250){
				moveEmAll("DOWN");
			}	
			else if(hordeCounter<500){
				moveEmAll("RIGHT");
			}
			else if(hordeCounter<1000){
				moveEmAll("LEFT");
			}
			else if(hordeCounter<1500){
				moveEmAll("RIGHT");
				if(hordeCounter == 1499)
					hordeCounter = 500;
			}
		}	
		hordeCounter += 1;
	}
	
	public void level2(){
		if(getList().size()>0){
			if(hordeCounter<300)
				moveEmAll("DOWN");
			else if(hordeCounter<500){
				moveEmAll("RIGHT");
			}
			else if(hordeCounter<900){
				moveEmAll("LEFT");
			}
			else if(hordeCounter<1100){
				moveEmAll("RIGHT");
				if(hordeCounter == 1099)
					hordeCounter = 300;
			}
		}	
		hordeCounter += 1;
	}
	
	public void level3(){
		if(getList().size()>0){
			if(hordeCounter<250){
				moveEmAll("DOWN");
			}	
			else if(hordeCounter<350){
				moveEmAll("RIGHT");
			}
			else if(hordeCounter<400){
				moveEmAll("DOWN");
			}
			else if(hordeCounter<600){
				moveEmAll("LEFT");
			}
			else if(hordeCounter<650){
				moveEmAll("UP");
			}
			else if(hordeCounter<750){
				moveEmAll("RIGHT");
				if(hordeCounter == 749 )
					hordeCounter = 250;
			}
		}	
		hordeCounter += 1;
	}
	
	public void level4(){
		if(getList().size()>0){
			if(hordeCounter<400)
				moveEmAll("DOWN");
			else if(hordeCounter<440){
				moveEmAll("RIGHT");
			}
			else if(hordeCounter<520){
				moveEmAll("LEFT");
			}
			else if(hordeCounter<560){
				moveEmAll("RIGHT");
				if(hordeCounter == 559)
					hordeCounter = 400;
			}
		}	
		hordeCounter += 1;
	}
	
	public void level5left(){
		if(getList().size()>0){
			if(hordeCounter<300){
				moveEmAll("DOWN");
			}
			else if(hordeCounter<500){
				moveEmAll("LEFT");
				moveEmAll("DOWN");
			}
			else if(hordeCounter<700){
				moveEmAll("UP");
			}
			else if(hordeCounter<900){
				moveEmAll("RIGHT");
				if(hordeCounter==899)
					hordeCounter = 300;
			}
		}
		hordeCounter++;
	}
	
	public void level5right(){
		if(getList().size()>0){
			if(hordeCounter<300){
				moveEmAll("DOWN");
			}
			else if(hordeCounter<500){
				moveEmAll("RIGHT");
				moveEmAll("DOWN");
			}
			else if(hordeCounter<700){
				moveEmAll("UP");
			}
			else if(hordeCounter<900){
				moveEmAll("LEFT");
				if(hordeCounter==899)
					hordeCounter = 300;
			}
		}
		hordeCounter++;
	}

	/**
	 * Checks for collisions between active ammo and aliens in the horde and removes
	 * any ammo and alien that have collided
	 * @param shots the list of Ammo to check
	 */
	public void removeDeadOnes(List<Ammo> shots)
	{
		
		for(int alien = 0; alien < aliens.size(); alien++){
			for(int ammo = 0; ammo < shots.size(); ammo++){
				if(aliens.size()!=0 && aliens.size()>alien){
					int alienLeft = aliens.get(alien).getX();
					int alienRight = alienLeft+aliens.get(alien).getWidth();
					int alienTop = aliens.get(alien).getY();
					int alienBottom = alienTop + aliens.get(alien).getHeight();
					int ammoLeft = shots.get(ammo).getX();
					int ammoRight = ammoLeft + shots.get(ammo).getWidth();
					int ammoTop = shots.get(ammo).getY();
					int ammoBottom = ammoTop + shots.get(ammo).getHeight();
					
					if( ( ((ammoLeft>=alienLeft)&&(ammoLeft<=alienRight)) ||
						  ((ammoRight<=alienRight)&&(ammoRight>=alienLeft)) ) &&
						( ((ammoTop<=alienBottom)&&(ammoTop>=alienTop)) ||
						  ((ammoBottom<=alienBottom)&&(ammoBottom>=alienTop)) ) 
							){
						aliens.remove(alien);
						shots.remove(ammo);
					}
				}
			}
		}
	}

	/**
	 * Returns a String version of the alien horde
	 * NOTE:  just use the ArrayList toString
	 */
	public String toString()
	{
		return "";
	}
}
