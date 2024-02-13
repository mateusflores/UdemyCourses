package application;

import java.util.Scanner;

import entities.Students;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Students[] students = new Students[10];
		
		System.out.println("Enter the number of students: ");
		int num = scn.nextInt();
		
		for(int i=0; i<num; i++) {
			scn.nextLine();
			System.out.printf("\nEnter the name of the %d student: ", i+1);
			String name = scn.nextLine();
			System.out.print("Enter the email of the student: ");
			String email = scn.nextLine();
			System.out.print("Enter the room: ");
			int room = scn.nextInt();
			
			students[room] = new Students(name, email, room);
		}
		
		System.out.println("\nBusy rooms:");
		for (int i=0; i<10; i++) {
			if (students[i] != null) {
				System.out.println(students[i]);
			}
		}
		scn.close();
	}

}
