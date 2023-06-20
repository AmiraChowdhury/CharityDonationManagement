package coreFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Applicant {
	private String name, email, cell, address;
	void apply() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tTo apply for donation please enter some info.\nOur team will contact you.\n");
		System.out.print("\nEnter your name: ");
		name = sc.next();
		System.out.print("\nEnter your email: ");
		email = sc.next();
		System.out.print("\nEnter your cell number: ");
		cell = sc.next();
		System.out.print("\nEnter your address: ");
		address = sc.next();
		//sc.close();

		String str = name+" "+email+" "+cell+" "+address+"\n";
	    BufferedWriter writer = new BufferedWriter(new FileWriter("applicant.txt", true));// true for append
	    writer.append(str);
	    
	    writer.close();
	    System.out.print("\n\t\tThanks for applying. We will contact you soon.\n");
	}
}
