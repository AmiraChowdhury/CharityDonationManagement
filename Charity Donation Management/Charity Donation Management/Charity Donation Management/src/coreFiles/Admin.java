package coreFiles;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
	private String adminID = "admin";
	private String adminPass = "1234admin";
	private boolean adminLogged = false;// admin login status
	
	public void adminMenu() throws NumberFormatException, IOException {
		System.out.print("\n1. See members' info\n");
		System.out.print("\n2. See volunteers' info\n");
		System.out.print("\n3. See applicants' info\n");
		System.out.print("\n4. See donations\n");
		System.out.print("\n5. Add donation\n");
		System.out.print("\n6. Remove donation\n");
		System.out.print("\n7. Logout and go to main menu\n");
		
	}
	
	public void adminLogin() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\tPlease enter admin login info\n");
		System.out.print("Admin ID: ");
		String id = sc.next();
		System.out.print("Admin Password: ");
		String pass = sc.next();
		//sc.close();
		if(id.equals(adminID) && pass.equals(adminPass)) {
			adminLogged = true;
			System.out.print("\n\t\tSuccessfully logged in as Admin\n");
			while(true) {
				adminMenu();
				System.out.print("\n\tEnter your choice: ");
				int c = sc.nextInt(); //sc.close();
			
				if(c==1) seeMemberInfo();
				else if(c==2) seeVolunteerInfo();
				else if(c==3) seeApplicantInfo();
				else if(c==4) seeDonation();
				else if(c==5) addDonation();
				else if(c==6) removeDonation();
				else if(c==7) {
					adminLogout(); break;
				}
				else System.out.print("\n\tWrong choice! Please try again.\n");
			}
		}
		else {
			System.out.print("\n\tWrong ID or Password. Please try again.\n");			
		}
	}
	
	public void adminLogout() {
		adminLogged = false;
		System.out.print("\n\tSuccessfully logged out from Admin mode\n");
	}
	
	public void seeMemberInfo() throws IOException {
		if(adminLogged) {
			System.out.print("\nMembers' data:\n\n");
			FileReader in = new FileReader("member.txt");
			BufferedReader br = new BufferedReader(in);
			String record;
			while ((record = br.readLine()) != null) {
			    System.out.println(record);
			}
			br.close();
		}
		else {
			System.out.print("\nPlease login as admin first.\n");
		}
	}
	
	public void seeVolunteerInfo() throws IOException {
		if(adminLogged) {
			System.out.print("\nVolunteers' data:\n\n");
			FileReader in = new FileReader("volunteer.txt");
			BufferedReader br = new BufferedReader(in);
			String record;
			while ((record = br.readLine()) != null) {
			    System.out.println(record);
			}
			br.close();
		}
		else {
			System.out.print("\nPlease login as admin first.\n");
		}
	}
	
	public void seeApplicantInfo() throws IOException {
		if(adminLogged) {
			System.out.print("\nApplicants' data:\n\n");
			FileReader in = new FileReader("applicant.txt");
			BufferedReader br = new BufferedReader(in);
			String record;
			while ((record = br.readLine()) != null) {
			    System.out.println(record);
			}
			br.close();
		}
		else {
			System.out.print("\nPlease login as admin first.\n");
		}
	}
	
	public void seeDonation() throws NumberFormatException, IOException {
		Donation ob = new Donation();
		System.out.println("\n\tTotal Fund: "+ob.getTotalFund());
	}
	
	public void addDonation() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		Donation ob = new Donation();
		System.out.print("\n\tEnter the amout to be added: ");
		long amt = sc.nextLong();
		//sc.close();
		ob.setTotalFund(ob.getTotalFund()+amt);
		System.out.println("\n\tDonation added successfully. Current amount: "+ob.getTotalFund());
	}
	
	public void removeDonation() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		Donation ob = new Donation();
		System.out.print("\n\tEnter the amout to be removed: ");
		long amt = sc.nextLong();
		//sc.close();
		if(amt<=ob.getTotalFund()) {
			ob.setTotalFund(ob.getTotalFund()-amt);
			System.out.println("\n\tDonation removed successfully. Current amount: "+ob.getTotalFund());
		}
		else
			System.out.print("\n\tFund is not enough. Can't remove!\n");
		
	}
}
