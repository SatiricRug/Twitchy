package SatiricRug.gui;

import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamGui extends Region {

    private static final Logger log = LoggerFactory.getLogger(StreamGui.class);

    public StreamGui() {
        getStyleClass().add("streamGui");
        ClassLoader classLoader = getClass().getClassLoader();
        String streamFile = classLoader.getResource("http://localhost:7070").toString();
        log.debug("streamFile = {}", streamFile);
        Media media = new Media(streamFile);
        MediaPlayer player = new MediaPlayer(media);
    }
}
