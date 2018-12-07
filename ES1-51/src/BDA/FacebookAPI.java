package BDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;
import com.restfb.types.Post;
import com.restfb.types.User;
import com.restfb.Connection;

/**
 * @author Hellblazer
 *
 */
public class FacebookAPI {

	/**
	 * 
	 */
	private GUI_API gui;
	private ArrayList<String> postIDList;
	private ArrayList<Post> posts;

	/**
	 * FacebookAPI
	 * 
	 * @param gui
	 *            Graphic Interface.
	 */
	public FacebookAPI(GUI_API gui) {
		this.gui = gui;
		addButtonActions();
		postIDList = new ArrayList<>();
		posts = new ArrayList<>();
		start();

	}

	/**
	 * Metodo de inicialização do FacebookAPI, este metodo le os posts do user,
	 * e imprime na interface grafica da BomDiaAcademia, os 5 primeiros post que
	 * encontrar com informação sobre o ISCTE-IUL.
	 */
	private void start() {
		// https://developers.facebook.com/tools/explorer/
		String accessToken = "EAACr9OmMWZBQBAFkel8GMpLFVkWR4ZCLl5epKIaosbS7fWaVxa2MzZAb0RxPihPfxnEmMyWihJZAXo5QAVFdkHUKiBbtV0rJ8lN0ICsQFYVyRb8XDyfqbZCOCYmn7tYUWpVhZB0sP0oeUinuIKJUZC4MxixXhfWtMx3cwtheyB1ySPS4QLZAZApm3Cekxbm4Vs7UejsrxoUSe8wZDZD";

		@SuppressWarnings("deprecation")
		FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_11);
		User user = fbClient.fetchObject("me", User.class);

		System.out.println("Facebook:");
		System.out.println("Id: " + user.getId());
		System.out.println("Name: " + user.getName());

		// https://developers.facebook.com/apps/189068378659812/settings/basic/
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
					gui.getModelListFacebook().addElement("Post: " + counter);
					gui.getModelListFacebook().addElement("Id: " + "fb.com/" + aPost.getId());
					gui.getModelListFacebook().addElement("Message: " + aPost.getMessage());
					gui.getModelListFacebook().addElement("Created: " + aPost.getCreatedTime());
					gui.getModelListFacebook().addElement(" ");

					posts.add(aPost);
					postIDList.add("Post: " + counter + "::" + aPost.getId());
					counter++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nN� of Results: " + counter + "/" + counterTotal);
	}

	/**
	 * Metodo para adicionar ActionListener no botão
	 */
	private void addButtonActions() {
		gui.getButton_facebook().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				post();
			}

			/**
			 * Metodo para fazer um publicação na pagina do facebook, da
			 * publicação selecionada na interface BDA.
			 */
			private void post() {
				String postText = (String) gui.getList_facebook().getSelectedValue();
				Post post = searchPost(postText);
				if (!post.equals(null))
					System.out.println(post.getMessage());
				else
					System.out.println("Fail!");
			}

			private Post searchPost(String postText) {
				Post aPost = null;
				String postID = new String("");

				if (postText.contains("Post: ")) {
					for (String aux : postIDList) {
						String[] pos = aux.split("::");
						if (pos[0].equals(postText)) {
							System.out.println(pos[0] + "---" + postText);
							postID = pos[1];
							break;
						}
					}
				}
				System.out.println("here5");
				for (Post post : posts) {
					if (post.getMessage() != null && (post.getId().equals(postID) || post.getMessage().equals(postText)
							|| post.getCreatedTime().equals(postText))) {
						System.out.println("here4");
						// aPost = post;
					}
				}

				System.out.println("here3");
				return aPost;
			}

		});

	}
}
