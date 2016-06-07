import java.io.File;
import java.util.ArrayList;

//import api.Stream;
//import api.TwitchAPIv1;
import gui.Gui;

/*
 * TODO:
 * Authenticate w/ Twitch API
 * Access followed streamers that are currently streaming
 * Input streamer and stream quality
 * output stream
 * output chat
 */

public class Main {
	
	public static String streamer = "food";
	public static String quality = "Low";
	
	public static void main(String[] args) throws Exception {
		Gui.createGui();
		TwitchAPIv1.requestToken(streamer);
//		File file = TwitchAPIv1.requestStreams();
//		ArrayList<Stream> streams = TwitchAPIv1.parseStreamsList(file);
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
