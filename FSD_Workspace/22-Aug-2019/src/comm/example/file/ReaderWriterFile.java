package comm.example.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReaderWriterFile {

	public static void main(String[] args) throws IOException {
		FileReader in= new FileReader(new File("farrago.txt") );
		FileWriter out= new FileWriter(new File("outagain.txt") );
		BufferedReader inputstream= new BufferedReader(in);
		PrintWriter outputstream = new PrintWriter(out);
	String l;
	while((l=inputstream.readLine())!=null) {
		System.out.println(l);
		outputstream.println(l);
	}
	System.out.println("File  sjduoislajd siej and difaleif");
	in.close();
	out.close();
	}

	
}



