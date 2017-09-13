package ej11614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			double soldiers = Double.parseDouble(in.readLine());
			int n = (int)((-1+(Math.sqrt(1+(8*soldiers))))/2);
			System.out.println(n);
		}
	}

}
