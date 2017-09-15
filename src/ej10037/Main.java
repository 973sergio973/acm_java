package ej10037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lim = Integer.parseInt(in.readLine());
		for (int i = 0; i < lim; i++) {
			in.readLine(); //ignores a line
			
			int n = Integer.parseInt(in.readLine()); //reads the sample size
			int people[] = new int[n]; //people array
			
			for (int j = 0; j < n; j++) {
				people[j] = Integer.parseInt(in.readLine()); //fill up the people array
			}
			
			Arrays.sort(people); //sorting people
			
			crossTheBridge(people, people.length); //make people cross the bridge
			System.out.print((i != lim - 1) ? "\n" : ""); //print a space between cases	
		}
	}

	private static void crossTheBridge(int[] people, int n) {
		
		int time = 0; //total time of case
		int crossed = 0; //number of people that have crossed the bridge
		
		String strat = new String();//strategy querry
		
		while ((n-crossed)>=4) {
			int ta = (people[1] * 2) + people[0] + people[people.length - crossed - 1];
			int tb = people[n - crossed - 1] + (people[0] * 2) + people[n - crossed - 2];
			/*verifies two main ways of crossing the bridge
			*one where the fastest two persons cross the bridge, the fastest brings the
			*flashlight back and then the slowest two cross the bridge, then the fastest
			*person on the other side brings the flashlight back
			*
			*the second where the fastest person makes several trips bringing the slowest
			*ones first*/
			if (ta < tb) { //ask which case is the optimal
				time += ta;
				//querry for answer
				strat = strat + people[0] + " " + people[1] + "\n" 
							+ people[0] + "\n"
							+ people[(n - crossed) - 2] + " "+ people[(n - crossed) - 1] + "\n" 
							+ people[1] + "\n";
			} else {
				time += tb;
				//querry for answer
				strat = strat + people[0] + " " + people[n - crossed - 1] + "\n" 
							+ people[0] + "\n" 
							+ people[0] + " "+ people[n - crossed - 2] + "\n" 
							+ people[0] + "\n";

			}
			crossed += 2; //on any case the number of persons to cross is 2
		}
		
		//when there are only 3, 2 or 1 people left, then the cases are limited:
		if ((n - crossed) == 3) { //(n-crossed) is the number of persons left to cross
			time += people[0]+people[1]+people[2];
			//querry for answer
			strat = strat + people[0] + " " + people[1] + "\n" 
						+ people[0] + "\n" 
						+ people[0] + " "+ people[2] + "\n";
			
		} else if ((n - crossed) == 2) {
			time+=people[1];
			//querry for answer
			strat = strat + people[0] + " " + people[1] + "\n";
		} else if ((n - crossed) == 1) {
			time+=people[0];
			//querry for answer
			strat = strat + people[0] + "\n";
		}
		//print the answer
		System.out.println(time);
		System.out.print(strat);
	}
}
