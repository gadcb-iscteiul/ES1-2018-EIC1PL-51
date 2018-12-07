package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import BDA.GUI_API;
import BDA.MailAPI;

import javax.mail.*;

public class MailTest {

	@Test
	public void test() {
		GUI_API gui = new GUI_API();
		MailAPI instance = new MailAPI(gui);
		
		assertNotNull(instance);
	}

}
