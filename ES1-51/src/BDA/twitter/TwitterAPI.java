package BDA.twitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import BDA.main.GUI_API;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author ES1-2018-51
 */
public class TwitterAPI {

	private GUI_API gui;
	private Twitter twitter;
	private TwitterFactory tf;
	List<Status> statuses;
	
	public TwitterAPI(GUI_API gui) {
		this.gui = gui;
		addButtonActions();
		start();
	}

	/**
	 * Metodo de inicialização do TwitterAPI, este metodo le os tweets da Pagina do ISCTE-IUL (@ISCTEIUL),
	 * e imprime na interface grafica da BomDiaAcademia.
	 */
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
			this.tf = new TwitterFactory(cb.build());
			this.twitter = tf.getInstance();
			this.statuses = (twitter).getHomeTimeline();
			int counter = 0;
			int counterTotal = 0;
			for (Status status : statuses) { // Filters only tweets from
												// user"ISCTE - IUL"
				if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE - IUL")) {
					gui.getModelListTwitter().addElement(/*status.getUser().getName() + ":" +*/ status.getText());
					counter++;
				}
				counterTotal++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo para adicionar ActionListener no botão
	 */
	private void addButtonActions() {
		gui.getButton_twitter().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					reTweet();
				} catch (TwitterException e1) {
					e1.printStackTrace();
				}
			}

			/**
			 * Metodo para fazer um retweet na pagina do facebook, da publicação selecionada na interface BDA. 
			 */
			private void reTweet() throws TwitterException {
				for(Status status : statuses){
					String child = 	gui.getList_twitter().getSelectedValue().toString();
						if(status.toString().contains(child)){
							twitter.retweetStatus(status.getId());
						}
					
					
				}
			}
			
			
		});

	}
}
