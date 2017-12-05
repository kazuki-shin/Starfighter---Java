import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * Kazuki Shin
 * Gallatin 
 * 1st Period
 * 9/2/16
 */

public class CustomMessage extends JFrame{
	private String message;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600 ;
	
	public CustomMessage(String message, int size){
		super();
		setSize(WIDTH,HEIGHT);
		this.message = message;
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel(message, SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, size));
		
		panel.add(label);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	
}
