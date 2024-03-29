package comm.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyConnectionFactory {
	private static Connection connection=null;
	private static javax.sql.DataSource dataSource=null;
	
	
	public static Connection getMySqlConnectionForHr() {
		try {
		   Context initContext = new InitialContext();
		   Object o = initContext.lookup("java:/comp/env/jdbc/mysql");
		   dataSource =(javax.sql.DataSource)o;
		   connection=dataSource.getConnection();
		}catch(NamingException ne) {
			ne.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
