package comm.example.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private MyConnectionFactory factory = null;
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public EmployeeDaoImpl() throws SQLException {
		super();
		factory = MyConnectionFactory.createObject();
		connection = factory.getConnection();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from employee");
			ResultSetMetaData rMetaData = resultSet.getMetaData();
			rMetaData.getColumnCount();
			rMetaData.getColumnLabel(1);
			rMetaData.getColumnName(2);
			rMetaData.getColumnType(2);
			while (resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public void getConnectionInfo() {
		try {
			DatabaseMetaData dMetaData = connection.getMetaData();

			System.out.println(dMetaData.getDatabaseProductName());
			System.out.println(dMetaData.getDriverName() + " " + dMetaData.getDatabaseMajorVersion() + " "
					+ dMetaData.getDatabaseMinorVersion());
			dMetaData.getURL();
			dMetaData.getUserName();
		} catch (SQLException e) {

		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEmployee(Employee employee) {
		try {
			pStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getFirstName());
			pStatement.setString(3, employee.getLastName());
			pStatement.setString(4, employee.getEmail());
			pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("duplicate id");

			e.printStackTrace();
		} finally {

		}

	}

}
