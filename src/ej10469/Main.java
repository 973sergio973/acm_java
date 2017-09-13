package ej10469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = in.readLine()) != null && !"".equals(str)) {
			String[] input = str.split("\\s+");
			String a = Integer.toBinaryString(Integer.parseInt(input[0]));
			String b = Integer.toBinaryString(Integer.parseInt(input[1]));
			for (int i = a.length(); i < 32; i++) {
				a = "0" + a;
			}
			for (int i = b.length(); i < 32; i++) {
				b = "0" + b;
			}
			String res = "";
			for (int i = 0; i < 32; i++) {
				if (a.charAt(i) == '0') {
					res = res + b.charAt(i);
				} else {
					if (b.charAt(i) == '0') {
						res = res + a.charAt(i);
					} else {
						res = res + '0';
					}
				}
			}
			long decRes = 0;
			for (int i = 32; i > 0; i--) {
				decRes += round(Double.parseDouble("" + res.charAt(i - 1))*Math.pow(2, 32 - i));
			}
			System.out.println(decRes);
			res = "";
		}

	}

	private static long round(double d) {// faster round method
		double dAbs = d < 0 ? -d : d;
		long i = (long) dAbs;
		double result = dAbs - (double) i;
		if (result < 0.5) {
			return d < 0 ? -i : i;
		} else {
			return d < 0 ? -(i + 1) : i + 1;
		}
	}

}
