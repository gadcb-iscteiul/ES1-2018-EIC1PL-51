package BDA;


/**
 * @author ES1-2018-51
 */
public class API {

	//Login login = new Login();
	//login.open();
	public static void main(String[] args) {
		GUI_API gui = new GUI_API();
		FacebookAPI fb = new FacebookAPI(gui);
		//TwitterAPI tw = new TwitterAPI(gui);
		//MailAPI ma = new MailAPI(gui);
		
		gui.open();
	}
}
