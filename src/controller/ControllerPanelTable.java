package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import fachada.Fachada;
import view.PanelTable;

public class ControllerPanelTable {

	public void setPaneltable(PanelTable paneltable) {
		paneltable.getBtnBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String busca = paneltable.getTextField().getText().intern();
				if (paneltable.equals(ControllerTelaAdministrador.getTe())) {
					ControllerTelaAdministrador.atualizarEstoqueBusca(App.fachada.dataEstoqueBusca(busca));
				}
				else if (paneltable.equals(ControllerTelaAdministrador.getTu())) {
					ControllerTelaAdministrador.atualizarUsuariosBusca(App.fachada.dataUsuariosBusca(busca));
				}
				else if (paneltable.equals(ControllerTelaAdministrador.getTc())) {
					ControllerTelaAdministrador.atualizarEncomendasBusca(App.fachada.dataEncomendasBusca(busca));
				}
				else if(paneltable.equals(ControllerTelaAdministrador.getTp())) {
					ControllerTelaAdministrador.atualizarVendasBusca(App.fachada.dataVendasBusca(busca));
				}else {
					ControllerTelaAdministrador.atualizarEnderecosBusca(App.fachada.dataEnderecoBusca(busca));
				}
				
			}
		});
		
	}
	
	
	
}
