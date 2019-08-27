package comm.example.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {

	public static void main (String[] args) throws IOException {
		FileInputStream in= new FileInputStream(new File("farrago.txt") );
		FileOutputStream out= new FileOutputStream(new File("outagain.txt") );
	int c;
	while((c = in.read())!=-1) {
		System.out.println(c);
		out.write(c);
	}
	System.out.println("File  sjduoislajd siej and difaleif");
	in.close();
	out.close();
	}
	
}
