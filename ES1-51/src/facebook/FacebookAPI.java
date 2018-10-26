package facebook;

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
		start();

	}

	private void start() {
		//https://developers.facebook.com/tools/explorer/
		String accessToken = "EAACr9OmMWZBQBABA7FOL1wHVoz8mhZAbWjMGJ4YSoIzvpXDf5rjwHoRNBZB48r6R5OF5kDzIILhZCBiWbZBkzTkrJDqFDRNVusAHjx9bQAI92t0XnOXEPxHxfSwOqRaxHZAZAdIZCQhKPcdZCJ1kOlnfDww3LuOOWfOQ38smdmROSUntdlwnPOmoFh4ZCgx0dGGAgZD";
		
		@SuppressWarnings("deprecation")
		FacebookClient fbClient = new DefaultFacebookClient(accessToken);
		User me2 = fbClient.fetchObject("me", User.class);

		System.out.println("Facebook:");
		System.out.println("Id: " + me2.getId());
		System.out.println("Name: " + me2.getName());

		AccessToken extendedAccessToken = fbClient.obtainExtendedAccessToken("189068378659812",
				"3176c05228482d7fdcc2190d1310c083");
		System.out.println("ExtendedAccessToken: " + extendedAccessToken.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken.getExpires());

		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);

		int counter = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && counterTotal < 5) {// aPost.getMessage().contains("Evento")
					//Alterar para enviar Post to gui
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
}
