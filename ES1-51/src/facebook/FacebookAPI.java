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


	}

	public static void main(String[] args) {
		String accessToken = "EAACr9OmMWZBQBABI0IyKw2ZASAtAGvEXoj4yy5i2Fqcr1EQLaDOjHsmlRiWWzENAFfKEO2j2ZBnGIOPdr5mJNxocSw8Mf3q0oa7bJy8AujuzNZC3ZC4wb2kFZBDC0MxZBbhyXXrkkkI6Tqw2CZCrrmAZCpP4L5KKcilPKffLLAQSuwZCfQIRErivzG2NRubK2fjIMZD";
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

		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null && counterTotal < 2) {// aPost.getMessage().contains("Evento")
					System.out.println("---- Post " + counter5 + " ----");
					System.out.println("Id: " + "fb.com/" + aPost.getId());
					System.out.println("Message: " + aPost.getMessage());
					System.out.println("Created: " + aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter5 + "/" + counterTotal);
	}

}
