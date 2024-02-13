package app;

import java.util.Scanner;

import util.Client;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Client client;
		
		System.out.print("Enter account number: ");
		int accountNumber = scn.nextInt();
		scn.nextLine();
		System.out.print("\nEnter account holder: ");
		String name = scn.nextLine();
		System.out.println("\nIs there an inicial deposit? (y/n)");
		char answer = scn.next().charAt(0);
		if(answer == 'y') {
			System.out.print("\nEnter the initial deposit value: ");
			double inicialDeposit = scn.nextDouble(); 
			client = new Client(name, accountNumber, inicialDeposit);
		} else {
			client = new Client(name, accountNumber);
		}
		
		System.out.println("Account data:");
		System.out.println(client);
		
		System.out.print("\nEnter deposit value: ");
		client.deposit(scn.nextDouble());
		
		System.out.println("Updated account data: ");
		System.out.println(client);
		
		System.out.print("\nEnter a withdraw value: ");
		client.withdraw(scn.nextDouble());
		
		System.out.println("Updated account data: ");
		System.out.println(client);
		
		scn.close();
	}

}
