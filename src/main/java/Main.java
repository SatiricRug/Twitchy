package main.java;

import java.util.ArrayList;

/*
 * TODO:
 * Authenticate w/ Twitch API
 * Access followed streamers that are currently streaming
 * Input streamer and stream quality
 * output stream
 * output chat
 */

public class Main {
	
	public static String streamer;
	public static String quality;
	
	public static void main(String[] args) throws Exception {
		TwitchAPI.requestToken("food");
		ArrayList<Stream> streams = TwitchAPI.requestStreams();
		for (Stream stream: streams) {
			String streamQuality = stream.getStreamQuality();
			if (streamQuality.equals("Low")) {
				Runtime rt = Runtime.getRuntime();
				Process pr = rt.exec("C:\\Users\\pjsch_000\\Desktop\\vlc-2.1.5\\vlc.exe " + stream.getStreamURL().toString());
			}
		}
	}
	
}
