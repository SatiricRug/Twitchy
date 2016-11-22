package SatiricRug;

/*
 * TODO:
 * Stream loading, but not loading - fix fia https?
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../../resources/main/SatiricRug/gui/choose_stream.fxml"));
        primaryStage.setTitle("Twitch");
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();
    }

	public static void main(String[] args) throws Exception {

        launch(args);

//		TwitchAPIv1.requestToken(streamer);
//		InputStream streamsStream = TwitchAPIv1.requestStreams();
//		ArrayList<Stream> streams = TwitchAPIv1.parseStreamsList(streamsStream);
//
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
