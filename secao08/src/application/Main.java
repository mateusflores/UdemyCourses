package application;

import java.util.Scanner;

import entities.Person;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Person person = new Person();
		String name;
		double grossSalary;
		
		System.out.println("Name: ");
		name = scn.nextLine();
		person.setName(name);
		System.out.println("Gross salary: ");
		grossSalary = scn.nextDouble();
		person.setGrossSalary(grossSalary);
		
		System.out.printf("Employee: %s,  %.2f\n", person.getName(), person.netSalary());
		
		System.out.println("Which percentage to increase salary?");
		double percentage = scn.nextDouble();
		person.increaseSalary(percentage);
		
		System.out.printf("Updated data: %s,  %.2f\n", person.getName(), person.netSalary());
		scn.close();
	}

}
