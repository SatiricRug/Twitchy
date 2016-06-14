package SatiricRug.gui;

import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;


public class Gui extends Application {
    private Scene scene;
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
                //WORKING HERE - get file path of twitchStream.html
                File twitchStream = new File(System.getProperty("user.dir"));
                System.out.println(twitchStream.getAbsolutePath());
//                scene = new Scene(new Browser(),854,480, Color.web("#666970"));
//                stage.setScene(scene);
//                stage.show();
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
