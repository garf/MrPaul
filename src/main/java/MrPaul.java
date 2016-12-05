import actions.LunchPoll;
import com.ullink.slack.simpleslackapi.SlackSession;
import connections.DirectConnector;
import events.MessageListeners;

import java.io.IOException;

public class MrPaul {
    public static void main(String[] args) throws IOException {
        LunchPoll lunchPoll = new LunchPoll();

        SlackSession session = DirectConnector.getSession(Config.get("token"));

        lunchPoll.greetings(session, Config.get("channel"));

        MessageListeners listener = new MessageListeners(Config.get("channel"));

        listener.slackMessagePostedEventContent(session);
        listener.registeringAListener(session);
    }
}