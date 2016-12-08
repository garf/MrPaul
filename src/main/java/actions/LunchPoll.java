package actions;

import com.ullink.slack.simpleslackapi.*;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;

public class LunchPoll {

    private String[] nums = {
        "zero", "one", "two",
        "three", "four", "five",
        "six", "seven", "eight",
        "nine", "ten"
    };

    private String[] places = {
        "Italian",
        "Asian",
        "Burger",
        "Cafe Ole",
        "Greece",
        "Doner",
        "Greece",
        "Edeka",
    };

    public void greetings(SlackSession session, String channelName)
    {
        SlackChannel channel = session.findChannelByName(channelName);
        session.sendMessage(channel, "Hey there");
    }

    public void lunchPoll(SlackSession session, SlackMessagePosted event) {
        // Then you can also filter out on the message content itself
        String messageContent = event.getMessageContent();
        if (messageContent.contains("lunch") || messageContent.contains("Lunch")) {
            String poll = "Let's choose?\n";
            for (int i = 0; i < places.length; i++) {
                poll += ":" + nums[i] + ": " + places[i] + "\n";
            }
            session.sendMessage(event.getChannel(), poll);
        }

        if (messageContent.contains("LUNCH")) {
            session.sendMessage(event.getChannel(),"STOP YELLING AT ME! GO EAT!");
        }
    }

    public void addReactionPoll(SlackSession session, SlackMessagePosted event) {
        if (session.sessionPersona().getId().equals(event.getSender().getId()) &&
            event.getMessageContent().contains("Let's choose?\n")
        ) {
            for (String num : nums) {
                session.addReactionToMessage(event.getChannel(), event.getTimestamp(), num);
            }
        }
    }
}