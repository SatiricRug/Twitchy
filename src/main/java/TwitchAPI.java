package main.java;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TwitchAPI {
	
	private static final String CLIENT_ID = "tu0ysndx771w4gz8prznvuhhikv0myx";
	/** user_read+chat_login**/
	private static final String ACCESS_TOKEN = "a00qwywmcrbm7gayoopxovguatutxd";
	
	private static String streamerName;
	
	private static final String STREAM_LIST = "/src/main/resources/streams.txt";
	
	private static String token = null;
	private static String sig = null;
	
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
	
	//ArrayList<Stream>
	public static ArrayList<Stream> requestStreams() throws IOException {
		URL requestStreamsURL = null;
		try {
			requestStreamsURL = new URL("http://usher.twitch.tv/api/channel/hls/" + streamerName + ".m3u8"
					+ "?player=twitchweb&token=" + token + "&sig=" + sig
					+ "&allow_audio_only=true&allow_source=true&type=any&p=6");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		File file = new File(new File(STREAM_LIST).getAbsolutePath());
		FileUtils.copyURLToFile(requestStreamsURL, file, 15000, 15000); //timeouts
		
		return parseStreamsList(file);
	}
	
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
	
	/**
	 * Authenticates the application with the Twitch API.
	 * @deprecated Doesn't actually work.
	 */
	protected static void authenticate() throws Exception {
		FileReader configReader = new FileReader("src/config.dat");
		URI authURI = new URI("https://api.twitch.tv/kraken/oauth2/authorize" +
				"?response_type=token" +
				"&client_id=" + CLIENT_ID +
				"&redirect_uri=http://localhost" +
				"&scope=user_read+chat_login");
		if (configReader.read() == -1) {
			Desktop.getDesktop().browse(authURI);
		}
		configReader.close();
		
		URL authURL = authURI.toURL();
		
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection connection = (HttpURLConnection) authURL.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		ArrayList<String> headers = new ArrayList<String>();
		headers.add(connection.getHeaderField(0));
		for (int i = 0; headers.get(i) != null;) {
			System.out.println(i + " " + headers.get(i));
			i++;
			headers.add(connection.getHeaderFieldKey(i) + connection.getHeaderField(i));
		}
		System.out.println(connection.getURL());
	}
	
}
