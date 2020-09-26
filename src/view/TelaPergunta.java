package view;

import javax.swing.JOptionPane;

public class TelaPergunta {
	
	
	public static boolean pergunta(String msg) {
		
		if (JOptionPane.showConfirmDialog(null, msg, null, JOptionPane.YES_NO_OPTION)==0)
			return true;
		return false;
		
	}
}
