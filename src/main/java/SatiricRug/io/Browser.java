package SatiricRug.io;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser extends Region {

    private static final Logger log = LoggerFactory.getLogger(Browser.class);

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    //http://www.oracle.com/products/index.html

    public Browser(String url) {
        getStyleClass().add("browser");
        webEngine.setJavaScriptEnabled(true);
        //webEngine.load(url);
        webEngine.loadContent("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<iframe" +
                "        src=\"http://player.twitch.tv/?channel=food" +
                "        height=\"720\"" +
                "        width=\"1280\"" +
                "        frameborder=\"0\"" +
                "        scrolling=\"no\"" +
                "        allowfullscreen=\"true\">" +
                "</iframe>" +
                "</body>" +
                "</html>");
        getChildren().add(browser);
        log.debug("Started browser");
    }

    public void executeScript(String script) {
        webEngine.executeScript(script);
    }

    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;

    }

    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }

    @Override protected double computePrefWidth(double height) {
        return 854;
    }

    @Override protected double computePrefHeight(double width) {
        return 480;
    }
}
