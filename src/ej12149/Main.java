package ej12149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = in.readLine()) != null) {
			int N = Integer.parseInt(str.trim());
			if (N == 0)
				break;
			System.out.println(((N)*(N+1)*((2*N)+1))/6);
		}

	}

}
