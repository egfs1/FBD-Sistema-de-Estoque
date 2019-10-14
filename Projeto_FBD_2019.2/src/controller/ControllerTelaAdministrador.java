package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaAdministrador;

public class ControllerTelaAdministrador {
	
	public ControllerTelaAdministrador(TelaAdministrador ta) {
		
		ta.getBtnDeslogar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ta.dispose();
				ta.getTl().setVisible(true);
			}
		});
		
		
	}
	
}
