package application;

import model.entities.Account;
import model.exceptions.DepositException;
import model.exceptions.WithdrawException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = scn.nextInt();

            System.out.print("Holder: ");
            scn.next();
            String holderName = scn.nextLine();

            System.out.print("Initial balance: ");
            Double initialBalance = scn.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = scn.nextDouble();

            Account account = new Account(number, holderName, initialBalance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            account.withDraw(scn.nextDouble());
            System.out.println("New balance: " + account.getBalance());

            System.out.print("\nEnter amount for deposit: ");
            account.deposit(scn.nextDouble());
            System.out.println("New balance: " + account.getBalance());
        } catch (WithdrawException | DepositException e) {
            System.out.println(e.getMessage());
        }

        scn.close();
    }
}