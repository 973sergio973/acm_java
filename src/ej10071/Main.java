package ej10071;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int speed = scan.nextInt();
			int time = scan.nextInt();
			int res = 2*speed*time;
			System.out.println(res);
		}
	}
}
