import actions.LunchPoll;
import connections.DirectConnector;

import java.io.IOException;

public class MrPaul {
    public static void main(String[] args) throws IOException {
        LunchPoll lunchPoll = new LunchPoll();

        lunchPoll.createLunchPoll(DirectConnector.getSession(Config.get("token")), Config.get("channel"));
    }
}