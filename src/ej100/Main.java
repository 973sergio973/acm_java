package ej100;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int iterations = 0;
			int nMin = Math.min(a, b);
			//int nMin = a < b ? a : b;
			int nMax = Math.max(a, b);
			for (int i = nMin; i <= nMax; i++) {
				int cont = 0;
				int number = i;
				while (number > 1) {
					if (number % 2 > 0) {
						number = (3 * number + 1) / 2;
						cont += 2;
					} else {
						number = number / 2;
						cont++;
					}
				}
				if (cont > iterations) {
					iterations = cont;
				}
			}
			System.out.println(a + " " + b + " " + (iterations + 1));
		}
		scan.close();
	}

}