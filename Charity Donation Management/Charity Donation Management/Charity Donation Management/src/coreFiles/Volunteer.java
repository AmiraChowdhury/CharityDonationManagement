package coreFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Volunteer {
	private String name, email, cell, address;
	void signUp() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tTo Sign Up as a volunteer please enter some info.\nOur team will contact you when new event is launched\n");
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
	    BufferedWriter writer = new BufferedWriter(new FileWriter("volunteer.txt", true));// true for append
	    writer.append(str);
	    
	    writer.close();
	    System.out.print("\n\t\tThank You! You are added to the volunteer list.\n");
	}
}
