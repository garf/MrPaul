package events;

import actions.LunchPoll;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.SlackUser;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener;

public class MessageListeners
{
    private String channel = "random";

    public MessageListeners(String channel) {
        this.channel = channel;
    }

    public void registeringAListener(SlackSession session)
    {
        // first define the listener
        SlackMessagePostedListener messagePostedListener = new SlackMessagePostedListener()
        {
            @Override
            public void onEvent(SlackMessagePosted event, SlackSession session)
            {
                SlackChannel channelOnWhichMessageWasPosted = event.getChannel();
                String messageContent = event.getMessageContent();
                SlackUser messageSender = event.getSender();

            }
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
        session.addMessagePostedListener(new SlackMessagePostedListener()
        {
            @Override
            public void onEvent(SlackMessagePosted event, SlackSession session1)
            {
                // if I'm only interested on a certain channel :
                // I can filter out messages coming from other channels
                SlackChannel theChannel = session1.findChannelByName(channel);

                if (!theChannel.getId().equals(event.getChannel().getId())) {
                    return;
                }

                // How to avoid message the bot send (yes it is receiving notification for its own messages)
                // session.sessionPersona() returns the user this session represents
                if (session1.sessionPersona().getId().equals(event.getSender().getId())) {
                    return;
                }

                LunchPoll poll = new LunchPoll();
                poll.lunchPoll(session1, event);
            }
        });
    }

}