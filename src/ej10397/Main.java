package ej10397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int[] chief;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int n = 0;
		while (str != null && !"".equals(str) && !"\n".equals(str)) {
			if (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n")) {
				do {
					str = in.readLine();
				} while (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n"));
				n = Integer.parseInt(str);
			} else {
				n = Integer.parseInt(str);
			}
			int[][] xy = new int[n][2];

			for (int i = 0; i < n; i++) {
				str = in.readLine();
				if (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n")) {
					do {
						str = in.readLine();
					} while (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n"));
				}
				String[] input = str.split("\\s+");
				xy[i][0] = Integer.parseInt(input[0]);
				xy[i][1] = Integer.parseInt(input[1]);

			}
			double[][] g = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						double dx = xy[i][0] - xy[j][0];
						double dy = xy[i][1] - xy[j][1];
						g[i][j] = Math.sqrt((dx * dx) + (dy * dy));
					}
				}
			}
			chief = new int[g.length];
			for (int i = 0; i < g.length; i++) {
				chief[i] = i;
			}
			str = in.readLine();
			if (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n")) {
				do {
					str = in.readLine();
				} while (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n"));
			}
			String[] input;
			int c = Integer.parseInt(str);
			for (int i = 0; i < c; i++) {
				str = in.readLine();
				if (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n")) {
					do {
						str = in.readLine();
					} while (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n"));
				}
				input = str.split("\\s+");
				int j = lookForChief(Integer.parseInt(input[0]) - 1);
				int j1 = lookForChief(Integer.parseInt(input[1]) - 1);
				chief[j] = j1;
			}
			System.out.println(r(kruskal(g)));
			str = in.readLine();
			if (str.isEmpty() || str.trim().equals("") || str.trim().equals("\n")) {
				int cont = 0;
				do {
					str = in.readLine();
					cont++;
				} while ((str.isEmpty() || str.trim().equals("") || str.trim().equals("\n")) && cont < 1);
			}
		}

	}

	public static String r(double val) {
		return String.format("%.2f", val);
	}
	/*
	 * 
	 *
	 * Credits to: Alexis Marechal
	 * 
	 * 
	 */

	public static double kruskal(double[][] g) {
		List<Edge> ans = new LinkedList<>();
		int aristas = 0;
		for (int i = 0; i < chief.length; i++) {
			if (chief[i] == i) {
				aristas++;
			}
		}
		List<Edge> edges = new LinkedList<>();
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				if (g[i][j] > 0) {
					edges.add(new Edge(i, j, g[i][j]));
				}
			}
		}
		Collections.sort(edges);
		double l = 0;
		int i = 0;
		while (i < aristas - 1) {

			Edge p = edges.remove(0);

			int j1 = lookForChief(p.getF());
			int j2 = lookForChief(p.getT());
			if (j1 != j2) {
				chief[j1] = j2;
				ans.add(p);
				l += p.getW();
				i++;
			}

		}
		return l;
	}

	public static int lookForChief(int i) {
		while (chief[i] != i) {
			i = chief[i];
		}
		return i;
	}

}

class Edge implements Comparable<Edge> {
	private int f, t;
	private double w;

	public Edge(int f, int t, double w) {
		this.f = f;
		this.t = t;
		this.w = w;
	}

	public int getF() {
		return f;
	}

	public int getT() {
		return t;
	}

	@Override
	public int compareTo(Edge other) {
		if (this.w < other.getW()) {
			return -1;
		} else {
			return 1;
		}
	}

	public double getW() {
		return w;
	}

	@Override
	public String toString() {
		return ((t + 1) + " " + (f + 1) + " : " + w);

	}

}
