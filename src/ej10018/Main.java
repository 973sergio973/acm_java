package ej10018;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int casos = scan.nextInt();
		long cont = 0;
		for (int i = 0; i < casos; i++) {
			long a = scan.nextLong();
			a += reverse(a);
			while (true) {
				if (a == reverse(a)) {
					System.out.println((cont+1) + " " + a);
					cont = 0;
					break;
				}else{
					a += reverse(a);
					cont++;
				}
			}
		}
	}

	public static long reverse(long num) {
		long res = 0;
		while (num > 0) {
			long aux = num % 10;
			res = (res + aux) * 10;
			num = (num - aux) / 10;
		}
		return res / 10;
	}

}
