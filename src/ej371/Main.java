package ej371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = in.readLine()) != null) {
			String[] input = str.split("\\s+");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if (a == 0 || b == 0) {
				break;
			}
			int max = a > b ? a : b;
			int min = a < b ? a : b;
			int[] maxCycles = { 0, 0 };// {number,cycles}
			for (int i = min; i <= max; i++) {
				if (i < 2) {
					if (3 > maxCycles[1]) {
						maxCycles[0] = i;
						maxCycles[1] = 3;
					}
				} else {
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
					if (cont > maxCycles[1]) {
						maxCycles[0] = i;
						maxCycles[1] = cont;

					}
				}
			}
			System.out.println("Between "+min+" and "+max+", "+maxCycles[0]
					+" generates the longest sequence of "+maxCycles[1]+" values.");
		}
	}
}
