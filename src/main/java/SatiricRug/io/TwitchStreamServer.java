package SatiricRug.io;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;

/**
 * Hosts twitchStream.html for use by SatiricRug.io.Browser
 */
public class TwitchStreamServer {

    /**
     * starts the server
     */
    public static void start(String channel) throws Exception {
        Server server = new Server(7070);
        TwitchStreamHandler twitchStreamHandler = new TwitchStreamHandler(channel);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {twitchStreamHandler, new DefaultHandler()});
        server.setHandler(handlers);
        server.setStopAtShutdown(true);
        server.start();
    }
}
