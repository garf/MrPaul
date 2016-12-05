package actions;

import com.ullink.slack.simpleslackapi.*;

public class LunchPoll {

    public void createLunchPoll(SlackSession session, String channelName)
    {
        SlackChannel channel = session.findChannelByName(channelName);
        session.sendMessage(channel, "Hey there");
    }
}