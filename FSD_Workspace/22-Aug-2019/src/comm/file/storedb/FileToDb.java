package comm.file.storedb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

public class FileToDb {
public static void main(String[] args) throws SQLException {
try {
BufferedReader reader;
reader= new BufferedReader(new FileReader("farrago.txt"));
String line=reader.readLine();
EmployeeService emp = new EmployeeServiceImpl();
while(line!=null) {
	String[] data= line.split(" ");
   int id= emp.
}


}catch(IOException ie) {
	System.out.println("failed");
}
}
}
