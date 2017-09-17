package ej11805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lim = Integer.parseInt(in.readLine());
		for (int i = 0; i < lim; i++) {
			String[] input = in.readLine().split("\\s+");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			int p = Integer.parseInt(input[2]);
			System.out.println("Case " + (i + 1) + ": " + whom(n, k, p));
		}
	}

	private static int whom(int n, int k, int p) {
		int psc = p % n;
		psc += k;
		return psc > n ? psc - n : psc;
	}

}
