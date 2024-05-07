package ProcessosBanco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BancoDeDados {
	private final static String url = "jdbc:mysql://localhost:3306/exemploProjeto";
	private final static String username = "root";
	private final static String password = "061178";
	private static Connection conn;
	
	public static Connection ConectaBanco() {
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Conectou com sucesso no banco");
				return conn;
			}else {
				System.out.println("Já esta concetado");
				return conn;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel realizar a conexao:"+e);
			return null;
		}
	}
	public static void DesconectaBanco(){
		try{
			System.out.println("Fechou a conexao com o banco com sucesso");
			conn.close();
		}catch(SQLException e){
			System.out.println("\nNão foi possível fechar conexão " + e + "\n");
			System.exit(1);		
		}	
	}
	
	public static void main(String args[]){
		BancoDeDados b = new BancoDeDados();
		b.ConectaBanco();
		b.DesconectaBanco();
	}
}
