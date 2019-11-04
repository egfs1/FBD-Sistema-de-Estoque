package sql;

public class SQLUtil {
	
	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5433/postgres";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "postgres";
	
	public static class Estoque {
		
		public static String INSERT_ALL = "insert into estoque (nome,qnt) " + "values (?,?) ";
		
		public static String ADD_QNT = "update estoque set qnt= qnt + ? WHERE id= ?";
		
		public static String REMOVE_QNT = "update estoque set qnt= qnt - ? WHERE id=?";
		
		public static String SELECT_ALL = "Select * from estoque";
		
	}
	
	public static class Usuarios {
		
		public static String INSERT_ALL = "insert into usuarios (login,senha,tipo) " + "values (?,?,?) ";
		
		public static String SELECT_ALL = "Select * from usuarios";
		
		
		
	}
	
	public static class Encomendas {
		
		public static String INSERT_ALL = "insert into encomendas (id_produto,fornecedor,qnt) " + "values (?,?,?) ";
		
		public static String SELECT_ALL = "Select * from encomendas";
		
	}
	
	public static class Vendas {
		
		public static String INSERT_ALL = "insert into vendas (id_produto,cliente,qnt) " + "values (?,?,?) ";
		
		public static String SELECT_ALL = "Select * from vendas";
		
	}
	
	
	
}
