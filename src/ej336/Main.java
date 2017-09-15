package ej336;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int nc = scan.nextInt();
		int caseCont = 1;
		while (nc > 0) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < nc; i++) {
				int f = scan.nextInt();
				int t = scan.nextInt();
				if (!map.containsKey(f)) {
					map.put(f, new LinkedList<>());
				}
				map.get(f).add(t);
				if (!map.containsKey(t)) {
					map.put(t, new LinkedList<>());
				}
				map.get(t).add(f);
			}
			int o = scan.nextInt();
			int ttl = scan.nextInt();
			while (o != 0 || ttl != 0) {
				Map<Integer, Integer> distances = new HashMap<>();
				Queue<Integer> toVisit = new LinkedList<>();
				distances.put(o, 0);
				if (ttl > 0) {
					toVisit.add(o);
				}
				while (!toVisit.isEmpty()) {
					int current = toVisit.poll();
					if (map.get(current) != null) {
						for (int n : map.get(current)) {
							if (!distances.containsKey(n)) {
								int dc = distances.get(current);
								distances.put(n, dc + 1);
								if (dc + 1 < ttl) {
									toVisit.add(n);
								}
							}
						}
					}
				}
				int res = map.keySet().size() - distances.keySet().size();
				if (!map.containsKey(o)) {
					res++;
				}
				System.out.println("Case " + caseCont + ": " + res + " nodes not reachable from node " + o
						+ " with TTL = " + ttl + ".");
				o = scan.nextInt();
				ttl = scan.nextInt();
				caseCont++;
			}

			nc = scan.nextInt();
		}
	}

}
