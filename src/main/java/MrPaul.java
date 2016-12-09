import actions.LunchPoll;
import com.ullink.slack.simpleslackapi.SlackSession;
import connections.DirectConnector;
import events.MessageListeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class MrPaul {
    private static final Logger logger = LoggerFactory.getLogger(MessageListeners.class);

    public static void main(String[] args) throws IOException {
        LunchPoll lunchPoll = new LunchPoll();

        String token = args.length > 0 && args[0] != null ? args[0] : Config.get("BOT_SLACK_TOKEN");
        String channel = args.length > 1 && args[1] != null ? args[1] : Config.get("BOT_SLACK_CHANNEL");
        channel = channel == null ? "random" : channel;

        logger.debug("TOKEN: " + (token != null ? "TOKEN SET ( ALL GOOD )" : "!!! TOKEN EMPTY !!!"));
        logger.debug("CHANNEL: " + channel);

        SlackSession session = DirectConnector.getSession(token);

        session.joinChannel(channel);
        lunchPoll.greetings(session, channel);

        MessageListeners listener = new MessageListeners();

        listener.slackMessagePostedEventContent(session);
        listener.registeringAListener(session);
    }
}
