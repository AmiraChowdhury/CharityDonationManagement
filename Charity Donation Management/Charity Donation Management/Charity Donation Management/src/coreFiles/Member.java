package coreFiles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Member {
	private String uname, pass, name, email, cell, address;
	private boolean memlogged = false;
	void createAcc() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tTo create account please enter some info:\n");
		System.out.print("\nEnter a username(needs to be unique): ");
		uname = sc.next();
		System.out.print("\nEnter a password: ");
		pass = sc.next();
		System.out.print("\nEnter your name: ");
		name = sc.next();
		System.out.print("\nEnter your email: ");
		email = sc.next();
		System.out.print("\nEnter your cell number: ");
		cell = sc.next();
		System.out.print("\nEnter your address: ");
		address = sc.next();
		//sc.close();

		String str = uname+" "+pass+" "+name+" "+email+" "+cell+" "+address+" "+"\n";
	    BufferedWriter writer = new BufferedWriter(new FileWriter("member.txt", true));// true for append
	    writer.append(str);
	    
	    writer.close();
	    System.out.println("\n\tMember account created successfully.");
	}
	
	public void memberMenu() throws NumberFormatException, IOException {
		System.out.print("\n1. See your info\n");
		System.out.print("\n2. Donate\n");
		System.out.print("\n3. Logout and go to main menu\n");
	}
	
	void memLogin() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\tPlease enter member login info\n");
		System.out.print("Member username: ");
		String unm = sc.next();
		System.out.print("Member Password: ");
		String pss = sc.next();
		
		FileReader in = new FileReader("member.txt");
		BufferedReader br = new BufferedReader(in);
		String record;
		while ((record = br.readLine()) != null) {
		    // Split line by a whitespace character
		    // split[0] <- user name
		    // split[1] <- password
		    String[] split = record.split("\\s");

		    if (unm.equals(split[0]) && pss.equals(split[1])) {
		        uname = split[0];
		        pass = split[1];
		        name = split[2];
		        email = split[3];
		        cell = split[4];
		        address = split[5];
		        memlogged = true;
		        System.out.print("\n\tSuccessfully logged in as Member("+uname+ "). Don't forget to logout after you are done.\n");
		        while(true) {
					memberMenu();
					System.out.print("\n\tEnter your choice: ");
					int c = sc.nextInt(); //sc.close();
				
					if(c==1) seeInfo();
					else if(c==2) donate();
					else if(c==3) {
						memLogout(); return;
					}
					else System.out.print("\n\tWrong choice! Please try again.\n");
				}
		    }
		}
		if(!memlogged) {
			System.out.print("\n\tWrong ID or Password. Member login failed! Please try again.\n");			
		}
		
		br.close();
		//sc.close();
	}
	
	void memLogout() {
		System.out.print("\n\tSuccessfully logged out from member account\n");
		uname = pass = email =  null;
		memlogged = false;
	}
	
	void seeInfo() {
		if(memlogged) {
			System.out.print("\n\t\tYour Information:\n");
			System.out.println("\nUsername: "+uname+"\nName: "+name+"\nEmail: "+email+"\nCell number: "+cell+"\nAddress: "+address);
		}
		else {
			System.out.print("\nPlease log in first!\n");
		}
	}
	
	void donate() throws NumberFormatException, IOException {
		Donation ob = new Donation();
		ob.donateNow();
	}
}
