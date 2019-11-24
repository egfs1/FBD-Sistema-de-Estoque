package App;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerTelaLogin;
import fachada.Fachada;
import fachada.IFachada;
import view.TelaLogin;

public class App {
	
	static IFachada fachada = Fachada.getInstance();
	
	public static void main(String[] args) throws SQLException {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		TelaLogin tl = new TelaLogin();
		ControllerTelaLogin ctl = new ControllerTelaLogin(tl);
		
		
	}	
}
