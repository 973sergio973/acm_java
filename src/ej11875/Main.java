package ej11875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lim = Integer.parseInt(in.readLine());
		for (int i = 0; i < lim; i++) {
			String[] input = in.readLine().split("\\s+");
			int N = Integer.parseInt(input[0]);
			int[] players = new int[N];
			for (int j = 1; j < input.length; j++) {
				players[j-1] = Integer.parseInt(input[j]);
			}
			int captain = (int) Math.ceil(players.length/2);
			System.out.println("Case " + (i+1) + ": " + players[captain]);
		}
	}

}
