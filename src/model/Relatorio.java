package model;

import fachada.Fachada;

public class Relatorio {
	
	public static String getRelatorioEncomendas() {
		return Fachada.getInstance().relatorioEncomendas();
	}
	public static String getRelatorioVendas() {
		return Fachada.getInstance().relatorioVendas();
	}
	public static double getValorTotalEncomendas() {
		return Fachada.getInstance().valorTotalEncomendas();
	}
	public static double getValorTotalVendas() {
		return Fachada.getInstance().valorTotalVendas();
	}
	public static double getLucro() {
		return getValorTotalVendas() - getValorTotalEncomendas();
	}
	
	
	
}
