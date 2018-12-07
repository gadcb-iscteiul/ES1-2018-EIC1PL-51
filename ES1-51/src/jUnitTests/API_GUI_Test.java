package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.GUI_API;

public class API_GUI_Test {

	@Test
	public void test() {
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

}
