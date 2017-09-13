package ej10963;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cc = 0;
		while (cc < n) {
			boolean z = true;
			scan.nextLine();
			scan.nextLine();
			int W = scan.nextInt();
			LinkedList<Integer> lista = new LinkedList<Integer>();
			for (int i = 0; i < W; i++) {
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				lista.add(num1 - num2);
			}
			int a = lista.get(0) - lista.get(1);
			for (int i = 0; i < (lista.size() - 2); i++) {
				int b = lista.get(i+1) - lista.get(i+2);
				if(a!=b){
					z=false;
				}
				
			}
			if(z){
				System.out.println();
				System.out.print("yes");
				cc++;
			}else{
				System.out.println();
				System.out.print("no");
				cc++;
			}

		}
	}
}
