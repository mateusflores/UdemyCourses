package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter how many employees will be registred: ");
		int n = scn.nextInt();
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println("\nEmployee #" + (i+1));
			System.out.print("ID: ");
			int id = checkId(employeeList);
			System.out.print("NAME: ");
			scn.nextLine();
			String name = scn.next();
			System.out.print("SALARY: ");
			double salary = scn.nextDouble();
			
			employeeList.add(new Employee(id, salary, name));
		}
		
		System.out.print("Enter the id that will have a salary increase: ");
		int id = scn.nextInt();
		
		while (!hasId(employeeList, id)) {
			System.out.println("Enter a valid ID");
			id = scn.nextInt();
		}
		
		System.out.println("Enter the percentage: ");
		double perc = scn.nextDouble();
		
		for (Employee employee:employeeList) {
			if (employee.getId() == id)
				employee.increaseSalary(perc);
		}
		
		System.out.println("List of employees: ");
		
		for (Employee employee:employeeList) {
			System.out.println(employee);
		}
		
		scn.close();
	}
	
	private static int checkId(ArrayList<Employee> list) {
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		for (int j=0; j<list.size(); j++) {
			if(list.get(j).getId() == id && list.get(j) != null) {
				while (list.get(j).getId() == id) {
					System.out.println("ERROR! Enter a different id.");
					id = sc.nextInt();
				}
			}
		}
		return id;
	}
	
	private static boolean hasId(ArrayList<Employee> list, int id) {
		for (Employee employee:list) {
			if (employee.getId() == id)
				return true;
		}
		return false;
	}
}
