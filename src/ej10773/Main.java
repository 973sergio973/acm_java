package ej10773;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lim = scan.nextInt();
		for (int i = 0; i < lim; i++) {
			double distance = scan.nextInt();
			double riverS = scan.nextInt();
			double boatS = scan.nextInt();
			if (riverS < boatS && boatS > 0 && riverS > 0) {
				double time1 = distance / boatS;
				double time2 = distance / (Math.sqrt(Math.pow(boatS, 2) - Math.pow(riverS, 2)));
				System.out.println("Case " + (i + 1) + ": " + r(Math.abs(time2 - time1)));
			} else {
				System.out.println("Case " + (i + 1) + ": can't determine");
			}
		}
	}

	public static String r(double val) {
		return String.format("%.3f", val);
	}
}
