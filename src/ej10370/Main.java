package ej10370;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int casos = scan.nextInt();
		for (int i = 0; i < casos; i++) {
			double notas = scan.nextDouble();
			double[] a = new double[(int) notas];
			double suma = 0;
			for (int j = 0; j < notas; j++) {
				a[j] = scan.nextDouble();
				suma += a[j];
			}
			double promedio = suma / notas;
			double cont = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] > promedio) {
					cont++;
				}
			}

			double aux = cont / notas * 100;
			System.out.println(r(aux) + "%");
		}

	}

	public static String r(double val) {
		return String.format("%.3f", val);
	}

}
