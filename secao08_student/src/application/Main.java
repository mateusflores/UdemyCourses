package application;

import java.util.Scanner;

import entities.Student;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Student student = new Student();
		
		student.setName(scn.nextLine());
		student.setN1(scn.nextDouble());
		student.setN2(scn.nextDouble());
		student.setN3(scn.nextDouble());
		
		System.out.println(student.getName() + "\nFinal grade: " + student.getFinalGrade());
		
		if(student.isApproved()) {
			System.out.println("Approved!");
		} else {
			System.out.println("Failed\nMissing " + (60.0-student.getFinalGrade()) + " points");
		}

	}

}
