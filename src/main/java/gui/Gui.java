package main.java.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gui {
	
	public static JFrame frame;
	public static JPanel panel;
	public static JLabel labelStreamerName;
	public static JLabel labelStreamQuality;
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	public static void createGui() {
		frame = new JFrame("Twitchy");
		frame.setBounds(1920 / 2 - WIDTH / 2, 1080 / 2 - HEIGHT / 2, WIDTH, HEIGHT);
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent windowEvent){
	    		System.exit(0);
	    	}
	    });
		
		panel = new JPanel();
		
		labelStreamerName = new JLabel("Streamer Name:", SwingConstants.LEFT);
		labelStreamerName.setBounds(100, 100, 100, 100);
		labelStreamQuality = new JLabel("Stream Quality:", SwingConstants.LEFT);
		
		panel.add(labelStreamerName);
//		panel.add(labelStreamQuality);
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
}
