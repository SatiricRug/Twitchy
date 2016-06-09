package SatiricRug.api;

import java.awt.Desktop;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class TwitchAPIv3 {

	private static final String CLIENT_ID = "tu0ysndx771w4gz8prznvuhhikv0myx";

	/** user_read+chat_login**/
	@SuppressWarnings("unused")
	private static final String ACCESS_TOKEN = "a00qwywmcrbm7gayoopxovguatutxd";
	
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
