package App;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerTelaLogin;
import model.BaseDados;
import view.TelaLogin;

public class App {
	
	
	public static void main(String[] args) throws SQLException {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		BaseDados.atualizarDataEstoque();
		BaseDados.atualizarDataUsuarios();
		BaseDados.atualizarDataEncomendas();
		BaseDados.atualizarDataVendas();
		
		TelaLogin tl = new TelaLogin();
		ControllerTelaLogin ctl = new ControllerTelaLogin(tl);
		
//		Administrador u1 = new Administrador("admin", "admin");
//		BaseDados.addUsuario(u1);
		
		
	}	
}
