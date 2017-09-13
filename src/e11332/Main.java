package e11332;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		while(a!=0){
			
			int res = sum(a);
			
			
			System.out.println(res);
			a = scan.nextInt();
		}
	}
	public static int sum(int a){
		int res = 0;
		while(a>9){
			res = res+ (a%10);
			a = a/10;
		}
		res = res+ (a%10);
		if(res<=9){
			return res;
		}else{
			res = sum(res);
		}
		return res;
	}
}
