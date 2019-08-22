package assignment4;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
	  String sentence;
	  Scanner sc= new Scanner(System.in);
	  System.out.println("Enter the sentence: ");
	  sentence=sc.next();
	  
	  LetterSequence ls=new LetterSequence();
	  
	  TreeMap<Character, Integer> tcount1= new TreeMap<Character, Integer>();
	  tcount1 = ls.countFrequency(sentence);
	  
	  ls.displayLetterFrequency(tcount1);

	}

}
