import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class GameRunner {

	public static void main(String[] args){
		GameRunner run = new GameRunner();
	}
	
	public GameRunner(){
        JFrame frame = new JFrame("Game by Kazuki Shin");
		
		//panels
	    JPanel panel = new JPanel();
	    JPanel panel1 = new JPanel (new BorderLayout(2,2));
        JPanel panel2 = new JPanel (new BorderLayout(2,2));
        JPanel buttonPanel = new JPanel(new BorderLayout(2,2));
        panel.setLayout(new BorderLayout());
        
        
        ImageIcon titleImage = new ImageIcon("MenuPic.jpg");
        Image img = titleImage.getImage();  
        Image newimg = img.getScaledInstance(1200,600,  java.awt.Image.SCALE_SMOOTH ) ;  
        titleImage = new ImageIcon( newimg );
        //JLabel label1 = new JLabel(titleImage);
        JButton titleButton = new JButton(titleImage);
        titleButton.setBackground(Color.BLACK);
        titleButton.setOpaque(true);
        titleButton.setBorderPainted(false);
        titleButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	
            }
        });
        
        //start button
        JButton button1 = new JButton ("Start Game");
        CustomButton.makeButton1(button1);
        button1.setFont(new Font("MonoSpaced", Font.BOLD, 65));
        //button1.setForeground(Color.DARK_GRAY);
        button1.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	startGame(frame);
            }
        });
        
        JLabel label3 = new JLabel("Welcome to Star Fighter!", SwingConstants.CENTER);
        label3.setFont(new Font("MonoSpaced",Font.BOLD,50));
        label3.setForeground(Color.GREEN);
        
        panel1.add(label3,BorderLayout.NORTH);
        panel1.add(titleButton, BorderLayout.CENTER);
        panel1.setBackground(Color.BLACK);
        
        buttonPanel.add(button1, BorderLayout.CENTER);
        panel2.add(buttonPanel, BorderLayout.CENTER);

        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        frame.add(panel);
        frame.setBounds(120, 110, 0, 0);
        //Dimension d = new Dimension(1000,500);
        Dimension d = new Dimension(1200,600);
        frame.setPreferredSize(d);
        frame.setResizable(false);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void startGame(JFrame frame)
	{
		frame.dispose();
		StarFighter start = new StarFighter();
		
	}
	
}
