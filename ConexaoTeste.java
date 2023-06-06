package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.sql.DriverManager;

public class ConexaoTeste {

	private static final String url = "jdbc:mysql://localhost:3306/projetoa3";
	private static final String user = "root";
	private static final String password = "Pin91166415";

	//conecxão com o banco
	
	public static Connection createConnectionToMySQL() throws Exception {
 
		Class.forName("com.mysql.cj.jdbc.Driver");	

		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

	public static void main(String[] args) throws Exception {
		
		//recuperar uma conexão com o banco de dados.
		Connection conn = createConnectionToMySQL();
		
		//testar se a conexão é nula.
		if(conn != null) {
			
			System.out.println("Conexão obetida com sucesso!");
		}
		
	}
	
	
}
