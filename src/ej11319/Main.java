package ej11319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final double minDelta = 1e4;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lim = Integer.parseInt(in.readLine());
		double[] testCase = new double[7]; //the test case of the sequence
		double[] seq = new double[1500]; //the whole sequence of numbers to be tested
		boolean is = false; //boolean to test if all the sequence is stupid
		for (int i = 0; i < lim; i++) { //start loop
			for (int j = 0; j < 1500; j++) { //fill sequence array
				seq[j] = Double.parseDouble(in.readLine());
			}
			for (int j = 0; j < testCase.length; j++) { //fill in the test case array
				testCase[j] = seq[j];
			}
			in.readLine(); //skip line
			double[] res = mult(invert(generateMatrix(1)), testCase); //theoretical reusult of the matrix invertion
			int[] res1 = new int[7]; //rounded result array
			int[] res2 = new int[7];//rounded result array for test
			for (int j = 0; j < res.length; j++) { //fill in the arrays
				res1[j] = round(res[j]);
				res2[j] = res1[j];
			}
			Arrays.sort(res2);//sort the first array, if the first position is greater than 1000 or negative
						   	//then the array is not tested and therefore the sequence is smart
			if ((res2[0] >= 0) && (res2[res2.length - 1] <= 1000)) {
				is = test(res1, seq); //implemet the test method
				if (is) { //print the result
					for (int j = 0; j < 7; j++) {
						System.out.print((j < 6 ? res1[j] + " " : res1[j] + "\n"));
					}
				} else {
					System.out.println("This is a smart sequence!");
				}
			} else {
				System.out.println("This is a smart sequence!");
			}
		}
	}
	
	private static boolean test(int[] res, double[] seq) {//this method testes all f(1),f(2),...,f(1500)
		for (int i = 0; i < seq.length; i++) {
			double aux = 0.0;
			for (int j = 0; j < 7; j++) {
				aux += res[j] * Math.pow(i + 1, j);
			}
			if (aux != seq[i] & Math.abs(aux - seq[i]) > minDelta) {
				return false;
			} else {
				aux = 0.0;
			}

		}
		return true;
	}

	private static int round(double d) {//faster round method
		double dAbs = d < 0 ? -d : d;
		int i = (int) dAbs;
		double result = dAbs - (double) i;
		if (result < 0.5) {
			return d < 0 ? -i : i;
		} else {
			return d < 0 ? -(i + 1) : i + 1;
		}
	}

	private static double[][] invert(double[][] mat) {//matrix invertion by determinants and cofactors
		double inv[][] = new double[mat.length][mat.length];
		double invdet = 1 / determinant(mat);
		for (int i = 0; i < inv.length; i++) {
			for (int j = 0; j < inv.length; j++) {
				inv[j][i] = (((i + j) % 2 == 0) ? 1 : -1) * invdet * determinant(submat(mat, i, j));
			}
		}
		return inv;
	}

	private static double[][] generateMatrix(double a) {//generates matrix for the test cases
		double[][] mat = new double[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				mat[i][j] = Math.pow(a, j);
			}
			a += 1;
		}
		return mat;
	}

	public static double[] mult(double[][] mat, double mat2[]) {// multiplies matrices of test case and generated
																//matrix
		double a[] = new double[7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				a[i] = a[i] + (mat[i][j] * mat2[j]);
			}
		}
		return a;
	}

	private static double determinant(double[][] matrix) {
		//recursive method for determinant
		if (matrix.length == 2)
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		double det = 0;
		for (int i = 0; i < matrix[0].length; i++)
			det += ((i % 2 == 0) ? 1 : -1) * matrix[0][i] * determinant(submat(matrix, 0, i));
		return det;
	}

	private static double[][] submat(double[][] matrix, int row, int column) {
		//generates submatrix for cofactors
		double[][] minor = new double[matrix.length - 1][matrix.length - 1];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; i != row && j < matrix[i].length; j++)
				if (j != column)
					minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
		return minor;
	}

}
