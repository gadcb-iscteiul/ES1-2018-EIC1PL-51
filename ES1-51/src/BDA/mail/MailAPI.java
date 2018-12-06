package BDA.mail;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.*;

import BDA.main.GUI_API;

public class MailAPI {

	private GUI_API gui;

	public MailAPI(GUI_API gui) {
		this.gui = gui;
		addButtonActions();
		start();
	}

	private void start() {//JavaXMailLibery
	}



	private void addButtonActions() {
		gui.getButton_mail().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}

			private void send() {
				//String mail = (String) gui.getList_mail().getSelectedValue();// para obter o Mail selecionado.
			}

		});

	}

}
