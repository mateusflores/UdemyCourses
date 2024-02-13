package Application;

import java.util.Scanner;

import Entities.Person;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Insira o numero de pessoas: ");
		int n = scn.nextInt();
		Person[] person = new Person[n];

		
			
		for (int i=0; i<n; i++) {
			System.out.printf("\nInsira o nome da %dº pessoa: ", i+1);
			scn.nextLine();
			String nome = scn.nextLine();
			System.out.printf("Insira a idade da %dº pessoa: ", i+1);
			int idade = scn.nextInt();
			System.out.printf("Insira a altura da %dº pessoa: ", i+1);
			double altura = scn.nextDouble();
			
			person[i] = new Person(nome, idade, altura);
		}
		
		double somaAltura = 0.0;
		int quantMenores = 0;
		
		for (int i=0; i<person.length; i++) {
			somaAltura += person[i].getHeight();
			
			if (person[i].getAge() < 16)
				quantMenores = quantMenores + 1;
		}
		
		double mediaAltura = somaAltura/person.length;
		double porcentagem = (double) quantMenores / n * 100;
		
		System.out.printf("\nA média das alturas é %.2f metros.\n", mediaAltura);
		System.out.printf("%.2f%% das pessoas tem menos de 16 anos.\n", porcentagem);
		System.out.println("As pessoas com menos de 16 anos são: ");
		
		for (int i=0; i<person.length; i++) {
			if (person[i].getAge() < 16) {
				System.out.println(person[i].getName());
			}
		}
		
		scn.close();
	}

}
