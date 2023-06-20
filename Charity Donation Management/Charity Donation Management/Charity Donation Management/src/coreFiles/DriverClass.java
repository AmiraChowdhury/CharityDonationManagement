package coreFiles;

import java.io.IOException;
import java.util.Scanner;

public class DriverClass {
	public static void about() {
		System.out.print("\n\t\tWe are working to collect donations and distribute them\n");
	}
	public static void mainMenu() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n1. Admin Login\n");
		System.out.print("\n2. Member Login\n");
		System.out.print("\n3. Be a Member\n");
		System.out.print("\n4. Donate Now!\n");
		System.out.print("\n5. Be a volunteer\n");
		System.out.print("\n6. Apply to get donation\n");
		System.out.print("\n7. About us\n");
		System.out.print("\n8. Exit program\n");
		System.out.print("\n\tEnter your choice: ");
		int c = sc.nextInt(); //sc.close();
		Admin admin = new Admin();
		Member member = new Member();
		Volunteer vol = new Volunteer();
		Applicant app = new Applicant();
		Donation don = new Donation();
		if(c==1) admin.adminLogin();
		else if(c==2) member.memLogin();
		else if(c==3) member.createAcc();
		else if(c==4) don.donateNow();
		else if(c==5) vol.signUp();
		else if(c==6) app.apply();
		else if(c==7) about();
		else if(c==8) {
			System.out.println("\n\n\t\t\t\t====== Thanks for using Charity management system ======");
			System.exit(0);
		}
		else System.out.print("\n\t\tWrong choice! Please try again.\n");
	}
	public static void main(String[] args) throws IOException {
		System.out.print("\n\t\t\t\t:::::===::::: Welcome to Charity management system :::::===:::::\n\n");
		while(true) {
			mainMenu();
		}
	}
}
