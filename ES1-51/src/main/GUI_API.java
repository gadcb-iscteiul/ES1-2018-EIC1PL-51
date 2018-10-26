package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class GUI_API {

	private JFrame frame;
	private JList list_facebook;
	private JList list_mail;
	private JList list_twitter;
	private JButton button_mail;
	private JButton button_twitter;
	private JButton button_facebook;


	public GUI_API() {
		initialize();
	}
	public void open(){
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		/*
		 * Painel norte.
		 */
		JPanel panel_label = new JPanel();
		frame.getContentPane().add(panel_label, BorderLayout.NORTH);
		GridBagLayout gbl_panel_label = new GridBagLayout();
		gbl_panel_label.columnWidths = new int[]{100, 300, 100, 300, 100, 300, 0};
		gbl_panel_label.rowHeights = new int[]{100, 0};
		gbl_panel_label.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_label.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_label.setLayout(gbl_panel_label);
		
		ImageIcon icon_facebook = new ImageIcon("icon/facebook.jpg");
		JLabel label_icon_facebook = new JLabel();
		label_icon_facebook.setIcon(icon_facebook);
		GridBagConstraints gbc_label_icon_facebook = new GridBagConstraints();
		gbc_label_icon_facebook.insets = new Insets(0, 0, 0, 5);
		gbc_label_icon_facebook.gridx = 0;
		gbc_label_icon_facebook.gridy = 0;
		panel_label.add(label_icon_facebook, gbc_label_icon_facebook);

		JLabel label_facebook = new JLabel("Facebook");
		GridBagConstraints gbc_label_facebook = new GridBagConstraints();
		gbc_label_facebook.fill = GridBagConstraints.BOTH;
		gbc_label_facebook.insets = new Insets(0, 0, 0, 5);
		gbc_label_facebook.gridx = 1;
		gbc_label_facebook.gridy = 0;
		panel_label.add(label_facebook, gbc_label_facebook);

		ImageIcon icon_twitter = new ImageIcon("icon/twitter.jpg");
		JLabel label_icon_twitter = new JLabel();
		label_icon_twitter.setIcon(icon_twitter);
		GridBagConstraints gbc_label_icon_twitter = new GridBagConstraints();
		gbc_label_icon_twitter.insets = new Insets(0, 0, 0, 5);
		gbc_label_icon_twitter.gridx = 2;
		gbc_label_icon_twitter.gridy = 0;
		panel_label.add(label_icon_twitter, gbc_label_icon_twitter);

		JLabel label_twitter = new JLabel("Twitter");
		GridBagConstraints gbc_label_twitter = new GridBagConstraints();
		gbc_label_twitter.fill = GridBagConstraints.BOTH;
		gbc_label_twitter.insets = new Insets(0, 0, 0, 5);
		gbc_label_twitter.gridx = 3;
		gbc_label_twitter.gridy = 0;
		panel_label.add(label_twitter, gbc_label_twitter);

		ImageIcon icon_mail = new ImageIcon("icon/mail.jpg");
		JLabel label_icon_mail = new JLabel();
		label_icon_mail.setIcon(icon_mail);
		GridBagConstraints gbc_label_icon_mail = new GridBagConstraints();
		gbc_label_icon_mail.insets = new Insets(0, 0, 0, 5);
		gbc_label_icon_mail.gridx = 4;
		gbc_label_icon_mail.gridy = 0;
		panel_label.add(label_icon_mail, gbc_label_icon_mail);

		JLabel label_mail = new JLabel("Mail");
		GridBagConstraints gbc_label_mail = new GridBagConstraints();
		gbc_label_mail.fill = GridBagConstraints.BOTH;
		gbc_label_mail.insets = new Insets(0, 0, 0, 0);
		gbc_label_mail.gridx = 5;
		gbc_label_mail.gridy = 0;
		panel_label.add(label_mail, gbc_label_mail);
		
		/*
		 * Painel centro.
		 * 
		 * ****FALTA OS MODELS****
		 */
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{400, 400, 400, 0};
		gbl_panel_center.rowHeights = new int[]{650, 50};
		gbl_panel_center.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		
		list_facebook = new JList();
		GridBagConstraints gbc_list_facebook = new GridBagConstraints();
		gbc_list_facebook.fill = GridBagConstraints.BOTH;
		gbc_list_facebook.insets = new Insets(0, 0, 0, 5);
		gbc_list_facebook.gridx = 0;
		gbc_list_facebook.gridy = 0;
		panel_center.add(list_facebook, gbc_list_facebook);
		
		list_twitter = new JList();
		GridBagConstraints gbc_list_twitter = new GridBagConstraints();
		gbc_list_twitter.fill = GridBagConstraints.BOTH;
		gbc_list_twitter.insets = new Insets(0, 0, 0, 5);
		gbc_list_twitter.gridx = 1;
		gbc_list_twitter.gridy = 0;
		panel_center.add(list_twitter, gbc_list_twitter);
		
		list_mail = new JList();
		GridBagConstraints gbc_list_mail = new GridBagConstraints();
		gbc_list_mail.fill = GridBagConstraints.BOTH;
		gbc_list_mail.gridx = 2;
		gbc_list_mail.gridy = 0;
		panel_center.add(list_mail, gbc_list_mail);
		
		/*
		 * Painel de botoes.
		 */
		JPanel panel_buttons = new JPanel();
		frame.getContentPane().add(panel_buttons, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_buttons = new GridBagLayout();
		gbl_panel_buttons.columnWidths = new int[]{400, 400, 400, 0};
		gbl_panel_buttons.rowHeights = new int[]{40, 5};
		gbl_panel_buttons.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_buttons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_buttons.setLayout(gbl_panel_buttons);
		
		button_facebook = new JButton("Post");
		GridBagConstraints gbc_button_facebook = new GridBagConstraints();
		gbc_button_facebook.fill = GridBagConstraints.BOTH;
		gbc_button_facebook.insets = new Insets(0, 0, 0, 5);
		gbc_button_facebook.gridx = 0;
		gbc_button_facebook.gridy = 0;
		panel_buttons.add(button_facebook, gbc_button_facebook);
		
		button_twitter = new JButton("Retweetar");
		GridBagConstraints gbc_button_twitter = new GridBagConstraints();
		gbc_button_twitter.fill = GridBagConstraints.BOTH;
		gbc_button_twitter.insets = new Insets(0, 0, 0, 5);
		gbc_button_twitter.gridx = 1;
		gbc_button_twitter.gridy = 0;
		panel_buttons.add(button_twitter, gbc_button_twitter);
		
		button_mail = new JButton("Open");
		GridBagConstraints gbc_button_mail = new GridBagConstraints();
		gbc_button_mail.fill = GridBagConstraints.BOTH;
		gbc_button_mail.gridx = 2;
		gbc_button_mail.gridy = 0;
		panel_buttons.add(button_mail, gbc_button_mail);
	}
	
	public JList getList_facebook() {
		return list_facebook;
	}
	public JList getList_mail() {
		return list_mail;
	}
	public JList getList_twitter() {
		return list_twitter;
	}
	public JButton getButton_mail() {
		return button_mail;
	}
	public JButton getButton_twitter() {
		return button_twitter;
	}
	public JButton getButton_facebook() {
		return button_facebook;
	}

}
