package App;

import controller.ControllerTelaLogin;
import model.Administrador;
import model.BaseDados;
import model.Usuario;
import view.TelaLogin;

public class App {
	
	public static void main(String[] args) {
		Administrador u1 = new Administrador("admin", "admin");
		BaseDados.addUsuario(u1);
		TelaLogin tl = new TelaLogin();
		ControllerTelaLogin ctl = new ControllerTelaLogin(tl);
		
	}
	
}
