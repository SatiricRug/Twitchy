package SatiricRug.io;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwitchStreamHandler extends AbstractHandler {

    private String channel;

    public TwitchStreamHandler(String channel) {
        super();
        this.channel = channel;
    }

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        ClassLoader classLoader = getClass().getClassLoader();
        File twitchStreamFile = new File(classLoader.getResource("twitchStream.html").getFile());
        Scanner scanner = new Scanner(twitchStreamFile);
        String nextLine;
        while (scanner.hasNext()) {
            nextLine = scanner.nextLine();
            if (nextLine.contains("src=")) {
                nextLine = nextLine + channel + "\"";
            }
            response.getWriter().println(nextLine);
        }
        scanner.close();
    }
}
