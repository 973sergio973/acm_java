package ej272;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line;
		boolean closed = false;
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			String ans = "";
			for (char c : line.toCharArray()) {
				if(c == '"') {
					if(closed) {
						ans += "''";
						closed = false;
					}else {
						ans += "``";
						closed = true;
					}
					
				}else {
					ans += c;
				}
			}
			System.out.println(ans);
			
		}

	}

}
