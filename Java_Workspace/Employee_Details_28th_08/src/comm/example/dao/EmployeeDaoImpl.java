package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comm.example.factory.MyConnFactory;
import comm.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private MyConnFactory factory = null;
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public EmployeeDaoImpl() throws SQLException {
		super();
		factory= MyConnFactory.createObject();
		connection = factory.getMyConnection();
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from employees");
			while (resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4),resultSet.getString(5)));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void createEmployee(Employee employee) {
		try {
			//System.out.println(employee.getId()+","+employee.getName()+","+employee.getEmail()+","+employee.getPassword()+","+employee.getCountry());
			pStatement = connection.prepareStatement("insert into employees values(?,?,?,?,?)");
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getName());
			pStatement.setString(3, employee.getEmail());
			pStatement.setString(4, employee.getPassword());
			pStatement.setString(5, employee.getCountry());
			pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("duplicate id");

			e.printStackTrace();
		} finally {

		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		try{
			pStatement=connection.prepareStatement("delete from employees where id=?");
			pStatement.setInt(1, id);
			pStatement.executeUpdate();

		}catch (SQLException e) {
			System.out.println("duplicate id");

			e.printStackTrace();
		} finally {

		}
		
	}

	@Override
	public void editEmployee(Employee employee) {
		List<Employee> eList = new ArrayList<Employee>();
		try {
			pStatement = connection.prepareStatement("update employees set id=?,eName=?,eEmail=?,ePass=?,eCountry=? where id=?");
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getName());
			pStatement.setString(3, employee.getEmail());
			pStatement.setString(4, employee.getPassword());
			pStatement.setString(5, employee.getCountry());
			pStatement.setInt(6, employee.getId());
			pStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public List<Employee> getEmployeeById(int id) {
		List<Employee> eList = new ArrayList<Employee>();
		try {
			pStatement=connection.prepareStatement("select * from employees where id=?");
			pStatement.setInt(1, id);
			resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				eList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4),resultSet.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eList;
	}
	
}
