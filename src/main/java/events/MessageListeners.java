package events;

import actions.LunchPoll;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.SlackUser;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageListeners
{
    private static final Logger logger = LoggerFactory.getLogger(MessageListeners.class);

    public void registeringAListener(SlackSession session)
    {
        // first define the listener
        SlackMessagePostedListener messagePostedListener = (event, session1) -> {
            SlackChannel channelOnWhichMessageWasPosted = event.getChannel();
            String messageContent = event.getMessageContent();
            SlackUser messageSender = event.getSender();

        };
        //add it to the session
        session.addMessagePostedListener(messagePostedListener);

        //that's it, the listener will get every message post events the bot can get notified on
        //(IE: the messages sent on channels it joined or sent directly to it)
    }

    /**
     * This method demonstrate what is available in a SlackMessagePosted event
     */
    public void slackMessagePostedEventContent(SlackSession session)
    {
        session.addMessagePostedListener((event, session1) -> {
            logger.debug(event.getMessageContent());

            LunchPoll poll = new LunchPoll();

            String messageContent = event.getMessageContent();

            poll.addReactionPoll(session1, event);

            // Not for me! Ignore.
            if (
                !messageContent.contains("@" + session1.sessionPersona().getId())
            ) {
                return;
            }

            poll.lunchPoll(session1, event);
        });
    }

}
