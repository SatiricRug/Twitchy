package gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Gui {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel labelStreamerName;
	private static JLabel labelStreamQuality;
	private static JTextField enterStreamerName;
	private static JTextField enterStreamQuality;
	
	public static final int WIDTH = 152;
	public static final int HEIGHT = 300;
	
	public static void createGui() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int widthMonitor = gd.getDisplayMode().getWidth();
		int heightMonitor = gd.getDisplayMode().getHeight();
		
		frame = new JFrame("Twitchy");
		frame.setBounds(widthMonitor / 2 - WIDTH / 2, heightMonitor / 2 - HEIGHT / 2, WIDTH, HEIGHT);
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent windowEvent){
	    		System.exit(0);
	    	}
	    });
		
		panel = new JPanel(null);
		
		labelStreamerName = new JLabel("Streamer Name:");
		labelStreamerName.setLocation(10, 75);
		labelStreamerName.setSize(labelStreamerName.getPreferredSize());
		
		enterStreamerName = new JTextField(15);
		enterStreamerName.setLocation(10, 95);
		enterStreamerName.setSize(enterStreamerName.getPreferredSize());
		
		labelStreamQuality = new JLabel("Stream Quality:");
		labelStreamQuality.setLocation(10, 125);
		labelStreamQuality.setSize(labelStreamQuality.getPreferredSize());
		
		enterStreamQuality = new JTextField(15);
		enterStreamQuality.setLocation(10, 145);
		enterStreamQuality.setSize(enterStreamQuality.getPreferredSize());
		System.out.println(enterStreamQuality.getPreferredSize().getWidth());
		panel.add(labelStreamerName);
		panel.add(enterStreamerName);
		panel.add(labelStreamQuality);
		panel.add(enterStreamQuality);
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
}
