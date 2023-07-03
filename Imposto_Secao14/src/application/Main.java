package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberTaxPayers = scn.nextInt();

        for (int i = 0; i < numberTaxPayers; i++) {
            System.out.printf("Tax payer #%d\n", i+1);
            System.out.print("Individual or company (i/c)?");
            char ch = scn.next().charAt(0);
            System.out.print("Name: ");
            scn.nextLine();
            String nome = scn.nextLine();
            System.out.print("Annual Income: ");
            double income = scn.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = scn.nextDouble();
                pessoas.add(new PessoaFisica(nome, income, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberEmployees = scn.nextInt();
                pessoas.add(new PessoaJuridica(nome, income, numberEmployees));
            }
        }
        scn.close();

        double totalTax = 0.0;
        for (Pessoa p : pessoas) {
            totalTax += p.totalPago();
        }

        System.out.println("TAXES PAID");
        for (Pessoa p : pessoas) {
            System.out.println(p.toString());
        }

        System.out.printf("\nTOTAL TAXES: $%.2f", totalTax);
    }
}