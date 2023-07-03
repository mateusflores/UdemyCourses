import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = 0;
		
		System.out.println("Digite o número de entradas: (max de 10)");
		n = scn.nextInt();
		if (n > 10)
			n = 10;
		
		int[] array = new int[n];
		
		System.out.println("Insira os valores:");
		for (int i=0; i<array.length; i++) {
			array[i] = scn.nextInt();
		}
		
		System.out.println("Os números negativos digitados foram:");
		for (int i=0; i<array.length; i++) {
			if (array[i] < 0)
				System.out.println(array[i]);
		}
		
		scn.close();
	}

}
