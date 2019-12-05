package sql;

public class SQLUtil {
	
//	public static String URL_POSTGRES = "jdbc:postgresql://ec2-174-129-214-193.compute-1.amazonaws.com:5432/ddo8urspv1qqje";
//	public static String USUARIO_POSTGRES = "zphxyqxjsevhtb";
//	public static String SENHA_POSTGRES = "12f2983ed83cc30b7a483546dc599ac307d7a99227b231c645c9079bd0527c63";
//	
	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5433/teste";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "postgres";
	
	public static class Estoque {
		
		public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS estoque ("
				+ "id serial NOT NULL,"
				+ "nome character varying(255),"
				+ "valor_encomenda double precision,"
				+ "valor_venda double precision,"
				+ "qnt integer,"
				+ "PRIMARY KEY (id))";
		
		public static String INSERT_ALL = "insert into estoque (nome,valor_encomenda,valor_venda,qnt) " + "values (?,?,?,?) ";
		
		public static String ADD_QNT = "update estoque set qnt= qnt + ? WHERE id= ?";
		
		public static String REMOVER_QNT = "update estoque set qnt= qnt - ? WHERE id=?";
		
		public static String SELECT_ALL = "Select * from estoque";
		
		public static String EDIT_PRODUTO = "update estoque set nome=?, valor_encomenda=?, valor_venda=? WHERE id=?";
		
		public static String DELETE_PRODUTO = "delete from estoque WHERE id=?";
		
		public static String BUSCAR_PRODUTO_NOME = "Select * from estoque WHERE nome=?";
		
		public static String BUSCAR_PRODUTO_ID = "select * from estoque WHERE id=?";
		
	}
	
	public static class Usuarios {
		
		public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS usuarios ("
				+ "id serial NOT NULL,"
				+ "login character varying(255),"
				+ "senha character varying(255),"
				+ "email character varying(255),"
				+ "endereco integer,"
				+ "tipo character varying(255),"
				+ "PRIMARY KEY (id))";
		
		public static String INSERT_ALL = "insert into usuarios (login,senha,email,endereco,tipo) " + "values (?,?,?,?,?) ";
		
		public static String INSERT_ENDERECO = "update usuarios set endereco=? WHERE id=?";
		
		public static String SELECT_ALL = "Select * from usuarios";
		
		public static String EDIT_ALL = "update usuarios set login=?, senha=?, email=? WHERE id=?";
		
		public static String DELETE_USUARIO = "delete from usuarios WHERE id=?";
		
		public static String BUSCAR_USUARIO_INT = "Select * from usuarios WHERE id=? OR endereco=?";
		
		public static String BUSCAR_USUARIO_STRING = "Select * from usuarios WHERE login=? OR email=? OR tipo=?";
		
		public static String BUSCAR_USUARIO_LOGIN_SENHA = "select * from usuarios WHERE login=? AND senha=?";
		
		public static String BUSCAR_USUARIO_LOGIN = "select * from usuarios WHERE login=?";
		
		public static String BUSCAR_USUARIO_ID = "select * from usuarios WHERE id=?";
	}
	
	public static class Encomendas {
		
		public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS encomendas ("
				+ "id serial NOT NULL,"
				+ "fornecedor character varying(255),"
				+ "id_produto integer,"
				+ "qnt integer,"
				+ "valor double precision,"
				+ "data date,"
				+ "PRIMARY KEY (id))";
		
		public static String INSERT_ALL = "insert into encomendas (fornecedor,id_produto,qnt,valor,data) " + "values (?,?,?,?,?) ";
		
		public static String SELECT_ALL = "Select * from encomendas";
		
		public static String SELECT_FORNECEDOR = "Select * from encomendas WHERE fornecedor=?";
		
		public static String DELETE_ENCOMENDA_FORNECEDOR = "delete from encomendas WHERE fornecedor=?";
		
		public static String DELETE_ENCOMENDA_PRODUTO = "delete from encomendas WHERE id_produto=?";
		
		public static String UPDATE_FORNECEDOR = "update encomendas set fornecedor=? WHERE fornecedor=?";
		
		public static String BUSCAR_ENCOMENDA_INT = "Select * from encomendas WHERE id=? OR id_produto=?";
		
		public static String BUSCAR_ENCOMENDA_STRING = "Select * from encomendas WHERE fornecedor=?";
	
		public static String VALOR_TOTAL = "select valor from encomendas";
	}
	
	public static class Vendas {
		
		public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS vendas ("
											+ "id serial NOT NULL,"
											+ "cliente character varying(255),"
											+ "id_produto integer,"
											+ "qnt integer,"
											+ "valor double precision,"
											+ "data date,"
											+ "PRIMARY KEY (id))";
		
		public static String INSERT_ALL = "insert into vendas (cliente,id_produto,qnt,valor,data) " + "values (?,?,?,?,?) ";
		
		public static String SELECT_ALL = "Select * from vendas";
		
		public static String SELECT_CLIENTE = "Select * from vendas WHERE cliente=?";
		
		public static String DELETE_PEDIDO_CLIENTE = "delete from vendas WHERE cliente=?";
		
		public static String DELETE_PEDIDO_PRODUTO = "delete from vendas WHERE id_produto=?";
		
		public static String UPDATE_CLIENTE = "update vendas set cliente=? WHERE cliente=?";
		
		public static String BUSCAR_VENDA_INT = "Select * from vendas WHERE id=? OR id_produto=?";
		
		public static String BUSCAR_VENDA_STRING = "Select * from vendas WHERE cliente=?";
		
		public static String VALOR_TOTAL = "select valor from vendas";
		
	}
	
	public static class Endereco {
		
		public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS endereco ("
				+ "id serial NOT NULL,"
				+ "usuario character varying(255),"
				+ "pais character varying(255),"
				+ "estado character varying(255),"
				+ "cidade character varying(255),"
				+ "bairro character varying(255),"
				+ "rua character varying(255),"
				+ "numero integer,"
				+ "PRIMARY KEY (id))";
		
		public static String INSERT_ALL = "insert into endereco (usuario,pais,estado,cidade,bairro,rua,numero) " + "values (?,?,?,?,?,?,?)";
		
		public static String SELECT_ALL = "Select * from endereco";
		
		public static String DELETE = "delete from endereco WHERE id=?";
		
		public static String UPDATE_USUARIO = "update endereco set usuario=? WHERE id=?";
		
		public static String BUSCA_ENDERECO_INT = "Select * from endereco WHERE id=? OR numero=?";
		
		public static String BUSCA_ENDERECO_STRING = "Select * from endereco WHERE pais=? OR estado=? OR cidade=? OR bairro=? OR rua=? OR usuario=?";
		
		public static String BUSCA_ENDERECO_USUARIO = "select * from endereco WHERE usuario=?";
	}
	
	
}
