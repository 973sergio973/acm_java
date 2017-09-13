package ej10055;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			long a = scan.nextLong();
			long b = scan.nextLong();
			System.out.println(a > b ? a-b : b-a);
			scan.nextLine();
		}
	}
}
