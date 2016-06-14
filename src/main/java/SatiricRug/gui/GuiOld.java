package SatiricRug.gui;

import SatiricRug.api.TwitchAPIv3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static javax.swing.SwingConstants.RIGHT;

public class GuiOld {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel labelName;
	private static JLabel labelErrorBadName;
	private static JTextField enterName;
	private static JButton go;

	public static final int WIDTH = 152;
	public static final int HEIGHT = 200;

	public static void createStreamerNameGui() throws Exception {
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

		labelErrorBadName = new JLabel("Error: Unknown username", RIGHT);
		labelErrorBadName.setLocation(37, 55);
		labelErrorBadName.setSize(labelErrorBadName.getPreferredSize());
		labelErrorBadName.setForeground(Color.red);
		labelErrorBadName.setVisible(false);

		labelName = new JLabel("Streamer Name:");
		labelName.setLocation(10, 10);
		labelName.setSize(labelName.getPreferredSize());

		enterName = new JTextField(15);
		enterName.setLocation(10, 30);
		enterName.setSize(enterName.getPreferredSize());

		go = new JButton("Continue");
		go.setLocation(10, 80);
		go.setSize(go.getPreferredSize());

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String channel = enterName.getText();
				try {
					if (TwitchAPIv3.isStreaming(channel)) {

                    } else {
						if (TwitchAPIv3.doesExist(channel)) {

						} else {

						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};

		enterName.addActionListener(al);
		go.addActionListener(al);

		panel.add(labelName);
		panel.add(enterName);
		panel.add(labelErrorBadName);
		panel.add(go);

		frame.add(panel);

		frame.setVisible(true);

	}

//	private static void updateGui() throws IOException {
//		TwitchAPIv1.requestToken(enterName.getText());
//		labelName.setVisible(false);
//		enterName.setVisible(false);
//		labelErrorBadName.setVisible(false);
//		labelQuality.setVisible(true);
//		enterQuality.setVisible(true);
//		InputStream streamsStream = TwitchAPIv1.requestStreams();
//		ArrayList<Stream> streams = TwitchAPIv1.parseStreamsList(streamsStream);
//		enterQuality.removeAllItems();
//		for (Stream stream: streams) {
//			enterQuality.addItem(stream.getStreamQuality());
//		}
//	}

//	public static void createStreamerNameGui() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
//		labelName = new JLabel("Streamer Name:");
//		labelName.setLocation(10, 10);
//		labelName.setSize(labelName.getPreferredSize());
//
//		enterName = new JTextField(15);
//		enterName.setLocation(10, 30);
//		enterName.setSize(enterName.getPreferredSize());
//
//		labelQuality = new JLabel("Stream Quality:");
//		labelQuality.setLocation(10, 60);
//		labelQuality.setSize(labelQuality.getPreferredSize());
//
//		enterQuality = new JTextField(15);
//		enterQuality.setLocation(10, 80);
//		enterQuality.setSize(enterQuality.getPreferredSize());
//
//		go = new JButton("Go");
//		go.setLocation(10, 110);
//		go.setSize(go.getPreferredSize());
//
//		panel.add(labelName);
//		panel.add(enterName);
//		panel.add(labelQuality);
//		panel.add(enterQuality);
//		panel.add(go);
//		frame.add(panel);
//
//		frame.setVisible(true);
//	}
	
}
