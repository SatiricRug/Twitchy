package SatiricRug.gui;

import SatiricRug.io.Browser;
import SatiricRug.io.TwitchStreamServer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class Gui extends Application {

    private static final Logger log = LoggerFactory.getLogger(Gui.class);

    private Scene scene;

    private int defaultPort = 7070;

    @Override public void start(Stage stage) {
        stage.setTitle("Twitchy");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Hello.");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 1, 1);

        Label streamerName = new Label("Streamer Name:");
        grid.add(streamerName, 0, 1);

        TextField streamerTextField = new TextField();
        grid.add(streamerTextField, 1, 1);

        Button goButton = new Button("Watch");
        HBox goHBox = new HBox(10);
        goHBox.setAlignment(Pos.BOTTOM_RIGHT);
        goHBox.getChildren().add(goButton);
        grid.add(goHBox, 1, 3);

        goButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClassLoader classLoader = getClass().getClassLoader();
                File twitchStreamFile = new File(classLoader.getResource("twitchStream.html").getFile());
                String channel = streamerTextField.getText();
                log.debug("Showing channel \"{}\"", channel);

                //start the server
                TwitchStreamServer server = new TwitchStreamServer(channel, defaultPort);
                try {
 //                   server.start();
                } catch (Exception e) {
                    log.error("Unable to stop server");
                    e.printStackTrace();
                }
                Browser browser = new Browser("http://localhost:" + server.getPort());
                scene = new Scene(browser, 1300, 1000, Color.web("#666970")); // + "?channel=" + streamerTextField.getText()
                stage.setScene(scene);
                stage.show();
            }
        });

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        Scene scene = new Scene(grid);

        //scene = new Scene(new Browser(),854,480, Color.web("#666970"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
