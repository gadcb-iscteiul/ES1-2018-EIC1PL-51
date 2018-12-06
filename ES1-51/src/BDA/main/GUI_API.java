package BDA.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.restfb.types.send.GenericTemplatePayload;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class GUI_API {

	private JFrame frame;
	private JButton button_mail;
	private JButton button_twitter;
	private JButton button_facebook;
	private JList list_facebook;
	private DefaultListModel<String> modelListFacebook;
	private JList list_twitter;
	private DefaultListModel<String> modelListTwitter;
	private JList list_mail;
	private DefaultListModel<String> modelListMail;
	private Font font= new Font("Arial", 0, 16);

	public GUI_API() {
		initialize();
	}

	public void open() {
		frame.setVisible(true);
	}

	/**
	 * Create the application. Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bom Dia Academia");
		frame.setResizable(true);
		frame.setBounds(100, 100, 1200, 840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		/*
		 * Painel norte.
		 */
		JPanel panel_label = new JPanel();
		frame.getContentPane().add(panel_label, BorderLayout.NORTH);
		panel_label.setLayout(new GridLayout(1, 3));

		ImageIcon icon_facebook = new ImageIcon("icon/facebook.jpg");
		JLabel label_icon_facebook = new JLabel();
		label_icon_facebook.setIcon(icon_facebook);
		label_icon_facebook.setHorizontalAlignment(SwingConstants.CENTER);
		panel_label.add(label_icon_facebook, 0);

		ImageIcon icon_twitter = new ImageIcon("icon/twitter.jpg");
		JLabel label_icon_twitter = new JLabel();
		label_icon_twitter.setIcon(icon_twitter);
		label_icon_twitter.setHorizontalAlignment(SwingConstants.CENTER);
		panel_label.add(label_icon_twitter, 1);

		ImageIcon icon_mail = new ImageIcon("icon/mail.jpg");
		JLabel label_icon_mail = new JLabel();
		label_icon_mail.setIcon(icon_mail);
		label_icon_mail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_label.add(label_icon_mail, 2);
		
		/*
		 * Alterar Futuramente!
		 * 
		panel_label.getComponent(0).setBackground(new Color(255, 0, 0));
		panel_label.getComponent(1).setBackground(new Color(0, 255, 0));
		panel_label.getComponent(2).setBackground(new Color(0, 0, 255));
		 */
		/*
		 * Painel centro.
		 * 
		 */
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(1, 3));

		modelListFacebook = new DefaultListModel<>();
		list_facebook = new JList(modelListFacebook);
		list_facebook.setFont(font);
		JScrollPane scroll_facebook = new JScrollPane(list_facebook);
		panel_center.add(scroll_facebook, 0);

		modelListTwitter = new DefaultListModel<>();
		list_twitter = new JList(modelListTwitter);
		list_twitter.setFont(font);
		JScrollPane scroll_twitter = new JScrollPane(list_twitter);
		panel_center.add(scroll_twitter, 1);

		modelListMail = new DefaultListModel<>();
		list_mail = new JList(modelListMail);
		list_mail.setFont(font);
		JScrollPane scroll_mail = new JScrollPane(list_mail);
		panel_center.add(scroll_mail, 2);

		/*
		 * Painel de botoes.
		 */
		JPanel panel_buttons = new JPanel();
		frame.getContentPane().add(panel_buttons, BorderLayout.SOUTH);
		panel_buttons.setLayout(new GridLayout(1, 3));
		
		button_facebook = new JButton("Post");
		button_facebook.setPreferredSize(new Dimension(1, 50));
		panel_buttons.add(button_facebook, 0);

		button_twitter = new JButton("Retweetar");
		panel_buttons.add(button_twitter, 1);

		button_mail = new JButton("Open");
		panel_buttons.add(button_mail, 2);
	}

	public DefaultListModel<String> getModelListFacebook() {
		return modelListFacebook;
	}

	public DefaultListModel<String> getModelListTwitter() {
		return modelListTwitter;
	}

	public DefaultListModel<String> getModelListMail() {
		return modelListMail;
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

	public JList getList_facebook() {
		return list_facebook;
	}

	public JList getList_twitter() {
		return list_twitter;
	}

	public JList getList_mail() {
		return list_mail;
	}
	
	

}
