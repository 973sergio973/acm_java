package ej12502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lim = Integer.parseInt(in.readLine());
		for (int i = 0; i < lim; i++) {
			String[]input = in.readLine().split("\\s+");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int z = Integer.parseInt(input[2]);
			System.out.println(z*((2*x)-y)/(x+y));
		
		}

	}

}
