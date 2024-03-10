package stor;

import java.util.Scanner;

public class Lagrange {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter number of data: ");
		int n = sc.nextInt();
		float[] x = new float[n];
		float[] y = new float[n];
		System.out.println("Enter data (x,y) : ");
		for(int i=0; i<n; i++) {
			System.out.print("x"+(i+1) + " = ");
			x[i] = sc.nextFloat();
			System.out.print("y"+(i+1) + " = ");
			y[i] = sc.nextFloat();
		}
		
		System.out.println("Enter value of x corresponding to y:");
		float inputX = sc.nextFloat();
		float result = 0;
		for(int i=0; i<x.length; i++) {
			float term = y[i];
			for(int j=0; j<x.length; j++) {
				if (j!=i) {
					term *= (inputX - x[j]) / (x[i]-x[j]);
				}
			}
			result += term;
		}
		
		System.out.println("The value of y at x = " + inputX + "is" + result);
	}
}
