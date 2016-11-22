package SatiricRug.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField streamerName;
    @FXML private ChoiceBox streamQuality;

    @FXML
    protected void handleWatchNowButtonAction(ActionEvent event) {
        String streamerNameStr = streamerName.getText();
        String streamQualityStr = (String) streamQuality.getValue();
        System.out.println("streamer = " + streamerNameStr +
                " quality = " + streamQualityStr);
    }
}
