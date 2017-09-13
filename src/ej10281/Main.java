package ej10281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str;
		double v = 0;
		double x = 0;
		double secs = 0;
		double secs0 = 0;
		while ((str = in.readLine()) != null && !"".equals(str)) {
			String[] input = str.split("\\s+");
			if (input.length == 1) {
				secs = time(input[0]);
				x += (secs - secs0) * (v/3.6);
				System.out.println(input[0] + " " +r(x/1000) + " km");
				secs0 = secs;
			} else if(input.length > 1){
				secs = time(input[0]);
				x += (secs - secs0) * (v/3.6);
				v = Double.parseDouble(input[1]);
				secs0 = secs;
			}
		}

	}

	public static String r(double val) {
		return String.format("%.2f", val);
	}

	public static double time(String in) {
		double secs = 0;
		String[] time = in.split(":");
		secs += Double.parseDouble(time[0]) * 3600 + Double.parseDouble(time[1]) * 60 + Double.parseDouble(time[2]);
		return secs;
	}

}
