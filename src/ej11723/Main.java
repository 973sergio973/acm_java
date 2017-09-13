package ej11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int cont = 1;
		while ((str = in.readLine()) != null & !"".equals(str) && cont < 10002) {
			String[] input = str.split("\\s+");
			double r = Double.parseDouble(input[0]);
			double n = Double.parseDouble(input[1]);
			if(r==0 && n==0){
				break;
			}
			if (n > r) {
				System.out.println("Case " + cont + ": 0");
			} else {
				int c = (int) Math.ceil((r - n) / n);
				if (c <= 26) {
					System.out.println("Case " + cont + ": " + c);
				} else {
					System.out.println("Case " + cont + ": impossible");
				}
			}
			cont++;
		}
	}
}
