package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.GUI_API;
import BDA.TwitterAPI;

import org.junit.*;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {

	@Test
	public void test() {
		GUI_API gui = new GUI_API();
		TwitterAPI instance = new TwitterAPI(gui);
		
		assertNotNull(instance);
	}

}
