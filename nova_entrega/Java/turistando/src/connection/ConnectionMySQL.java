package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	private static String URL = "jdbc:mysql://localhost:3306/turistando";
	private static String USUARIO = "root";
	private static String SENHA = "mysql444";
	
	public static Connection createConnectionMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// Criar conexão com banco de dados --------- com senha 
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
	
		return connection;
	}
	
	// Retornar no console 
	public static void main(String[] args) throws Exception {
		//Recupera uma conexão com o banco de dados 
		Connection con = createConnectionMySQL();
		
		
		//testar a conexão 
		if (con !=null) {
			System.out.println(con + "\n\n **** Conexão obtida com sucesso! ****");
		con.close();
		
		}
	}
}
