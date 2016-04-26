package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TwitchAPIv1 {
	
	private static String streamerName;
	
	private static final String STREAM_LIST = "/src/main/resources/streams.txt";
	
	private static String token = null;
	private static String sig = null;
	
	/**
	 * Requests token and signature from the secret Twitch API.
	 * 
	 * Run this before <code> requestStreams()</code>.
	 * @param streamer Name of the streamer to request streams from
	 * @throws IOException
	 */
	public static void requestToken(String streamer) throws IOException {
		streamerName = streamer;
		URL tokenRequestURL = null;
		try {
			tokenRequestURL = new URL("https://api.twitch.tv/api/channels/" + streamerName + "/access_token");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection tokenRequestConnection = (HttpURLConnection) tokenRequestURL.openConnection();
		tokenRequestConnection.connect();

		InputStream tokenRequestStream = tokenRequestConnection.getInputStream();
		String tokenRequestBody = IOUtils.toString(tokenRequestStream, "UTF-8");
		
		JsonObject tokenParser = new JsonParser().parse(tokenRequestBody).getAsJsonObject();
		token = tokenParser.get("token").getAsString();
		sig = tokenParser.get("sig").getAsString();
	}
	
	/**
	 * Gets a file containing information on the streams of the specified streamer.
	 * @return the file of streams
	 * @throws IOException
	 */
	public static File requestStreams() throws IOException {
		// Checks to see if requestToken(streamer) has been run
		if (token == null) {
			throw new NullPointerException("Token null; requestToken(streamer) "
					+ "probably not run before requestStreams()");
		}
		
		URL requestStreamsURL = null;
		try {
			requestStreamsURL = new URL("http://usher.twitch.tv/api/channel/hls/" + streamerName + ".m3u8"
					+ "?player=twitchweb&token=" + token + "&sig=" + sig
					+ "&allow_audio_only=true&allow_source=true&type=any&p=6");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		File file = new File(new File(STREAM_LIST).getAbsolutePath());
		FileUtils.copyURLToFile(requestStreamsURL, file, 15000, 15000); //
		
		return file;
	}
	
	/**
	 * Generates a list of streams from the given file 
	 * @param file File containing the list of streams sent from the API
	 * @return Returns an <code>ArrayList</code> of <code>Stream</code> objects found from
	 * the 
	 * @throws FileNotFoundException
	 * @throws MalformedURLException
	 */
	public static ArrayList<Stream> parseStreamsList(File file) throws FileNotFoundException, MalformedURLException {
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\n|=|,|\"");
		ArrayList<Stream> streams = new ArrayList<Stream>();
		String streamQuality = null, streamBandwidth = null, streamResolution = null;
		URL streamURL = null;
		
		String next;
		while (scanner.hasNext()) {
			next = scanner.next();
//			System.out.println(next);
			switch (next) {
			case "NAME":
				scanner.next();
				streamQuality = scanner.next();
				System.out.println(streamQuality);
				continue;
			case "BANDWIDTH":
				streamBandwidth = scanner.next();
				continue;
			case "RESOLUTION":
				streamResolution = scanner.next();
				scanner.nextLine();
				streamURL = new URL(scanner.nextLine());
				break;
			default:
				continue;
			}
			streams.add(new Stream(streamerName, streamURL, streamQuality, 
					streamBandwidth, streamResolution));
		}
		
		scanner.close();
		
		return streams;
	}
	

	
}
