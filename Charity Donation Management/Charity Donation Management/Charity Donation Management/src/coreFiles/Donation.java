package coreFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Donation {
	private long totalFund;
	
	void donateNow() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\t\tChoose your doation method:\n1.Mobile banking\n2.Bank account\nEnter your choice: ");
		int c = sc.nextInt();
		long amnt=0;
		if(c==1) {
			System.out.print("\nPlease send your donation to 0123456789\n");
			System.out.print("Enter the amount: ");
			amnt = sc.nextLong();
			totalFund = getTotalFund() + amnt;
			setTotalFund(totalFund);
			System.out.print("\n\n\t\tThanks for donation\n\n");
		}
		else if(c==2) {
			System.out.print("\nPlease send your donation to the account number 0123456789\n");
			System.out.print("Enter the amount: ");
			amnt = sc.nextLong();
			totalFund = getTotalFund() + amnt;
			setTotalFund(totalFund);
			System.out.print("\n\n\t\tThanks for donation\n\n");
		}
		else {
			System.out.print("\n\tWrong choice! Please try again\n");
		}
		//sc.close();
	}

	public long getTotalFund() throws NumberFormatException, IOException {
		FileReader in = new FileReader("donation.txt");
		BufferedReader br = new BufferedReader(in);
		String record;
		while ((record = br.readLine()) != null) {
		    totalFund = Long.parseLong(record);
		}		
		br.close();
		
		return totalFund;
	}

	public void setTotalFund(long totalFund) throws IOException {
		this.totalFund = totalFund;
		String str = Long.toString(this.totalFund)+"\n";
	    BufferedWriter writer = new BufferedWriter(new FileWriter("donation.txt"));
	    writer.write(str);
	    writer.close();
	}
}
