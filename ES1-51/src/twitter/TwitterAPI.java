package twitter;

import java.util.List;

import main.GUI_API;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAPI {

	private GUI_API gui;

	public TwitterAPI(GUI_API gui) {
		this.gui = gui;
		start();
	}

	private void start() {

		// http:twitter4j.org
		// http:twitter4j.org/en/code-examples.html
		// https:www.youtube.com/watch?v=uYPmkzMpnxw

		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("2ZfhDo6MbZYklQU2sLR00L24D")
					.setOAuthConsumerSecret("HxxrlXXHDETUu9Jk2KAPMnz1a7ECG0xBPo79q8ZVRAUfAsLyB9")
					.setOAuthAccessToken("1055080625911353344-Cb7UmqQNkGMzfvu3BOT33Oab5Cg3Rp")
					.setOAuthAccessTokenSecret("tkpXiPrUTD2aYPnJgIS0qcBKtMoYMNuxmbhL4vp6Zrw9X");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = (twitter).getHomeTimeline();
			System.out.println("------------------------\n Showing home timeline \n------------------------");
			int counter = 0;
			int counterTotal = 0;
			for (Status status : statuses) { // Filters only tweets from
												// user"ISCTE - IUL"
				if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE - IUL")) {
					//System.out.println(status.getUser().getName() + ":" + status.getText());
					gui.getModelListTwitter().addElement(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
			}
			System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
