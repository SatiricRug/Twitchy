package SatiricRug;

/*
 * TODO:
 * Authenticate w/ Twitch API
 * Access followed streamers that are currently streaming
 * Input streamer and stream quality
 * output stream
 * output chat
 */

import SatiricRug.gui.Gui;

public class Main {
	
	public static String streamer = "wyld";
	public static String quality = "Low";
	
	public static void main(String[] args) throws Exception {
		Gui.main(args);
//		GuiOld.createStreamerNameGui();
//		TwitchAPIv1.requestToken(streamer);
//		InputStream streamsStream = TwitchAPIv1.requestStreams();
//		ArrayList<Stream> streams = TwitchAPIv1.parseStreamsList(streamsStream);

//		System.out.println(streams.get(0).getStreamURL().toString());
//
//		for (Stream stream: streams) {
//			String streamQuality = stream.getStreamQuality();
//			if (streamQuality.equals(quality)) {
//				Runtime rt = Runtime.getRuntime();
//				@SuppressWarnings("unused")
//				Process pr = rt.exec("C:\\Users\\pjsch_000\\Desktop\\vlc-2.1.5\\vlc.exe " + stream.getStreamURL().toString());
//			}
//		}
	}

}
