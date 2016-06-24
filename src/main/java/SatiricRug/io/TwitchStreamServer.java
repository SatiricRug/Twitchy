package SatiricRug.io;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hosts twitchStream.html for use by SatiricRug.io.Browser
 */
public class TwitchStreamServer {

    private static final Logger log = LoggerFactory.getLogger(TwitchStreamServer.class);

    private String channel;
    private int port;
    private Server server;

    public TwitchStreamServer(String channel, int port) {
        this.channel = channel;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    /**
     * starts the server
     */
    public void start() throws Exception {
        server = new Server(port);
        TwitchStreamHandler twitchStreamHandler = new TwitchStreamHandler(channel);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {twitchStreamHandler, new DefaultHandler()});
        server.setHandler(handlers);
        server.setStopAtShutdown(true);

        // if server fails to start, the specified port is probably in use - this tries again with a different port
        try {
            server.start();
        } catch (Exception e) {
            server.stop();
            port++;
            log.debug("Port {} in use, trying to start server on port {}", port - 1, port);
            start();
        } finally {
            log.debug("Successfully started server on port {}", port);
        }
    }

    public void stop() throws Exception {
        server.stop();
    }
}
