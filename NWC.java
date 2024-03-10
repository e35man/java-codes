package stor;

import java.util.Scanner;

public class NWC {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Enter supply count = ");
		int supply = sc.nextInt();
		System.out.print("Enter demand count = ");
		int demand = sc.nextInt();
		
		int [] supp = new int [supply];
		int [] demd = new int [demand];
		
		System.out.println("Enter supplies: ");
		for(int i=0; i<supply; i++) {
			System.out.println("Supply " + (i + 1) + " = ");
			supp[i] = sc.nextInt();
		}
		System.out.println("Enter demands: ");
		for(int i=0; i<demand; i++) {
			System.out.println("Demand " + (i + 1) + " = ");
			demd[i] = sc.nextInt();
		}
		int [][] table = new int [supply][demand];
		for(int i=0; i<supply; i++) {
			for(int j=0; j<demand; j++) {
				System.out.println("Table [" + (i + 1) + "][" + (j + 1) + "] = ");
				table[i][j] = sc.nextInt();
			}
		}
		
		int totalCost = 0;
		int i = 0, j = 0;
		while(i < supply && j < demand) {
			if(supp[i] > demd[j]) {
				totalCost += demd[j]*table[i][j];
				supp[i] = supp[i] - demd[j];
				demd[j] = 0;
				j++;
			}
			else {
				totalCost += supp[i]*table[i][j];
				demd[j] = demd[j] - supp[i];
				supp[i] = 0;
				i++;
			}
		}
		System.out.println(totalCost);		
	}
}
