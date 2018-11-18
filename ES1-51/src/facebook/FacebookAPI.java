package facebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

import main.GUI_API;

public class FacebookAPI {

	private GUI_API gui;

	public FacebookAPI(GUI_API gui) {
		this.gui = gui;
		addButtonActions();
		start();

	}

	private void start() {
		//https://developers.facebook.com/tools/explorer/
		String accessToken = "EAACr9OmMWZBQBAP2dZAS7URRZBPi7M1hJguVxrjcO4GTdsq1pu3CPBK0gHY9AZCGzZAlIu5Jgj10RmDY9Shp0PMANf6m9HmsQFFOTaBDblBrywyZAlvCwb5Xi2ZBf9xse3UU5rLYLQAbSukZBwC1JYevgyNNGZBwCjvw442ZAjUfpWGB8b8Nk9UInkoheMeJoTvZB7qSIlePLKpEAZDZD";
		
		@SuppressWarnings("deprecation")
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		User me2 = fbClient.fetchObject("me", User.class);

		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());

		//https://developers.facebook.com/apps/189068378659812/settings/basic/
		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("189068378659812",
				"3176c05228482d7fdcc2190d1310c083");
		System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());

		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		
		int counter = 0, counterTotal = 0;
		
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && counterTotal < 5) {// aPost.getMessage().contains("ISCTE")
					gui.getModelListFacebook().addElement("---- Post " + counter + " ----");
					gui.getModelListFacebook().addElement("Id: " + "fb.com/" + aPost.getId());
					gui.getModelListFacebook().addElement("Message: " + aPost.getMessage());
					gui.getModelListFacebook().addElement("Created: " + aPost.getCreatedTime());
					counter++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
	}
	
	private void addButtonActions() {
		gui.getButton_facebook().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				post();
			}

			private void post() {
				String post = (String)gui.getList_facebook().getSelectedValue();// para obter o Post selecionado.
			}
			
		});

	}
}
