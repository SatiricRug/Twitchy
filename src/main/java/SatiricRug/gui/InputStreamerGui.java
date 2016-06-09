package SatiricRug.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InputStreamerGui {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel labelStreamerName;
	private static JLabel labelStreamQuality;
	private static JTextField enterStreamerName;
	private static JTextField enterStreamQuality;
	private static JButton go;

	public static final int WIDTH = 152;
	public static final int HEIGHT = 150;

	public static void createGui() throws Exception {
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
		labelStreamerName.setLocation(10, 10);
		labelStreamerName.setSize(labelStreamerName.getPreferredSize());

		enterStreamerName = new JTextField(15);
		enterStreamerName.setLocation(10, 30);
		enterStreamerName.setSize(enterStreamerName.getPreferredSize());

		go = new JButton("Continue");
		go.setLocation(10, 60);
		go.setSize(go.getPreferredSize());

		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		} );

		panel.add(labelStreamerName);
		panel.add(enterStreamerName);
		panel.add(go);
		frame.add(panel);

		frame.setVisible(true);
	}

//	public static void createGui() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//		int widthMonitor = gd.getDisplayMode().getWidth();
//		int heightMonitor = gd.getDisplayMode().getHeight();
//
//		frame = new JFrame("Twitchy");
//		frame.setBounds(widthMonitor / 2 - WIDTH / 2, heightMonitor / 2 - HEIGHT / 2, WIDTH, HEIGHT);
//		frame.setResizable(false);
//
//		frame.addWindowListener(new WindowAdapter() {
//	    	public void windowClosing(WindowEvent windowEvent){
//	    		System.exit(0);
//	    	}
//	    });
//
//		panel = new JPanel(null);
//
//		labelStreamerName = new JLabel("Streamer Name:");
//		labelStreamerName.setLocation(10, 10);
//		labelStreamerName.setSize(labelStreamerName.getPreferredSize());
//
//		enterStreamerName = new JTextField(15);
//		enterStreamerName.setLocation(10, 30);
//		enterStreamerName.setSize(enterStreamerName.getPreferredSize());
//
//		labelStreamQuality = new JLabel("Stream Quality:");
//		labelStreamQuality.setLocation(10, 60);
//		labelStreamQuality.setSize(labelStreamQuality.getPreferredSize());
//
//		enterStreamQuality = new JTextField(15);
//		enterStreamQuality.setLocation(10, 80);
//		enterStreamQuality.setSize(enterStreamQuality.getPreferredSize());
//
//		go = new JButton("Go");
//		go.setLocation(10, 110);
//		go.setSize(go.getPreferredSize());
//
//		panel.add(labelStreamerName);
//		panel.add(enterStreamerName);
//		panel.add(labelStreamQuality);
//		panel.add(enterStreamQuality);
//		panel.add(go);
//		frame.add(panel);
//
//		frame.setVisible(true);
//	}
	
}
