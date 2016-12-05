package actions;

import com.ullink.slack.simpleslackapi.*;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;

public class LunchPoll {

    public void greetings(SlackSession session, String channelName)
    {
        SlackChannel channel = session.findChannelByName(channelName);
        session.sendMessage(channel, "Hey there");
    }

    public void lunchPoll(SlackSession session, SlackMessagePosted event) {
        // Then you can also filter out on the message content itself
        String messageContent = event.getMessageContent();
        if (messageContent.contains("lunch") || messageContent.contains("Lunch")) {
            session.sendMessage(event.getChannel(),"Are you hungry?");
            session.sendMessage(event.getChannel(), "");
        }

        if (messageContent.contains("LUNCH")) {
            session.sendMessage(event.getChannel(),"STOP YELLING AT ME! GO EAT!");
        }

        if (messageContent.contains("React")) {
            SlackMessageHandle message = session.sendMessage(event.getChannel(),"I will try to");
            //TODO: investigate how to get new created message's timestamp.
//            session.addReactionToMessage(event.getChannel(), message.getReply().toString(), ":+1:");
        }
    }
}