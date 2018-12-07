package BDA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

/**
 * @author ES1-2018-51
 */
public class MailAPI {

	private GUI_API gui;
	private String senderEmailID = "rishabhraj210@gmail.com";
	private String senderPassword = "7277077256";
	private String emailSMTPserver = "smtp.gmail.com";
	private String emailServerPort = "465";
	private String receiverEmailID = "rishabhraj210@gmail.com";
	private static String emailSubject = "Test Mail";
	private static String emailBody = ":)";
	
	/**
	 * 
	 * @param gui Interface Gráfica da API
	 */
	public MailAPI(GUI_API gui) {
		this.gui = gui;
		addButtonActions();
		start();
	}

	private void start() {
		//1 Abrir email definido
		//2 Ler email
		//3 imprimir para interface grafica.
	}
	
	private void SendEmail(String receiverEmailID, String Subject, String Body) {
		// Receiver Email Address
	}

	/**
	 * Metodo para adicionar ActionListener no botão
	 */
	private void addButtonActions() {
		gui.getButton_mail().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//send();
			}

			private void send(String receiverEmailID, String Subject, String Body) {
				// String mail = (String)
				// gui.getList_mail().getSelectedValue();// para obter o
				// Mail selecionado. para enviar.
				
				//O MAIL JÁ EXISTE, É SÓ REECAMINHAR O MAIL.
				
				//this.receiverEmailID = receiverEmailID;
				// Subject
				//this.emailSubject = Subject;
				// Body
				//this.emailBody = Body;
				
				Properties props = new Properties();
				props.put("mail.smtp.user", senderEmailID);
				props.put("mail.smtp.host", emailSMTPserver);
				props.put("mail.smtp.port", emailServerPort);
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.socketFactory.port", emailServerPort);
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "false");
				SecurityManager security = System.getSecurityManager();
				try {
					Authenticator auth = new SMTPAuthenticator();
					Session session = Session.getInstance(props, auth);
					MimeMessage msg = new MimeMessage(session);
					msg.setText(emailBody);
					msg.setSubject(emailSubject);
					msg.setFrom(new InternetAddress(senderEmailID));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
					Transport.send(msg);
					System.out.println("Message send Successfully:)");
				}

				catch (Exception mex) {
					mex.printStackTrace();
				}
			}
		});
	}
	
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmailID, senderPassword);
		}

	}
}

/*
 * import javax.mail.*; 
 * import javax.mail.internet.*; 
 * import java.util.*;
 * 
 * private void SendEmail {
 * 
 * final String senderEmailID = "rishabhraj210@gmail.com"; final String
 * senderPassword = "7277077256"; final String emailSMTPserver =
 * "smtp.gmail.com"; final String emailServerPort = "465"; String
 * receiverEmailID = null; static String emailSubject = "Test Mail"; static
 * String emailBody = ":)"; public void SendEmail(String receiverEmailID,String
 * Subject, String Body){
 * 
 * // Receiver Email Address this.receiverEmailID=receiverEmailID; // Subject
 * this.emailSubject=Subject; // Body this.emailBody=Body; Properties props =
 * new Properties(); props.put("mail.smtp.user",senderEmailID);
 * props.put("mail.smtp.host", emailSMTPserver); props.put("mail.smtp.port",
 * emailServerPort); props.put("mail.smtp.starttls.enable", "true");
 * props.put("mail.smtp.auth", "true");
 * props.put("mail.smtp.socketFactory.port", emailServerPort);
 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 * props.put("mail.smtp.socketFactory.fallback", "false"); SecurityManager
 * security = System.getSecurityManager(); try{ Authenticator auth = new
 * SMTPAuthenticator(); Session session = Session.getInstance(props, auth);
 * MimeMessage msg = new MimeMessage(session); msg.setText(emailBody);
 * msg.setSubject(emailSubject); msg.setFrom(new
 * InternetAddress(senderEmailID)); msg.addRecipient(Message.RecipientType.TO,
 * new InternetAddress(receiverEmailID)); Transport.send(msg);
 * System.out.println("Message send Successfully:)"); }
 * 
 * catch (Exception mex){ mex.printStackTrace();}
 * 
 * 
 * } public class SMTPAuthenticator extends javax.mail.Authenticator { public
 * PasswordAuthentication getPasswordAuthentication() { return new
 * PasswordAuthentication(senderEmailID, senderPassword); } } }
 */
