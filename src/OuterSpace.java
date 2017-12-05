//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JOptionPane;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

/**
 * Represents the graphic environment of the StarFighter game
 */
public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private int mainCounter, hordeLvl, timeCounter, timeLimit, timeLeft;
	private AlienHorde horde, horde2;
	private Bullets shots, alienShots, alienShots2;
	private HealthBar health;
	private boolean isLvl2, isLvl3, isLvl4, isLvl5,isLvl6;
	private UserInterface user;
	
	private boolean[] keys;
	private BufferedImage back;

	/**
	 * Creates an OuterSpace object
	 */
	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables when ready
		//Ship, Alien, etc
		//Your ship should be at least 40 x 40
		ship = new Ship(350,450,70, 70, 2);
		shots = new Bullets();
		horde = new AlienHorde("Level_1");
		horde2 = new AlienHorde("None");
		alienShots = new Bullets();
		alienShots2 = new Bullets();
		health = new HealthBar(200);
		user = new UserInterface();
		hordeLvl = 1;
		mainCounter = 0;
		timeCounter = 0;
		timeLimit = 2500;
		timeLeft = timeLimit-timeCounter;
		isLvl2 = false;
		isLvl3 = false;
		isLvl4 = false;
		isLvl5 = false;
		isLvl6 = false;

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	/**
	 * Updates the graphics window
	 * @param window the graphics window
	 */
	public void update(Graphics window)
	{
		paint(window);
	}

	/**
	 * Updates the contents of the graphics window using double buffering
	 * @param window the graphics window
	 */
	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		//Ship Actions
		if(keys[0]) // See keyPressed and keyReleased methods below
			ship.move("LEFT");
		if(keys[1])
			ship.move("RIGHT");
		if(keys[2])
			ship.move("UP");
		if(keys[3])
			ship.move("DOWN");
		if(keys[4])
		{
			ship.shoot(shots);
			keys[4] = false;
		}
		if(mainCounter%2==0)
			shots.moveEmAll("UP");
		ship.takeDamage(alienShots);
		ship.takeDamage(alienShots2);
		if((ship.getHp()==0)||(timeLeft==0))
		{
			CustomMessage lost = new CustomMessage(":0 You lost fam :( Your Score: "+ user.getScore(),50);
			ship.setHp(ship.getHp()-1);
			timeLimit = 0;
		}
		//Alien actions
		switch(hordeLvl){
			case 0: break;
			case 1:
				horde.level1(); 
				break;
			case 2:
				if(!isLvl2) {
					horde = new AlienHorde("Level_2"); 
					if(timeLeft > 0)
						user.updateScore(timeLeft/100);
					timeCounter = 0;
					timeLimit = 4000;
					isLvl2 = !isLvl2;
				}
				horde.level2(); break;
			case 3:
				if(!isLvl3) {
					horde = new AlienHorde("Level_3"); 
					if(timeLeft > 0)
						user.updateScore(timeLeft/100);
					timeCounter = 0;
					timeLimit = 5000;
					isLvl3 = !isLvl3;
				}
				horde.level3();  break;
			case 4:  
				if(!isLvl4) {
					horde = new AlienHorde("Level_4"); 
					if(timeLeft > 0)
						user.updateScore(timeLeft/100);
					timeCounter = 0;
					timeLimit = 6000;
					isLvl4 = !isLvl4;
				}
				horde.level4(); break;
			case 5:
				if(!isLvl5){
					horde = new AlienHorde("Level_5_Left");
					horde2= new AlienHorde("Level_5_Right");
					if(timeLeft > 0)
						user.updateScore(timeLeft/100);
					timeCounter = 0;
					timeLimit = 7000;
					isLvl5 = !isLvl5;
				}
				horde.level5left();
				horde2.level5right(); break;
			case 6: CustomMessage won = new CustomMessage("You Beat The Game!! Your Score: "+ user.getScore(), 30);
					  ship.setHp(1); timeLimit = 0; break;
		}
		
		//if(((horde.getList().size()<=0)&&((hordeLvl==1)||(hordeLvl==2)))||(((horde.getList().size()<=0)&&(horde2.getList().size()<=0))&&(hordeLvl==3)))
		if((horde.getList().size()<=0)&&(horde2.getList().size()<=0))	
			hordeLvl++;
		
		shots.removeDone();
		alienShoot();
		alienShoot2();
		horde.removeDeadOnes(shots.getList());
		horde2.removeDeadOnes(shots.getList());

		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		while(health.getHealth()>ship.getHp())
		{
			health.setHealth(health.getHealth()-1);
			health.draw(graphToBack);
		}
		
		//add code to draw all of the stuff when ready.  Draw everything to graphToBack.
		ship.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		alienShots.drawEmAll(graphToBack);
		alienShots2.drawEmAll(graphToBack);
		horde.drawEmAll(graphToBack);
		horde2.drawEmAll(graphToBack);
		health.draw(graphToBack);
		mainCounter++;
		timeCounter++;
		//user interface
		user.levelView(graphToBack, hordeLvl);
		timeLeft = timeLimit-timeCounter;
		user.timeView(graphToBack, timeLeft/100);
		
		twoDGraph.drawImage(back, null, 0, 0); // draw	s the drawn image to the screen all at once
	}

	private void alienShoot(){
		if(horde.getList().size()>0){
			if((mainCounter%(50)==0)&&(horde.getList().size()>0)&&(hordeLvl==1))
				horde.getList().get((int)(Math.random()*(horde.getList().size()))).shoot(alienShots);
			if((mainCounter%(20)==0)&&(horde.getList().size()>0)&&(hordeLvl==2))
				horde.getList().get((int)(Math.random()*(horde.getList().size()))).shoot(alienShots);
			if((mainCounter%(10)==0)&&(horde.getList().size()>0)&&(hordeLvl==3))
				horde.getList().get((int)(Math.random()*(horde.getList().size()))).shoot(alienShots);
			if((mainCounter%(30)==0)&&(horde.getList().size()>0)&&(hordeLvl==4))
				horde.getList().get((int)(Math.random()*(horde.getList().size()))).shoot(alienShots);
			if((mainCounter%(50)==0)&&(horde.getList().size()>0)&&(hordeLvl==5))
				horde.getList().get((int)(Math.random()*(horde.getList().size()))).shoot(alienShots);
			
		}
		alienShots.moveEmAll("DOWN");
		if((hordeLvl==5)&&!((horde.getHordeCounter()<700)&&(horde.getHordeCounter()>500)))
			alienShots.moveEmAll("RIGHT");
	}
	private void alienShoot2(){
		if(horde2.getList().size()>0)
		{
			if((mainCounter%(50)==0)&&(horde2.getList().size()>0)&&(hordeLvl==1))
				horde2.getList().get((int)(Math.random()*(horde2.getList().size()))).shoot(alienShots2);
			if((mainCounter%(20)==0)&&(horde2.getList().size()>0)&&(hordeLvl==2))
				horde2.getList().get((int)(Math.random()*(horde2.getList().size()))).shoot(alienShots2);
			if((mainCounter%(10)==0)&&(horde2.getList().size()>0)&&(hordeLvl==3))
				horde2.getList().get((int)(Math.random()*(horde2.getList().size()))).shoot(alienShots2);
			if((mainCounter%(30)==0)&&(horde2.getList().size()>0)&&(hordeLvl==4))
				horde2.getList().get((int)(Math.random()*(horde2.getList().size()))).shoot(alienShots2);
			if((mainCounter%(50)==0)&&(horde2.getList().size()>0)&&(hordeLvl==5))
				horde2.getList().get((int)(Math.random()*(horde2.getList().size()))).shoot(alienShots2);
			
		}
		alienShots2.moveEmAll("DOWN");
		if(hordeLvl==5 && !((horde2.getHordeCounter()<700)&&(horde2.getHordeCounter()>500)))
			alienShots2.moveEmAll("LEFT");
	}
	
	public int getHordeLvl(){
		return hordeLvl;
	}
	
	
	/**
	 * Updates the keys array based on the key that was pressed
	 * Uses the arrow keys left, right, up and down
	 * @param e the KeyEvent representing the pressed key
	 */
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	/**
	 * Updates the keys array based on the key that was released
	 * @param e the KeyEvent representing the released key
	 */
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	/**
	 * Needed to satisfy the KeyListener
	 * @param e not used
	 */
	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

	/**
	 * Runs the thread in an infinite loop with a pause of 5 miliseconds between updates
	 */
   	public void run()
   	{
   		try
   		{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	           repaint();
	        }
      	}
      	catch(Exception e)
      	{
      	}
  	}
}

