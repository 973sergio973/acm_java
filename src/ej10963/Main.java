package ej10963;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = scan.nextInt();
		while (testCase-- != 0) {
			int n = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			int d = a - b;
			boolean flag = true;
			for (int i = 0; i < n - 1; i++) {
				a = scan.nextInt();
				b = scan.nextInt();
				int temp = a - b;
				if (temp != d) {
					flag = false;
				}
			}
			if (flag)
				System.out.println("yes");
			else
				System.out.println("no");
			if (testCase != 0)
				System.out.println();
		}
	}
}
