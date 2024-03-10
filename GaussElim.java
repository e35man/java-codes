package stor;
import java.util.Scanner;

public class GaussElim{
    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the order of the matrix = ");
        int n = sc.nextInt();
        float[][] mat = new float[n][n + 1];
        
        // Input matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.println("Row [" + (i + 1) + "] Col [" + (j + 1) + "] = ");
                mat[i][j] = sc.nextFloat();
            }
        }
        
        // Perform Gauss elimination
        for (int i = 0; i < n; i++) {
            float pivot = mat[i][i];
            for (int j = i; j <= n; j++) {
                mat[i][j] /= pivot;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    float factor = mat[k][i];
                    for (int j = i; j <= n; j++) {
                        mat[k][j] -= factor * mat[i][j];
                    }
                }
            }
        }
        
        // Output the result
        System.out.println("The matrix after Gauss elimination:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
