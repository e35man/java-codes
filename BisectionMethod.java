package stor;
import java.util.Scanner;

public class BisectionMethod {

	static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the degree of the polynomial: ");
        int degree = scanner.nextInt();
        
        double[] coefficients = new double[degree + 1];
        for (int i = 0; i <= degree; i++) {
            System.out.print("Enter coefficient for x^" + i + ": ");
            coefficients[i] = scanner.nextDouble();
        }
        
        double ans1, ans2, x0 = 0, pX0;
        double x1 = 0, x2 = 0;
        
        while (true) {
            System.out.print("Enter the lower limit: ");
            x1 = scanner.nextDouble();
            System.out.print("Enter the upper limit: ");
            x2 = scanner.nextDouble();
            
            ans1 = calculatePolynomial(x1, coefficients, degree);
            ans2 = calculatePolynomial(x2, coefficients, degree);
            
            if (ans1 * ans2 < 0) {
                break;
            } else {
                System.out.println("The chosen limits do not bracket a root. Please enter new limits.");
            }
        }

        System.out.println(" x1 \t x2 \t x0 \t pX0");
        while (Math.abs(x1 - x2) >= 0.0005) {
            x0 = (x1 + x2) / 2;
            pX0 = calculatePolynomial(x0, coefficients, degree);
            System.out.println(x1 + "\t" + x2 + "\t" + x0 + "\t" + pX0);
            
            if (pX0 < 0) {
                x2 = x0;
            } else {
                x1 = x0;
            }
        }
        
        System.out.println("Answer is " + x0);
    }

    static double calculatePolynomial(double x0, double[] coefficients, int degree) {
        double ans = 0.0;
        for (int i = 0; i <= degree; i++) {
            ans += Math.pow(x0, degree - i) * coefficients[i];
        }
        return ans;
    }
}
