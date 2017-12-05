//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Period -

//*** No changes will be made to this class

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

/**
 * Represents the environment for running a StarFighter game
 */
public class StarFighter extends JFrame
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600 ;

	/**
	 * Constructs a StarFighter JFrame
	 */
	public StarFighter()
	{	
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);
		
		getContentPane().add(theGame);

        setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}