package comm.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyConnFactory {
public static Connection connection=null;
public static javax.sql.DataSource dataSource=null;
public static MyConnFactory factory=null;

public static Connection getMyConnection() {
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

public static MyConnFactory createObject() throws SQLException
{
	if(factory==null)
	{
		factory=new MyConnFactory();
	}
	return factory;
}
	
}

