package App;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerTelaLogin;
import fachada.Fachada;
import view.TelaLogin;

public class App {
	
	public static Fachada fachada = Fachada.getInstance();
	
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
		
//		Endereco e = new Endereco("Brasil", "Pernambuco", "Serra Talhada", "Centro", "Rua Doutor Ademar Xavier", 794);
//		Administrador user = new Administrador("admin", "admin", "admin@gmail.com");
//		e.setUsuario(user);
//		fachada.cadastrarUsuario(user, e);
	}	
}
