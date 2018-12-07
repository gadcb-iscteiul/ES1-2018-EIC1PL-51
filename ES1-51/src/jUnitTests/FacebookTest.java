package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.FacebookAPI;
import BDA.GUI_API;

public class FacebookTest {

	@Test
	public void test() {
		GUI_API gui = new GUI_API();
		FacebookAPI instance = new FacebookAPI(gui);
		
		assertNotNull(instance);
	}

}
