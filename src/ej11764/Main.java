package ej11764;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int palabras = scan.nextInt();
		int casos = scan.nextInt();
		
		String[] a = new String[palabras];
		int[] b = new int[palabras];
		for (int i = 0; i < palabras; i++) {
			a[i] = scan.next();
			b[i] = scan.nextInt();
		}
		int cont = 0;
		int salario = 0;
		while (cont<casos) {
			String t = scan.next();
			if (t.equals(".")) {
				System.out.println(salario);
				cont++;
				salario = 0;
			}
			for (int i = 0; i < a.length; i++) {
				if (t.equals(a[i])){
					salario += b[i];
				}
			}
			
		}
	}

}
