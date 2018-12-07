package BDA;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class Login {
	
	private JFrame frame;
	private JTextField textfield_email;
	private JTextField textfield_password;
	private JLabel lblApiName;
	private JPanel panel_Name;
	private JLabel lbl_email;
	private JLabel lbl_password;
	
	
	public Login() {
		initialize();
	}
	
	public void open(){
		frame.setVisible(true);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		/*
		 * 
		 */
		panel_Name = new JPanel();
		frame.getContentPane().add(panel_Name, BorderLayout.NORTH);
		
		lblApiName = new JLabel("API name");
		panel_Name.add(lblApiName);
		
		/*
		 * Painel central
		 */
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 400, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 40};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		lbl_email = new JLabel("Email: ");
		GridBagConstraints gbc_lbl_email = new GridBagConstraints();
		gbc_lbl_email.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_email.anchor = GridBagConstraints.EAST;
		gbc_lbl_email.gridx = 0;
		gbc_lbl_email.gridy = 1;
		panel.add(lbl_email, gbc_lbl_email);
		
		textfield_email = new JTextField();
		GridBagConstraints gbc_textfield_email = new GridBagConstraints();
		gbc_textfield_email.fill = GridBagConstraints.BOTH;
		gbc_textfield_email.insets = new Insets(0, 0, 5, 5);
		gbc_textfield_email.gridx = 1;
		gbc_textfield_email.gridy = 1;
		panel.add(textfield_email, gbc_textfield_email);
		textfield_email.setColumns(15);
		
		lbl_password = new JLabel("Password: ");
		GridBagConstraints gbc_lbl_password = new GridBagConstraints();
		gbc_lbl_password.insets = new Insets(0, 10, 5, 5);
		gbc_lbl_password.anchor = GridBagConstraints.EAST;
		gbc_lbl_password.gridx = 0;
		gbc_lbl_password.gridy = 2;
		panel.add(lbl_password, gbc_lbl_password);
		
		textfield_password = new JTextField();
		GridBagConstraints gbc_textfield_password = new GridBagConstraints();
		gbc_textfield_password.fill = GridBagConstraints.BOTH;
		gbc_textfield_password.insets = new Insets(0, 0, 5, 5);
		gbc_textfield_password.gridx = 1;
		gbc_textfield_password.gridy = 2;
		panel.add(textfield_password, gbc_textfield_password);
		textfield_password.setColumns(15);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 80, 0, 80);
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 3;
		panel.add(btnLogin, gbc_btnLogin);
		
	}

}
