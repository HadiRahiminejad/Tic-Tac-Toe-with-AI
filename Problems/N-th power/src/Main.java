import java.util.Scanner;

public class Main {

    public static double pow(double a, long n) {
        // write your code here
        double result = 1;
        if (n == 0) return 1;
        else if (n % 2 == 0) {
            result *= pow(a, n / 2);
            return result * result;
        }

        return a * pow(a, n - 1);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = Double.parseDouble(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(a, n));
    }
}
