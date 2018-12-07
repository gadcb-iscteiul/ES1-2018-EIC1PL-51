package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.FacebookAPI;
import BDA.GUI_API;
import BDA.MailAPI;
import BDA.TwitterAPI;

public class API_Test {

	@Test
	public void testCreateGui() {
		GUI_API instance = new GUI_API();
		assertNotNull(instance);

		assertNotNull(instance.getButton_facebook());
		assertNotNull(instance.getButton_mail());
		assertNotNull(instance.getButton_twitter());

		assertNotNull(instance.getList_facebook());
		assertNotNull(instance.getList_mail());
		assertNotNull(instance.getList_twitter());

		assertNotNull(instance.getModelListFacebook());
		assertNotNull(instance.getModelListMail());
		assertNotNull(instance.getModelListTwitter());
	}

	@Test
	public void testCreateFacebookAPI() {
		GUI_API instance = new GUI_API();
		FacebookAPI fb = new FacebookAPI(instance);
		assertNotNull(fb);
	}

	@Test
	public void testCreateTwitterPI() {
		GUI_API instance = new GUI_API();
		TwitterAPI tw = new TwitterAPI(instance);
		assertNotNull(tw);
	}

	@Test
	public void testCreateMailAPI() {
		GUI_API instance = new GUI_API();
		MailAPI ml = new MailAPI(instance);
		assertNotNull(ml);
	}

}
