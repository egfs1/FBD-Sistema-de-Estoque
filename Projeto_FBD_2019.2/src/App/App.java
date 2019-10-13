package App;

import controller.ControllerTelaLogin;
import model.BaseDados;
import model.Usuario;
import view.TelaLogin;

public class App {
	
	public static void main(String[] args) {
		Usuario u1 = new Usuario("admin", "admin", "ADM");
		BaseDados.addUsuario(u1);
		TelaLogin tl = new TelaLogin();
		ControllerTelaLogin ctl = new ControllerTelaLogin(tl);
		
	}
	
}
