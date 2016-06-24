package SatiricRug;

/*
 * TODO:
 * Stream loading, but not loading - fix fia https?
 */

import SatiricRug.gui.StreamGui;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static String streamer = "wyld";
	public static String quality = "Low";
	
	public static void main(String[] args) throws Exception {
		StreamGui asdf = new StreamGui();

//		Gui.main(args);

// 		GuiOld.createStreamerNameGui();
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
